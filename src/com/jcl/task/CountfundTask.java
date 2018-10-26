package com.jcl.task;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jcl.dao.FundSettlelogMapper;
import com.jcl.dao.SubzhContractMapper;
import com.jcl.dao.SubzhMapper;

import com.jcl.pojo.FundSettlelog;
import com.jcl.pojo.FundSettlelogExample;
import com.jcl.pojo.FundSettlelogExample.Criteria;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhContract;
import com.jcl.tradedao.HisTradeMapper;
import com.jcl.tradedao.SettleInfoMapper;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.StringUtil;

@Component 
public class CountfundTask {

	
	public static Logger log = Logger.getLogger(CountfundTask.class);
	@Autowired
	private SettleInfoMapper funddao;

	@Autowired
	private HisTradeMapper dealdao;

	@Autowired
	private SubzhMapper subzhdao;
	@Autowired
	private FundSettlelogMapper fundSettlelogMapper;
	@Autowired
	private SubzhContractMapper subzhContractMapper;
	
	@Resource(name = "dsForStock")
	private Datastore dsForStock;
	
	Map<String,Subzh> storeSubzhs=new HashMap<String,Subzh>();
	public static final  String EXCHANGE_RATE=DeployProperties.getInstance().getPublicexchange_rate();//汇率

	
	
	//保存手续费的定时任务
	@Scheduled(cron="00 30 06 * * ? ")   //早上6.30执行
	public void countPoundage() {
		List<FundSettlelog> flist=null;

		try {
			log.info("保存手续费的定时任务开始");
			
			FundSettlelogExample example=new FundSettlelogExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andSettletimeBetween(DateUtil.getDayMin(new Date(),-1), new Date());
			
			log.info("开始"+DateUtil.getDayMin(new Date(),-1)+"==》结束"+new Date());
			flist=fundSettlelogMapper.selectByExample(example);
			log.info("查询手续费分成报表==》"+flist.size());
			Subzh subzh;
			for (FundSettlelog fundSettlelog : flist) {						
			subzh=subzhdao.selectBySubzh(fundSettlelog.getSubzh());
			
			log.info("当前用户==》"+subzh);
			log.info("合约编号==》"+fundSettlelog.getSettledesc());
			String[] str = fundSettlelog.getSettledesc().split(" ");
			log.info("合约品种==》"+str[0]);
			

			if(null!=subzh&&!StringUtil.isAnyNullOrEmpty(str[0])) {
				log.info("手续费分成开始====>");
				
				//经纪人手续费分成
				if(subzh.getAllocbroker()!=null) {
					//按合约品种和经纪人名称去查询合约成本
					SubzhContract sc=subzhContractMapper.selectOneByNameAndSubzh(str[0], subzh.getAllocbroker());
					if(null!=sc) {
						//计算经纪人的手续费成本
						BigDecimal overfund=sc.getCost().multiply(fundSettlelog.getFeebalance());
						//计算经纪人残留手续费=手续费总额-经纪人手续费成本
						BigDecimal overbalance = fundSettlelog.getDeferredbalance().subtract(overfund);
						if(overbalance.doubleValue()<=0) {//判断经济人残留手续费是否大于0
							fundSettlelog.setOverbalance(new BigDecimal(0));
						}else {
							fundSettlelog.setOverbalance(overbalance);
						}
						
					}
				}
			
				//代理商手续费分成
				if(subzh.getAllocagent()!=null) {
					//按合约品种和代理商名称去查询合约成本
					SubzhContract sc=subzhContractMapper.selectOneByNameAndSubzh(str[0], subzh.getAllocagent());
					if(null!=sc) {
						//计算经纪人的成本
						BigDecimal fund=fundSettlelog.getDeferredbalance().subtract(fundSettlelog.getOverbalance());
						if(fund.doubleValue()>0) {
							//计算代理商手续费成本
							BigDecimal addfund=sc.getCost().multiply(fundSettlelog.getFeebalance());
							//计算代理商残留手续费=经纪人成本-代理商成本
							BigDecimal addbalance = fund.subtract(addfund);
							if(addbalance.doubleValue()<=0) {
								fundSettlelog.setAddbalance(new BigDecimal(0));
							}else {
								fundSettlelog.setAddbalance(addbalance);							
							}
						}
						
					}
				}	

			//渠道的手续费分成
			if(subzh.getAllocchannel()!=null) {
				//按合约品种和渠道名称去查询合约成本
				SubzhContract sc=subzhContractMapper.selectOneByNameAndSubzh(str[0], subzh.getAllocchannel());
				if(null!=sc) {
					//计算出代理商的成本
					BigDecimal fund=fundSettlelog.getDeferredbalance().subtract(fundSettlelog.getOverbalance()).subtract(fundSettlelog.getAddbalance());
					if(fund.doubleValue()>0) {
						//计算渠道手续费成本
						BigDecimal addfund=sc.getCost().multiply(fundSettlelog.getFeebalance());
						//渠道残留手续费=代理商成本-渠道成本
						BigDecimal feenextbalance=fund.subtract(addfund);
						if(feenextbalance.doubleValue()<=0) {//如果残留手续费为0，则渠道不分成手续费
							fundSettlelog.setFeenextbalance(new BigDecimal(0));
						}else {
							fundSettlelog.setFeenextbalance(feenextbalance);
						}
					}					
				
				}	
			}

			try {
				int num=fundSettlelogMapper.updateByPrimaryKeySelective(fundSettlelog);
				log.info("fundSettlelogMapper--修改用户的手续费分成信息："+num);
			} catch (Exception e) {
				
				log.error("保存手续费发生异常", e);
					}
				}
		   }
			List<Subzh>slist=subzhdao.selectByExample(null);
			if(slist!=null&&slist.size()>0) {
				for (Subzh sub : slist) {
					if(sub!=null&&sub.getIsadmin()==3) {//渠道
						sumfundbalance("allocchannel",sub.getSubzh(),"feenextbalance");
					}else if(sub!=null&&sub.getIsadmin()==4) {
						sumfundbalance("agentzh",sub.getSubzh(),"addbalance");
					}else if(sub!=null&&sub.getIsadmin()==5) {
						sumfundbalance("allocbroker",sub.getSubzh(),"overbalance");
					}
				}
			}
		} catch (Exception e) {
			log.error("保存手续费发定时任务生异常", e);
		}
	
	}
	

	/**
	 * 汇总手续费保存到对应的用户的fundbalance字段
	 * @param role 传入需要统计金额的角色
	 * @param username  角色对应的用户名
	 * @param columnName 需要资金的列名
	 * @return
	 */
	public String sumfundbalance(String role,String username,String columnName) {
		try {
			Subzh subzh = subzhdao.selectBySubzh(username);
			if(subzh==null) {
				log.info("查询用户信息为null");
				return "error";
			}
			Date starttime = DateUtil.getDayMin(new Date(),-1);
			Date  endtime= new Date();
			Double sumMoney= fundSettlelogMapper.selectSumMoney(role,username,columnName,starttime,endtime);
			log.info("汇总金额--sumMoney:"+sumMoney);
			sumMoney=sumMoney==null?0.00:sumMoney;
			if(subzh.getFundbalance()==null) {
				subzh.setFundbalance(new BigDecimal(sumMoney).multiply(new BigDecimal(EXCHANGE_RATE)));
			}else {
				//美元换算成人民币
				subzh.setFundbalance((new BigDecimal(sumMoney).multiply(new BigDecimal(EXCHANGE_RATE))).add(subzh.getFundbalance()));
			}
			int num=subzhdao.updateByPrimaryKeySelective(subzh);
			log.info("updateByPrimaryKeySelective--给指定用户加手续费分成资金："+num);
		} catch (Exception e){
			
			log.error("计算用户资金异常",e);
		}
		return null;
	}
}