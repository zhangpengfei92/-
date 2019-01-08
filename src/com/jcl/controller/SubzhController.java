/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : SubzhController.java
 * 功能概要  : 账户信息 管理Controller类
 * 做成日期  : 2018年04月08日 
 * 修改日期  :
 */
package com.jcl.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.authdao.UserInfoMapper;
import com.jcl.comm.PaginationContext;
import com.jcl.dao.Feetemplate_menuMapper;
import com.jcl.pojo.Bdzh;
import com.jcl.pojo.BzjmbMenu;
import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.Feetemplate_menu;
import com.jcl.pojo.Feetemplate_menuExample;
import com.jcl.pojo.Holder;
import com.jcl.pojo.Permission;
import com.jcl.pojo.PreMenu;
import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhPreMenu;
import com.jcl.pojo.UserInfo;
import com.jcl.pojo.UserInfoExample;
import com.jcl.pojo.UserInfoExample.Criteria;
import com.jcl.service.BdzhService;
import com.jcl.service.BzjmbMenuService;
import com.jcl.service.CodefeesetMenuService;
import com.jcl.service.PreMenuService;
import com.jcl.service.RiskTempallService;
import com.jcl.service.SubzhService;
import com.jcl.service.UserInfoService;
import com.jcl.stock.simulate.BussinessException;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.Util;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.Constant;
import com.jcl.util.DeployProperties;
import com.jcl.util.StringUtil;
import com.jcl.vo.SubVo;

/**
 * 账户信息 管理类
 * 
 * @author jiangzq
 * @version 1.0
 */
@Controller
@RequestMapping("/fund")
public class SubzhController {
	
	public static Logger log = Logger.getLogger(SubzhController.class);
	/*上传文件路径*/
	//private static final String UPLOAD_FILEPATH = DeployProperties.getInstance().getPublicFilePath();
	/*重置默认密码*/
	private static final String DEFAULT_PASSWORD = DeployProperties.getInstance().getPublicDefaultPassword();
	
	//注入子账户服务层
	@Autowired
	private SubzhService subzhservice;
	
	//注入主账户服务层
	@Autowired
	private BdzhService bdzhServiceImpl;
	
	//注入风控模板菜单服务
	//@Autowired 
	//private RiskTemplateMenuService riskTemplateMenuService;
	
	//注入收费模板菜单服务
	@Autowired
	private CodefeesetMenuService codefeesetMenuService;
	
	//注入权限菜单的服务
	@Autowired
    private PreMenuService preMenuServiceImpl;
	
	@Autowired
	private Feetemplate_menuMapper feetemplate_menuMapper;
	//注入角色的服务
	//@Autowired
	//private RoleService roleServiceImpl;
	
	//注入风控模板菜单
	@Autowired
	private RiskTempallService riskTempallServiceImpl;
	
	//注入保证金模板
	@Autowired
	private BzjmbMenuService bzjmbMenuServiceimpl;
	
	//注入用户认证服务
	@Autowired
	private UserInfoService userinfoserviceImpl;
	
	@Autowired
    private SimulateStockService simulateStockService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	//@Autowired
	//private Datastore dsForStock;
	
	@RequestMapping("/welcomeIndex")
	public String welcomeIndex(HttpSession session, Model model) {
		try {
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			model.addAttribute("username", username);
		} catch (Exception e) {
			log.error("查询账户列表异常：" + e.getMessage());
		}
		return "fund/welcomeIndex";
	}
	
	@RequestMapping("/welcomeRisk")
	public String welcomeRisk(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "20");
		return "fund/welcomeRisk";
	}
	
	// 会员管理页面跳转
	@RequestMapping("/subzhList")
	public String subzhList(Subzh subzh,HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "3");
		String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);
		try {
			if(isAdmin==1){//如果是机构登录，那就查询条件中带机构
				subzh.setManage(username);
			}else if(isAdmin==2){//如果是平台登录，那就查询条件中带平台
				subzh.setAllocpt(username);
			}else if(isAdmin==3){//如果是渠道登录，那就查询条件中带渠道
				subzh.setAllocchannel(username);
			}else if(isAdmin==4){//如果是代理商登录，那就查询条件中带代理商
				subzh.setAllocagent(username);
			}else if(isAdmin==5){//如果是经纪人登录，那就查询条件中带经纪人
				subzh.setAllocbroker(username);
			}
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<Subzh> userlist = new ArrayList<Subzh>();
			if(subzh.getIsadmin()!=null && subzh.getIsadmin()==6){
				userlist = subzhservice.selectTradeUser(subzh);
				log.info("用户个数："+userlist.size());
			}else{
				userlist = subzhservice.selectQdJjrUser(subzh);
			}
			PageInfo<Subzh> userpage = new PageInfo<Subzh>(userlist);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
			//下拉框中数据
			if(subzh.getIsadmin()!=null && subzh.getIsadmin()==6){//加载报单账户下拉框
				List<Bdzh> blist = bdzhServiceImpl.queryAll();
				model.addAttribute("blist", blist);
			}
			
			Subzh condition=new Subzh();
			if(isAdmin==1 || isAdmin==2){//如果是机构登录，那就查询条件中带机构
				condition.setIsadmin(3);
				if(isAdmin==1){
					condition.setManage(username);
				}else{
					condition.setAllocpt(username);
				}
				if(subzh.getIsadmin()>3){
					List<Subzh> qdlist=subzhservice.getSubzhLevelList(condition);//查渠道集合
					model.addAttribute("channelList", qdlist);
					if(qdlist!=null && qdlist.size()>0){
						String qdsub=qdlist.get(0).getSubzh();
						if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocchannel())){
							qdsub=subzh.getAllocchannel();
						}
						if(subzh.getIsadmin()>4){
							condition.setAllocchannel(qdsub);
							condition.setIsadmin(4);
							List<Subzh> dlslist=subzhservice.getSubzhLevelList(condition);//查代理商集合
							model.addAttribute("agentList", dlslist);
							if(subzh.getIsadmin()==6 && dlslist!=null && dlslist.size()>0){
								String dlssub=dlslist.get(0).getSubzh();
								if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocagent())){
									dlssub=subzh.getAllocagent();
								}
								condition.setAllocagent(dlssub);
								condition.setIsadmin(5);
								List<Subzh> jjrlist=subzhservice.getSubzhLevelList(condition);//查经纪人集合
								model.addAttribute("brokerList", jjrlist);
							}
						}
						
					}
				}
				
				
			}else if(isAdmin==3){//渠道登录后，需要加载代理商，经纪人集合
				condition.setAllocchannel(username);
				condition.setIsadmin(4);
				if(subzh.getIsadmin()>4){
					List<Subzh> dlslist=subzhservice.getSubzhLevelList(condition);//查代理商集合
					model.addAttribute("agentList", dlslist);
					if(subzh.getIsadmin()==6 && dlslist!=null && dlslist.size()>0){
						String dlssub=dlslist.get(0).getSubzh();
						if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocagent())){
							dlssub=subzh.getAllocagent();
						}
						condition.setAllocagent(dlssub);
						condition.setIsadmin(5);
						List<Subzh> jjrlist=subzhservice.getSubzhLevelList(condition);//查经纪人集合
						model.addAttribute("brokerList", jjrlist);
					}
				}
				
			}else if(isAdmin==4){//代理商登录时，需要加载经纪人下拉框数据
				condition.setAllocagent(username);
				condition.setIsadmin(5);
				if(subzh.getIsadmin()==6){
					List<Subzh> jjrlist=subzhservice.getSubzhLevelList(condition);//查经纪人集合
					model.addAttribute("brokerList", jjrlist);
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询账户列表异常：" + e.getMessage());
		}
		
		if(subzh!=null){
			model.addAttribute("sub", subzh);
			if(subzh.getIsadmin()==3){
				return "fund/qdList";
			}else if(subzh.getIsadmin()==4){
				return "fund/dlslist";
			}else if(subzh.getIsadmin()==5){
				return "fund/jjrList";
			}else{
				return "fund/subzhList";
			}
		}
		
		return "fund/subzhList";
	}

	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-31
	 * @decribe 下拉框中上级变动时，需要去加载下级，如渠道变动后，代理商下拉框和经纪人下拉框中的数据就都会变动
	 * @param subzh
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/querySubData")
	@ResponseBody
	public Map<String,Object> querySubData(Subzh subzh , Integer flag,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			if(flag!=null && flag==3){//实时数据  ： 根据渠道变动代理商，并且变动经纪人和交易用户，查下面的三层结构
				List<Subzh> dlslist=subzhservice.getSubzhLevelList(subzh);
				map.put("list", dlslist);
				
				//直接查该渠道下的交易用户
				subzh.setIsadmin(6);
				List<Subzh> jylist=subzhservice.getSubzhLevelList(subzh);//查交易用户集合
				map.put("list3", jylist);
				
				//subzh.setAllocagent(dlssub);
				subzh.setIsadmin(5);
				List<Subzh> jjrlist=subzhservice.getSubzhLevelList(subzh);//查经纪人集合
				map.put("list2", jjrlist);
				
			}
			
			if(flag!=null && flag==2){//根据渠道变动代理商并且变动经纪人 或 代理商变动交易用户和经纪人，查下面两层
				List<Subzh> dlslist=subzhservice.getSubzhLevelList(subzh);//如果isadmin传的是5，这个集合查的是经纪人。
				map.put("list", dlslist);
					int isadmin=subzh.getIsadmin();
					if(isadmin==4){//历史数据 根据渠道变动代理商并且变动经纪人
						subzh.setIsadmin(5);
						List<Subzh> jjrlist=subzhservice.getSubzhLevelList(subzh);//查经纪人集合
						map.put("list2", jjrlist);
					}
					if(isadmin==5){//实时数据 根据代理商变动交易用户和经纪人
						//直接查该代理下的交易用户
						subzh.setIsadmin(6);
						List<Subzh> jylist=subzhservice.getSubzhLevelList(subzh);//查交易用户集合
						map.put("list2", jylist);
					}
			}
			if(flag!=null && flag==1){//根据渠道变动代理商或者 根据代理商变动经纪人，查下面一层
				List<Subzh> list=subzhservice.getSubzhLevelList(subzh);
				map.put("list", list);
			}
			map.put("status", 1);
		}catch(Exception e){
			map.put("status", 2);
			map.put("describe", "查询数据出错，请联系管理员");
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping("/queryAgentJjrSubList")
	@ResponseBody
	public Map<String,Object> queryAgentJjrSubList(HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			Subzh condition=new Subzh();
			if(isAdmin==1 || isAdmin==2){//如果是机构登录，那就查询条件中带机构
				if(isAdmin==1){
					condition.setManage(username);
				}else{
					condition.setAllocpt(username);
				}
				condition.setIsadmin(4);
				List<Subzh> dlslist=subzhservice.getSubzhLevelList(condition);//查代理商集合
				map.put("agentList", dlslist);
				
				condition.setIsadmin(5);
				List<Subzh> jjrlist=subzhservice.getSubzhLevelList(condition);//查经纪人集合
				map.put("brokerList", jjrlist);
				
				condition.setIsadmin(6);
				List<Subzh> jylist=subzhservice.getSubzhLevelList(condition);//查交易用户集合
				map.put("sublist", jylist);
				map.put("status", 1);
			}else{
				map.put("status", 2);
				map.put("describe", "查询用户数据有问题，请刷新");
			}
		}catch(Exception e){
			map.put("status", 3);
			map.put("describe", "查询数据出错，请联系管理员");
			e.printStackTrace();
		}
		
		return map;
	}
	// 保存编辑子账户
	@Transactional
	@RequestMapping("/editsubzh")
	@ResponseBody
	public int editsubzh(Subzh subzh , Model model,HttpSession session) {
		int num=0;
		try {
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);
			//通过页面传过来的subzh对象去匹配数据库是否存在
			Subzh subzh1=subzhservice.selectBySubzh(subzh.getSubzh());
			//判断subzh1是否存在，来决定是添加还是修改
			if(subzh1==null) {//增加
				//按照规定生成cookie
				String  sub= subzh.getSubzh();
				if(StringUtil.isAnyNullOrEmpty(subzh.getCookie())){
					byte[] data = sub.getBytes();
					long cookie = Util.Hash64(data, 0, data.length);//生成随机的cookie
					if(cookie < 0){
						subzh.setCookie(String.valueOf(Util.readUnsignedLong(cookie)));
					} else {
						subzh.setCookie(String.valueOf(cookie));
					}
				}
				subzh.setKhdate(new Date());
				subzh.setIsDelete(0);//初始的正常状态，1表示删除状态
				String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
				String pt=(String) session.getAttribute(Constant.SESSION_PLATEFORM);
				if(StringUtil.isAnyNullOrEmpty(pt)){
					subzh.setAllocpt("PT" + manage.substring(2, manage.length()));
				}
				subzh.setManage(manage);
				subzh.setZhstate(0);
				subzh.setPagentzh(username);
				subzh.setAuthState(0);
				if(subzh.getCoefficient()!=null){//前台传的是一个百分比，后台保存的是一个真实值
					BigDecimal coeffi=subzh.getCoefficient().divide(new BigDecimal("100"));
					subzh.setCoefficient(coeffi);
				}
				if(isAdmin!=null){
					if(isAdmin==3){//如果是渠道增加这个账户，就将这个账号的渠道分给这个当前登录者
						subzh.setAllocchannel(username);
					}else if(isAdmin==4){//如果是代理商增加这个账户，就将这个账号的渠道分给这个当前登录者
						subzh.setAllocagent(username);
					}else if(isAdmin==5){//如果是经纪人增加这个账户，就将这个账号的渠道分给这个当前登录者
						subzh.setAllocbroker(username);
					}
				}
				Integer userIsAdmin = subzh.getIsadmin();
                if (userIsAdmin == 3 || userIsAdmin == 4 || userIsAdmin == 5) {
                    String inviteCode = subzhservice.getInviteCode(StringUtil.getRandom(6));
                    log.info("用户账户：" + subzh.getSubzh() + "邀请码：" + inviteCode);
                    subzh.setInviteCode(inviteCode);
                }
				num=subzhservice.addSubzh(subzh);
				//将用户信息保存到认证库
				UserInfo userInfo = new UserInfo();
				userInfo.setUsername(subzh.getSubzh());
				userInfo.setPassword(subzh.getPassword());
				userInfo.setTelephone(subzh.getPhone());
				userInfoMapper.insertSelective(userInfo);
			}else {//修改
				subzh.setKhdate(subzh1.getKhdate());
				subzh.setCookie(subzh1.getCookie());
				subzh.setHeadpicture(subzh1.getHeadpicture());
				subzh.setIsadmin(subzh1.getIsadmin());
				subzh.setRiskstate(subzh1.getRiskstate());
				subzh.setFundbalance(subzh1.getFundbalance());
				subzh.setZhstate(subzh1.getZhstate());
				subzh.setPagentzh(username);
				if(subzh.getCoefficient()!=null){//前台传的是一个百分比，后台保存的是一个真实值
					BigDecimal coeffi=subzh.getCoefficient().divide(new BigDecimal("100"));
					subzh.setCoefficient(coeffi);
				}
				num=subzhservice.updateByPrimaryKey(subzh);
				/*判断用户，通知加载风控  modify date 2018-06-28*/
				if(subzh.getZhstate() != null && subzh.getZhstate() == 1){
					try {
						String rbStr = simulateStockService.commonFunction("{\"client_id\":\""+subzh.getSubzh()+"\"}", DefineNumber.JCL_PROTOCOL_ID_REQ_RISKTEMPCATE);
						log.info("通知柜台重新加载风控参数：" + rbStr);
					} catch (Exception el) {
						log.error("通知柜台重新加载风控异常：" + el.getMessage());
					}
				}
				if(!subzh1.getPhone().equals(subzh.getPhone())){
					//修改认证库中的客户信息
					UserInfoExample example=new UserInfoExample();
					Criteria createCriteria = example.createCriteria();
					createCriteria.andUsernameEqualTo(subzh.getSubzh());
					
					UserInfo userInfo = (UserInfo) userinfoserviceImpl.selectByExample(example);
					userInfo.setUsername(subzh.getSubzh());
					userInfo.setPassword(subzh.getPassword());
					userInfo.setTelephone(subzh.getPhone());
					userinfoserviceImpl.updateByPrimaryKey(userInfo);
				}
				
			}	
		} catch (Exception e) {
			log.error("新增，获取权限列表异常：" + e);
			e.printStackTrace();
		}
		return num;
	}
	
	//去修改
	@RequestMapping("/toUpdate")
	public String toUpdate(Model model,@RequestParam("id") String id,@RequestParam("isadmin") Integer isadmin,HttpSession session) {
		int isupdate=0;
		try {
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			String pt=(String) session.getAttribute(Constant.SESSION_PLATEFORM);
			if(isadmin!=null){
				Subzh subzh=subzhservice.selectBySubzh(id);
				if(isadmin==4){//修改代理商
					if(isAdmin==3){
						Subzh qdsub=subzhservice.getPuriSubzh(username);
						subzh.setChannelname(qdsub.getName());
						if(!username.equals(qdsub.getSubzh())){
							log.info("subzh实体类对象级别关系没对应上，username:"+username+"而代理分配的渠道是："+qdsub.getSubzh());
						}
						subzh.setAllocchannel(username);
					}else{
						/*Subzh s=new Subzh();
						s.setIsadmin(3);
						s.setAllocpt(pt);
						s.setManage(manage);
						List<Subzh> qdlist=subzhservice.getSubzhLevelList(s);
						model.addAttribute("channelList", qdlist);*/
						Subzh qdsub=subzhservice.getPuriSubzh(subzh.getAllocchannel());
						subzh.setChannelname(qdsub.getName());
					}
				}
				
				if(isadmin==5){//修改经纪人
					Subzh qdsub=subzhservice.getPuriSubzh(subzh.getAllocchannel());
					subzh.setChannelname(qdsub.getName());
					
					Subzh dlssub=subzhservice.getPuriSubzh(subzh.getAllocagent());
					subzh.setAgentname(dlssub.getName());
					//查询渠道，代理商
					/*Map<String,Object> data=getQdDlsList(isAdmin,manage,pt,username,subzh);
					subzh=(Subzh)data.get("subzh");
					model.addAttribute("channelList", data.get("qdlist"));
					model.addAttribute("agentList", data.get("dlslist"));*/
				}
				if(subzh.getCoefficient()!=null){//前台传的是一个百分比，后台保存的是一个真实值
					BigDecimal coeffi=subzh.getCoefficient().multiply(new BigDecimal("100"));
					subzh.setCoefficient(coeffi);
				}
				if(isadmin==6){//修改交易用户
					int isholder = 0;
					//查询手续费分成菜单
					Feetemplate_menuExample example = new Feetemplate_menuExample();
					com.jcl.pojo.Feetemplate_menuExample.Criteria createCriteria = example.createCriteria();
					List<Feetemplate_menu> feetemplate_menuList = feetemplate_menuMapper.selectByExample(example);
					//查询风控菜单
					List<RiskTempall> rlist = riskTempallServiceImpl.selectAll();
					//查询收费方案
					List<CodefeesetMenu> flist = codefeesetMenuService.selectAll();	
					List<Bdzh> blist = bdzhServiceImpl.queryAll();
					//查询保证金模板
					List<BzjmbMenu> bzlist = bzjmbMenuServiceimpl.selectAll();
					
					//查看此用户是否有当日委托或历史委托。有则不可以修改上级节点。无时，可以修改
					if(subzh.getZhstate()==null || subzh.getZhstate()==0){
						//isupdate=isHaveTrade(subzh.getSubzh());
						isupdate=0;
					}else{
						isupdate=1;
						/*查询账户持仓 modify date 2018-07-12*/
						JSONObject obj = invokeCounter("{\"client_id\":\"" + subzh.getSubzh() + "\",\"start\":0,\"limit\":10}",11123);//查找用户持仓信息
						if(obj.containsKey("status")){
							int i = obj.getIntValue("status");
							if(i==0){
								JSONArray arr=obj.getJSONArray("holders");
								if(arr.size()>0){
									isholder = 1;
								}
							}
						}
						int isentrust=0;
						Map<String, Object> map = getCounterFunds(subzh);
						if(map!=null&&map.size()>0) {
							if(map.containsKey("status")&&map.get("status").equals(0)){
								JSONObject data=(JSONObject) JSONObject.toJSON(map.get("data"));
								if(map.containsKey("status") &&Integer.parseInt(map.get("status").toString())==0){
									Double freeze_balance = Double.valueOf((String) data.get("freeze_balance"));
									
									Double market_balance = Double.valueOf((String) data.get("market_balance"));
									
									if(freeze_balance>0||market_balance>0){
										isentrust=1;
									}
								}								
							}
						}
						
						if(isentrust+isholder>0) {
							isupdate = 1;
						}else {
							isupdate = 0;
						}
					}
					model.addAttribute("isholder", isholder);
					
					if(isupdate==1){//如果有持仓或委托
						if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocbroker())){
							Subzh jjrsub=subzhservice.getPuriSubzh(subzh.getAllocbroker());
							if(jjrsub!=null){
								subzh.setBrokername(jjrsub.getName());
							}
						}
						if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocagent())){
							Subzh dlssub=subzhservice.getPuriSubzh(subzh.getAllocagent());
							if(dlssub!=null){
								subzh.setAgentname(dlssub.getName());
							}
						}
						if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocchannel())){
							Subzh qdsub=subzhservice.getPuriSubzh(subzh.getAllocchannel());
							if(qdsub!=null){
								subzh.setChannelname(qdsub.getName());
							}
						}
						
					}else{
						Subzh sub2=new Subzh();
						sub2.setAllocchannel(subzh.getAllocchannel());
						sub2.setAllocagent(subzh.getAllocagent());
						sub2.setAllocbroker(subzh.getAllocbroker());
						Map<String,Object> data=getQdDlsJjrList(isAdmin,manage,pt,username,sub2);
						//subzh=(Subzh)data.get("subzh");
						model.addAttribute("channelList", data.get("qdlist"));
						model.addAttribute("agentList", data.get("dlslist"));
						model.addAttribute("brokerList", data.get("jjrlist"));
					}
					
					model.addAttribute("feetemplate_menuList", feetemplate_menuList);
					model.addAttribute("bzlist", bzlist);
					model.addAttribute("sub", subzh);
					model.addAttribute("blist", blist);
					model.addAttribute("rlist", rlist);
					model.addAttribute("flist", flist);
				}
				model.addAttribute("sub", subzh);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取权限列表异常：" + e.getMessage());
		}
		model.addAttribute("flag", 1);//修改
		model.addAttribute("isupdate", isupdate);
		return "fund/addsubzh";
	}

	
	public JSONObject invokeCounter(String s,int numb){
		JSONObject obj = new JSONObject();
		try {
			log.info("功能号为"+numb+"调接口的入参："+s);
			String rbStr = simulateStockService.commonFunction(s, numb);//历史委托查询
			log.info("功能号为"+numb+"的接口，返回rbStr为："+rbStr);
			//System.out.println(condition.get("client_id")+"功能号为"+numb+"的接口，返回rbStr为："+rbStr);
			if(rbStr==null||rbStr=="null" || rbStr.equals("")){
				rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
				obj = JSONObject.parseObject(rbStr);
			}else if(rbStr.indexOf("{")<0){
				rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
				obj = JSONObject.parseObject(rbStr);
			}else{//正常情况下
				obj = JSONObject.parseObject(rbStr);
				
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		} catch (BussinessException e) {
			//e.getMessage();
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * 查当日委托
	 * @param user
	 * @return
	 */
	private int isEntrust(String user) {
		log.info("当日委托用户  ：   "+user);	
		int flag=0;
		try {		
		String con="{\"start\":0,\"limit\":10,\"client_id\":\""+user+"\"}";
		
		log.info("查委托出入柜台参数"+con);
		String rbStr = simulateStockService.commonFunction(con, 11119);//资金信息查询,查看是否有动态权益
		if(rbStr==null||rbStr=="null" || rbStr.equals("")){
			rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
			JSONObject obj = JSONObject.parseObject(rbStr);
		}else if(rbStr.indexOf("{")<0){
			rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
			JSONObject obj = JSONObject.parseObject(rbStr);
		}else{//正常情况下
			JSONObject obj = JSONObject.parseObject(rbStr);
			log.info(user +" 的当日委托  obj：   "+obj);	
			if(obj.containsKey("status") && obj.getIntValue("status")==0){
				String str = obj.getString("records");
				log.info(user +" 的当日委托  str：   "+str);
				if(str!=null||str!="null" || !str.equals("")){
				List<Integer> mlist=getEntrust(str);
				if(mlist!=null&&mlist.size()>0) {
				for (Integer status : mlist) {
					if(status==0||status==3||status==4||status==6||status==7||status==8) {
						flag=1;
						log.info("当日委托状态  ：   "+status);	
							}
						}
					}
				}
			}			
		}
	}catch(Exception e) {
		log.error("查询用户委托异常", e);
	}	
		return flag;
	}
	
	 public  List<Integer> getEntrust(String jsonstr) {
		 	List<Integer> mlist= new ArrayList<Integer>();
		 	if(!StringUtil.isAllNullOrEmpty(jsonstr)||"[]".equals(jsonstr)) {
		 		log.info("jsonstr   :  "+jsonstr);
				return null;
			}
			String num = jsonstr.substring(1, jsonstr.length()-1);
			log.info("num1   :  "+num);
			if(!StringUtil.isAllNullOrEmpty(num)) {
				log.info("num2   :  "+num);
				return null;
			}
			String[] j = num.split("},");
			for (String  i: j) {
				if(!i.endsWith("}")) {
					i=i+"}";
				}
				JSONObject jjs=JSONObject.parseObject(i);
				log.info("---------"+jjs);
				log.info("---------"+jjs.getString("entrust_status"));
				mlist.add(Integer.parseInt(jjs.getString("entrust_status")));
			}
			return mlist;
		}
	
	//判断此交易用户是否已有委托，如果有则不能对它进行，部分修改
	private int isHaveTrade(String user){
		int flag=0;
		try{
			/*String con="{\"start\":0,\"limit\":10,\"client_id\":\""+user+"\"}";
			String rbStr = simulateStockService.commonFunction(con, 11119);//历史委托查询
			if(rbStr==null||rbStr=="null" || rbStr.equals("")){
				rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else if(rbStr.indexOf("{")<0){
				rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else{//正常情况下
				JSONObject obj = JSONObject.parseObject(rbStr);
				if(obj.containsKey("status") && obj.getIntValue("status")==0){
					int count =obj.getIntValue("totalnum");
					if(count>0){
						flag=1;
						return 1;
					}
				}
				
			}
			DB db = dsForStock.getDB();
			DBCollection dbCollection=db.getCollection("history_wt");//历史委托记录
			DBObject condition = new BasicDBObject();
			condition.put("subzh", new BasicDBObject("$eq", user));
			long totalCount=dbCollection.count(condition);
			if(totalCount>0){
				flag=1;
			}*/
			String con="{\"start\":0,\"limit\":10,\"client_id\":\""+user+"\"}";
			String rbStr = simulateStockService.commonFunction(con, 11103);//资金信息查询,查看是否有动态权益
			if(rbStr==null||rbStr=="null" || rbStr.equals("")){
				rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else if(rbStr.indexOf("{")<0){
				rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else{//正常情况下
				JSONObject obj = JSONObject.parseObject(rbStr);
				if(obj.containsKey("status") && obj.getIntValue("status")==0){
					JSONObject arr=obj.getJSONObject("data");
					if(!arr.isEmpty()){
						if(arr.containsKey("fund_balance")){
							Double fundBalance=arr.getDouble("fund_balance");
							if(fundBalance!=null && fundBalance>0){
								flag=1;
							}
						}
					}
				}
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	// 跳转到新增子账户
	@RequestMapping("/addsubzh")
	public String addsubzh(String subzhName,Integer isadmin, Model model,HttpSession session) {
		try {
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);//当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String pt=(String) session.getAttribute(Constant.SESSION_PLATEFORM);
			if(isadmin!=null){//当前增加的子账户的角色标识，3渠道，4代理商，5经纪人，6普通用户
				Subzh subzh=new Subzh();
				subzh.setIsadmin(isadmin);
				if(isadmin==6){//新增普通用户
					Feetemplate_menuExample example = new Feetemplate_menuExample();
					com.jcl.pojo.Feetemplate_menuExample.Criteria createCriteria = example.createCriteria();
					List<Feetemplate_menu> feetemplate_menuList = feetemplate_menuMapper.selectByExample(example);
					//查询风控菜单
					List<RiskTempall> rlist = riskTempallServiceImpl.selectAll();
					//查询收费方案
					List<CodefeesetMenu> flist = codefeesetMenuService.selectAll();	
					//查询保证金模板
					List<BzjmbMenu> bzlist = bzjmbMenuServiceimpl.selectAll();
					//subzh账户
					//String count=CommonFunc.getEightRandomStr();
					//密码
					//报单账户
					List<Bdzh> blist = bdzhServiceImpl.queryAll();
					/*Subzh user = subzhservice.selectByPrimaryKey(subzhName);*/
					model.addAttribute("bzlist", bzlist);
					model.addAttribute("feetemplate_menuList", feetemplate_menuList);
					//model.addAttribute("password", password);
					model.addAttribute("blist", blist);
					model.addAttribute("rlist", rlist);
					model.addAttribute("flist", flist);
					//查询渠道，代理商，经纪人
					Map<String,Object> data=getQdDlsJjrList(isAdmin,manage,pt,username,subzh);
					subzh=(Subzh)data.get("subzh");
					model.addAttribute("channelList", data.get("qdlist"));
					model.addAttribute("agentList", data.get("dlslist"));
					model.addAttribute("brokerList", data.get("jjrlist"));
				}else if(isadmin==5){
					//查询渠道，代理商
					Map<String,Object> data=getQdDlsList(isAdmin,manage,pt,username,subzh);
					subzh=(Subzh)data.get("subzh");
					model.addAttribute("channelList", data.get("qdlist"));
					model.addAttribute("agentList", data.get("dlslist"));
				}else if(isadmin==4){//新增代理商
					if(isAdmin==3){
						Subzh qdsub=subzhservice.getPuriSubzh(username);
						subzh.setChannelname(qdsub.getName());
						subzh.setAllocchannel(username);
						String pre=username.substring(username.length()-3);
						subzh.setSubzh(pre);//经纪人编号的前三位
					}else{
						Subzh s=new Subzh();
						s.setIsadmin(3);
						s.setAllocpt(pt);
						s.setManage(manage);
						List<Subzh> qdlist=subzhservice.getSubzhLevelList(s);
						model.addAttribute("channelList", qdlist);
						if(qdlist!=null && qdlist.size()>0){
							String qdname=qdlist.get(0).getSubzh();
							subzh.setSubzh(qdname.substring(qdname.length()-3));//经纪人编号的前三位
						}
					}
				}else if(isadmin==3){//新增渠道
					
				}
				subzh.setAllocpt(pt);
				subzh.setManage(manage);
				model.addAttribute("sub", subzh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取权限列表异常：" ,e);
		}
		model.addAttribute("flag", 0);//新增
		model.addAttribute("isupdate", 0);//新增
		return "fund/addsubzh";
	}
	
	//当新增交易用户时，将渠道，代理商，经纪人的下拉数据查询出来
	private Map<String,Object> getQdDlsJjrList(int isAdmin,String manage,String pt,String username,Subzh subzh){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Subzh> qdlist=new ArrayList<Subzh>();
		List<Subzh> dlslist=new ArrayList<Subzh>();
		List<Subzh> jjrlist=new ArrayList<Subzh>();
		String qdzh=subzh.getAllocchannel();
		try {
			if(isAdmin==1||isAdmin==2){//如果是机构或平台登录的
				Subzh qd=new Subzh();
				qd.setIsadmin(3);
				if(isAdmin==1){
					qd.setManage(manage);
				}else{
					qd.setAllocpt(pt);
				}
				qdlist=subzhservice.getSubzhLevelList(qd);
				if(StringUtil.isAnyNullOrEmpty(qdzh)){
					if(qdlist!=null && qdlist.size()>0){
						qdzh=qdlist.get(0).getSubzh();
					}
				}
				if(!StringUtil.isAnyNullOrEmpty(qdzh)){
					Subzh dls=new Subzh();
					dls.setIsadmin(4);
					dls.setAllocchannel(qdzh);
					dls.setManage(manage);
					dlslist=subzhservice.getSubzhLevelList(dls);
					if(dlslist!=null && dlslist.size()>0){
						if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocagent())){
							qdzh=subzh.getAllocagent();
						}else{
							qdzh=dlslist.get(0).getSubzh();
						}
						Subzh jjr=new Subzh();
						jjr.setIsadmin(5);
						jjr.setAllocagent(qdzh);
						jjr.setManage(manage);
						jjrlist=subzhservice.getSubzhLevelList(jjr);
					}
					
				}
			}else if(isAdmin==3){//如果是渠道登录的
				qdzh=username;
				Subzh sub=subzhservice.getPuriSubzh(username);
				qdlist.add(sub);
				if(!StringUtil.isAnyNullOrEmpty(qdzh)){
					Subzh dls=new Subzh();
					dls.setIsadmin(4);
					dls.setAllocchannel(qdzh);
					dls.setManage(manage);
					dlslist=subzhservice.getSubzhLevelList(dls);
					if(dlslist!=null && dlslist.size()>0){
						if(!StringUtil.isAnyNullOrEmpty(subzh.getAllocagent())){
							qdzh=subzh.getAllocagent();
						}else{
							qdzh=dlslist.get(0).getSubzh();
						}
						Subzh jjr=new Subzh();
						jjr.setIsadmin(5);
						jjr.setAllocagent(qdzh);
						jjr.setManage(manage);
						jjrlist=subzhservice.getSubzhLevelList(jjr);
					}
				}
				subzh.setAllocchannel(username);
				subzh.setChannelname(sub.getName());
			}else if(isAdmin==4){//如果是代理商登录的
				Subzh dlssub=subzhservice.getPuriSubzh(username);
				Subzh qdsub=subzhservice.getPuriSubzh(dlssub.getAllocchannel());
				qdlist.add(qdsub);
				dlslist.add(dlssub);
				
				qdzh=dlslist.get(0).getSubzh();
				Subzh jjr=new Subzh();
				jjr.setIsadmin(5);
				jjr.setAllocagent(username);
				jjr.setManage(manage);
				jjrlist=subzhservice.getSubzhLevelList(jjr);
				subzh.setAllocchannel(qdsub.getSubzh());
				subzh.setAllocagent(dlssub.getSubzh());
				subzh.setChannelname(qdsub.getName());
				subzh.setAgentname(dlssub.getName());
			}else if(isAdmin==5){//如果是经纪人登录的
				Subzh jjrsub=subzhservice.getPuriSubzh(username);
				Subzh dlssub=subzhservice.getPuriSubzh(jjrsub.getAllocagent());
				Subzh qdsub=subzhservice.getPuriSubzh(jjrsub.getAllocchannel());
				qdlist.add(qdsub);
				dlslist.add(dlssub);
				jjrlist.add(jjrsub);
				subzh.setAllocbroker(username);
				subzh.setAllocagent(dlssub.getSubzh());
				subzh.setAllocchannel(qdsub.getSubzh());
				subzh.setBrokername(jjrsub.getName());
				subzh.setAgentname(dlssub.getName());
				subzh.setChannelname(qdsub.getName());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		subzh.setAllocpt(pt);
		subzh.setManage(manage);
		map.put("subzh", subzh);
		map.put("qdlist", qdlist);
		map.put("dlslist", dlslist);
		map.put("jjrlist", jjrlist);
		return map;
	}
	
	//新增经纪人时，将渠道，代理商下拉框数据查出来
	private Map<String,Object> getQdDlsList(int isAdmin,String manage,String pt,String username,Subzh subzh){
		
		Map<String,Object> map=new HashMap<String,Object>();
		List<Subzh> qdlist=new ArrayList<Subzh>();
		List<Subzh> dlslist=new ArrayList<Subzh>();
		//新增经纪人
		if(isAdmin==4){//代理商增加经纪人，需要查出当前代理商
			Subzh sub=subzhservice.getPuriSubzh(username);
			subzh.setAllocagent(username);
			subzh.setAgentname(sub.getName());
			subzh.setAllocchannel(sub.getAllocchannel());
			Subzh qdsub=subzhservice.getPuriSubzh(username);
			subzh.setChannelname(qdsub.getName());
			subzh.setAllocpt(sub.getAllocpt());
			subzh.setManage(manage);
			String pre=username.substring(username.length()-3, username.length());
			subzh.setSubzh(pre);//经纪人编号的前三位
		}else if(isAdmin==3){//渠道增加经纪人，需要查出平台下的渠道
			Subzh qdsub=subzhservice.getPuriSubzh(username);
			Subzh s=new Subzh();
			s.setIsadmin(4);
			s.setAllocchannel(username);
			dlslist=subzhservice.getSubzhLevelList(s);
			if(dlslist!=null && dlslist.size()>0){
				String subzhstr=dlslist.get(0).getSubzh();
				String pre=subzhstr.substring(subzhstr.length()-3, subzhstr.length());
				subzh.setSubzh(pre);//经纪人编号的前三位
			}
			subzh.setAllocchannel(username);
			subzh.setChannelname(qdsub.getName());
			subzh.setAllocpt(pt);
			subzh.setManage(manage);
		}else if(isAdmin<3){//如果是机构或平台登录时，
			Subzh s=new Subzh();
			s.setIsadmin(3);
			s.setAllocpt(pt);
			s.setManage(manage);
			qdlist=subzhservice.getSubzhLevelList(s);
			if(qdlist!=null && qdlist.size()>0){
				Subzh dls=new Subzh();
				dls.setIsadmin(4);
				dls.setAllocchannel(qdlist.get(0).getSubzh());
				dlslist=subzhservice.getSubzhLevelList(dls);
				if(dlslist!=null && dlslist.size()>0){
					String subzhstr=dlslist.get(0).getSubzh();
					String pre=subzhstr.substring(subzhstr.length()-3, subzhstr.length());
					subzh.setSubzh(pre);//经纪人编号的前三位
				}
			}
			subzh.setAllocpt(pt);
			subzh.setManage(manage);
		}
	
		map.put("subzh", subzh);
		map.put("qdlist", qdlist);
		map.put("dlslist", dlslist);
		return map;
		
	}
	
	//判断当前用户是否有权限
	@RequestMapping("/ispre")
	@ResponseBody
	public String ispre(@RequestParam("subzh") String subzh,@RequestParam("isadmin") Integer isadmin) {
		try {
			Subzh sub = subzhservice.selectByPrimaryKey(subzh);
			String parent="";
			if(isadmin==3){//给渠道设置权限菜单
				parent=sub.getAllocpt();//取渠道上一级平台
			}else if(isadmin==4){//给代理商设置权限菜单
				parent=sub.getAllocchannel();//取代理商上一级的渠道
			}else if(isadmin==5){//给经纪人设置权限菜单
				parent=sub.getAllocagent();//取经纪人上一级的代理商
			}
			Map<Integer, List<PreMenu>> map= preMenuServiceImpl.queryAll(parent);
			if(map.size()>0&&map!=null) {
				return "true";
			}else {
				return "false";
			}	
		} catch (Exception e) {
			log.error("ispre获取权限列表异常：",e);
			return "false";
		}
	
	}
	
	
	//去设置权限  
	@RequestMapping("/setpre")
	public String toSetpre(Model model,@RequestParam("subzh") String subzh,@RequestParam("isadmin") Integer isadmin,HttpSession session){
		try {
			/*//查询所有的角色及它所对应的菜单（一级菜单）(role,role_permition,permition)
			List<Role> rlist= roleServiceImpl.selectAll();
			//查询某个子账户的角色（subzh_role）
			SubzhRole subzhRole=subzhservice.selectSubzhRole(subzh);
			//查询某个子账户信息
			Subzh sub = subzhservice.selectByPrimaryKey(subzh);
			//查询某个子账户的权限菜单
			List<SubzhPreMenu> slList=subzhservice.selectSubPreMenu(subzh);
			model.addAttribute("rlist", rlist);
			model.addAttribute("slList", slList);
			model.addAttribute("sr", subzhRole);*/
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);//1机构，2平台，3渠道，4代理商，5经纪人，6普通用户
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			Subzh sub = subzhservice.selectByPrimaryKey(subzh);
			String parent="";
			if(isadmin==3){//给渠道设置权限菜单
				parent=sub.getAllocpt();//取渠道上一级平台
			}else if(isadmin==4){//给代理商设置权限菜单
				parent=sub.getAllocchannel();//取代理商上一级的渠道
			}else if(isadmin==5){//给经纪人设置权限菜单
				parent=sub.getAllocagent();//取经纪人上一级的代理商
			}
			List<PreMenu> plist=subzhservice.selectByRoleAndPer(subzh);//查询出自己已有的权限，让它选中
			Map<Integer, List<PreMenu>> map= preMenuServiceImpl.queryAll(parent);
			//资金管理
			model.addAttribute("list2", map.get(2));
			//账户管理
			model.addAttribute("list3", map.get(3));
			//交易管理
			model.addAttribute("list4", map.get(4));
			//系统管理
			model.addAttribute("list5", map.get(5));
			model.addAttribute("isadmin", isadmin);
			model.addAttribute("sub", sub);
			model.addAttribute("plist", plist);
		} catch (Exception e) {
			log.error("setpre获取权限列表异常：",e);
		}
		return "fund/pre";	
	}
	
	//保存设置权限 
	@Transactional
	@RequestMapping("/savePre")
	@ResponseBody
	public int saveSubzhPre(Model model,String num,SubVo vo){
		int count=0;
		int i=0;
		try {
		//更具页面传过来的子账户的subzh查询数据库是否存在该用户角色
		/*SubzhRole sr = subzhservice.selectSubzhRole(vo.getSubzh());
		if(sr!=null) {//存在则调用修改的方法
			sr.setSubzh(vo.getSubzh());
			sr.setRoleid(vo.getRoleid());
			i=subzhservice.updateSubzhRole(sr);
		}else {//不存在则调用添加的方法
			i=subzhservice.saveSubzhRole(vo.getSubzh(),vo.getRoleid());
		}*/
		List<SubzhPreMenu> spmlist = subzhservice.selectSubPreMenu(vo.getSubzh());
		if(spmlist!=null && spmlist.size()>0){
			count=subzhservice.updateSubzhPre(num,vo.getSubzh());
		}else {
			count=subzhservice.saveSubzhPre(num,vo.getSubzh());
		}
		
		
		} catch (Exception e) {
			log.error("设置权限异常：" + e);
		}
		int sum=count+i;
		return sum;	
	}
	
	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-21
	 * @decribe 根据渠道查渠道下面的经纪人
	 * @param channel
	 * @return
	 */
	@RequestMapping("/getJjrFormqd")
	@ResponseBody
	public Map<String,Object> getJjrFormqd(Subzh subzh){
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			
			List<Subzh> list=subzhservice.getSubzhLevelList(subzh);
			map.put("status", 0);
			map.put("list", list);
		}catch(Exception e){
			map.put("status", 1);
			map.put("describe", "根据渠道查询经纪人出错");
		}
		return map;
		
	}
	
	// 编辑会员
	@RequestMapping("/editSubzhMsg")
	@ResponseBody
	public String editSubzhMsg(Subzh user, String starttimeStr, String endtimeStr, Integer id) {
		return "false";
	}

	// 批量删除
	@RequestMapping("/deleteSubzhList")
	@ResponseBody
	public String deleteSubzhList(Integer[] ids) {
		if (ids != null) {
			for (Integer id : ids) {
				try {
					//Subzh user = Subzhservice.selectByPrimaryKey(id);
					//user.setStatus(0);
					//i = Subzhservice.updateByPrimaryKey(user);
					//subzhservice.deleteByPrimaryKey(id);
				} catch (Exception e) {
					log.error("删除账户异常：" + e.getMessage());
					return "false";
				}
			}
		}
		return "true";
	}

	// 单个删除
	@RequestMapping("/deleteSubzh")
	@ResponseBody
	public String deleteSubzh(String subzh,Integer isadmin) {
		String s="";
		try {
			Subzh user=new Subzh();
			user.setSubzh(subzh);
			//user.setIsadmin(isadmin);
			user.setIsDelete(1);//表示逻辑删除
			if(isadmin!=null && isadmin==3){
				Subzh sub=new Subzh();
				sub.setAllocchannel(subzh);
				List<Subzh> clist=subzhservice.getSubzhLevelList(sub);
				if(clist==null || clist.size()==0){
					subzhservice.deleteByPrimaryKey(subzh);
					//subzhservice.updateByPrimaryKey(user);
					//将用户信息保存到认证库
					UserInfoExample example=new UserInfoExample();
					example.createCriteria().andUsernameEqualTo(subzh);
					userinfoserviceImpl.deleteByExample(example);
					s="删除成功";
				}else{
					s="删除失败，此渠道下有代理商和经纪人交易用户，不能被删除";
					return "{\"status\":1,\"message\":\""+s+"\"}";
				}
			}
			if(isadmin!=null && isadmin==4){
				Subzh sub=new Subzh();
				sub.setAllocagent(subzh);
				List<Subzh> blist=subzhservice.getSubzhLevelList(sub);
				if(blist==null || blist.size()==0){
					subzhservice.deleteByPrimaryKey(subzh);
					//subzhservice.updateByPrimaryKey(user);
					//将用户信息从认证库中也删除
					UserInfoExample example=new UserInfoExample();
					example.createCriteria().andUsernameEqualTo(subzh);
					userinfoserviceImpl.deleteByExample(example);
					s="删除成功";
				}else{
					s="删除失败，此代理商下有交易用户，不能被删除";
					return "{\"status\":1,\"message\":\""+s+"\"}";
				}
			}
			if(isadmin!=null && isadmin==5){
				Subzh sub=new Subzh();
				sub.setAllocbroker(subzh);
				List<Subzh> blist=subzhservice.getSubzhLevelList(sub);
				if(blist==null || blist.size()==0){
					subzhservice.deleteByPrimaryKey(subzh);
					//subzhservice.updateByPrimaryKey(user);
					//将用户信息从认证库中也删除
					UserInfoExample example=new UserInfoExample();
					example.createCriteria().andUsernameEqualTo(subzh);
					userinfoserviceImpl.deleteByExample(example);
					s="删除成功";
				}else{
					s="删除失败，此经纪人下有交易用户，不能被删除";
					return "{\"status\":1,\"message\":\""+s+"\"}";
				}
			}
			if(isadmin!=null && isadmin==6){
				
				Subzh subzh1=subzhservice.getPuriSubzh(subzh);
				Integer zhstate=subzh1.getZhstate();
				//BigDecimal fundbalance=subzh1.getFundbalance();
				int flag=isHaveTrade(subzh);
				
				if(flag>0 || (zhstate!=null && zhstate>0)){//
					if(flag>0){
						s="子账号的动态权益不为0，不能删除";
					}else{
						s="此交易账户不能被删除";
					}
					return "{\"status\":1,\"message\":\""+s+"\"}";
				}else{
					/*subzh1.setIsDelete(1);//1表示已删除
					subzhservice.updateByPrimaryKey(subzh1);*/
					/*int isupdate=isHaveTrade(subzh);//委托是否有委托和持仓
					if(isupdate==1){
						s="此交易账户不能被删除";
						return "{\"status\":1,\"message\":\""+s+"\"}";
					}*/
					subzhservice.deleteByPrimaryKey(subzh);
					//将用户信息从认证库中也删除
					UserInfoExample example=new UserInfoExample();
					example.createCriteria().andUsernameEqualTo(subzh);
					userinfoserviceImpl.deleteByExample(example);
					s="删除成功";
				}
			}
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
			s="删除账户异常";
			return "{\"status\":1,\"message\":\""+s+"\"}";
		}
		return "{\"status\":0,\"message\":\""+s+"\"}";
	}
	
	// 单个暂停
	@RequestMapping("/setStatusSubzh")
	@ResponseBody
	public String setStatusSubzh(Integer id) {
		int i = 0;
		try {
			/*Subzh user = Subzhservice.selectByPrimaryKey(id);
			user.setDelflag(Constant.DELETED_INT_YES);
			i = Subzhservice.updateByPrimaryKey(user);*/
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
		}
		if(i > 0){
			return "true";
		} else {
			return "false";
		}
	}

	// 恢复
	@RequestMapping("/reinstate")
	@ResponseBody
	public String reinstate(Integer id) {
		int i = 0;
		try {
			/*Subzh user = Subzhservice.selectByPrimaryKey(id);
			user.setDelflag(Constant.DELETED_INT_NO);
			i = Subzhservice.updateByPrimaryKey(user);*/
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
		}
		if (i > 0) {
			return "true";
		} else {
			return "false";
		}

	}
	
	/*重置密码*/
	@RequestMapping("/defaultPsw")
	@ResponseBody
	public String defaultPsw(String subzhName) {
		int i = 0;
		try {
			Subzh user = subzhservice.selectByPrimaryKey(subzhName);
			user.setPassword(DEFAULT_PASSWORD);
			int num = subzhservice.updateByPrimaryKey(user);
			
			if(num>0) {
				log.info("修改注册表");
				
				
				UserInfoExample example=new UserInfoExample();
				Criteria createCriteria = example.createCriteria();
				createCriteria.andUsernameEqualTo(user.getSubzh());
				List<UserInfo> userlist=userinfoserviceImpl.selectByExample(example);
				if(userlist!=null&&userlist.size()>0){
					UserInfo userinfo=userlist.get(0);
					userinfo.setPassword(DEFAULT_PASSWORD);
					i=userinfoserviceImpl.updateByPrimaryKey(userinfo);
					log.info("修改注册表状态    ： "+i);
				}
			}
		} catch (Exception e) {
			log.error("重置密码异常：" + e.getMessage());
		}
		if (i > 0) {
			return "true";
		} else {
			return "false";
		}

	}
	
	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-21
	 * @decribe 交易账号设置权限市场
	 * @param subzh
	 * @param jypz
	 * @return
	 */
	@RequestMapping("/updateMarket")
	@ResponseBody
	public String updateMarket(String subzh,String jypz){
		int i = 0;
		try {
			Subzh user = subzhservice.selectByPrimaryKey(subzh);
			user.setJypz(jypz);
			i = subzhservice.updateByPrimaryKey(user);
		} catch (Exception e) {
			log.error("修改交易权限异常：" + e.getMessage());
		}
		if (i > 0) {
			return "true";
		} else {
			return "false";
		}
	}
	
	// 批量启用
	@RequestMapping("/reinstateUsers")
	@ResponseBody
	public String reinstateUsers(Integer[] ids) {
		if (ids != null) {
			Subzh user = null;
		}
		return "true";
	}
	
	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-17
	 * @decribe
	 * @param phone
	 * @param subzh
	 * @return
	 */
	@RequestMapping("/checkPhoneExist")
	@ResponseBody
	public String checkPhoneExist(String phone,String subzh){
		boolean b=false;
		try{
			b=subzhservice.checkPhoneExist(phone,subzh);
		}catch(Exception e){
			e.printStackTrace();
		}
		return String.valueOf(b);
	}
	
	@RequestMapping("/checkSubzhExist")
	@ResponseBody
	public String checkSubzhExist(String subzh){
		boolean b=false;
		try{
			b=subzhservice.checkSubzhExist(subzh);
		}catch(Exception e){
			e.printStackTrace();
		}
		return String.valueOf(b);
	}

	
	@RequestMapping("/checkNameExist")
	@ResponseBody
	public String checkNameExist(Subzh subzh){
		boolean b=false;
		try{
			b=subzhservice.checkNameExist(subzh);
		}catch(Exception e){
			e.printStackTrace();
		}
		return String.valueOf(b);
	}
	
	
	/**
	 * 为了开发过程测试方便添加一个新增权限菜单的模块
	 * 去新增权限菜单页面
	 */
	
	@RequestMapping("/toAddMenu")
	public String toAddMenu(Model model) {
		
		try {
			List<Permission> plist=subzhservice.selectPre();
			model.addAttribute("plist", plist);
		} catch (Exception e) {
			log.error("toAddMenu-查询权限列表异常：" + e.getMessage());
		}
		return "/fund/addMenu";
	}
	
	//检查输入的菜单权限是否存在
	@RequestMapping("/querykeywords")
	@ResponseBody
	public String querykeyword(String keyword) {
		List<PreMenu> list=new ArrayList<PreMenu>();
		try {
			 list=subzhservice.selectPreMenu(keyword);
		
		} catch (Exception e) {
			log.error("querykeywords-查询权限列表异常：" + e.getMessage());
			return "true";
		}
		if(list==null||list.size()==0) {
			return "flase";
		}else {
			return "true";
		}	
	}
	
	//添加菜单权限
	@RequestMapping("/addmenu")
	@ResponseBody
	@Transactional
	public int addmenu(PreMenu preMenu) {
		int num = 0;
		try {
			num=subzhservice.addmenu(preMenu);
		} catch (Exception e) {
			log.error("toAddMenu-查询权限列表异常：" + e.getMessage());
		}
		return num;
	}
	
	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-30
	 * @decribe 查询机构和平台
	 * @return
	 */
	@RequestMapping("/agentPt")
	public String agentPtList(Model model,HttpSession session){
		try{
			session.setAttribute(Constant.SESSION_LEFTMENU, "30");
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);//当前登录者角色标识，1平台，2渠道，3经纪人
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			if(isAdmin!=1){
				List<Subzh> agentList=new ArrayList<Subzh>();
				List<Subzh> ptList=new ArrayList<Subzh>();
				model.addAttribute("agentList", agentList);
				model.addAttribute("ptList", ptList);
			}else{
				List<Subzh> agentList=subzhservice.getAgentzhPtList(1);//查询机构
				if(agentList!=null && agentList.size()>0){
					for(Subzh sub:agentList){
						if(sub.getCoefficient()!=null){
							BigDecimal coeff = format1("###.###",sub.getCoefficient().doubleValue());
							sub.setCoefficient(coeff);
						}
					}
				}
				model.addAttribute("agentList", agentList);
				List<Subzh> ptList=subzhservice.getAgentzhPtList(2);//查询平台
				model.addAttribute("ptList", ptList);
			}
			model.addAttribute("manage", manage);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return "fund/agentptlist";
	}
	
	
	 private BigDecimal format1(String pattern,double value){   // 此方法专门用于完成数字的格式化显示  
	        DecimalFormat df = new DecimalFormat(pattern);   // 实例化对象，传入模板  
	        String str = df.format(value);     // 格式化数字  
	        return new BigDecimal(str);
	    }  
	
	@RequestMapping("/updateCoeffi")
	@ResponseBody
	public String updateCoeffi(String subzh,String coefficient,String name) {
		int i = 0;
		try {
			Subzh user = subzhservice.selectByPrimaryKey(subzh);
			if(!StringUtil.isAnyNullOrEmpty(coefficient)){
				BigDecimal coe=new BigDecimal(coefficient);
				user.setCoefficient(coe.divide(new BigDecimal(100)));
			}
			user.setName(name);
			i = subzhservice.updateByPrimaryKey(user);
		} catch (Exception e) {
			log.error("修改分成系数失败：" + e.getMessage());
		}
		if (i > 0) {
			return "true";
		} else {
			return "false";
		}

	}
	
    /**
     * 弹出认证信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/showAuth/{id}")
    public String showAuth(@PathVariable("id") String id, Model model) {
        Subzh subzh = subzhservice.selectByPrimaryKey(id);
        model.addAttribute("subzh", subzh);
        return "fund/showAuth";
    }

    /**
     * 实名认证
     * @param authState
     * @param account
     * @return
     */
    @RequestMapping(value = "/auth/{authState}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String auth(@PathVariable("authState") Integer authState, String account) {
        Subzh subzh = subzhservice.selectByPrimaryKey(account);
        if (subzh == null) {
            return "用户不存在";
        }
        
        if(authState==4){
        	subzh.setAuthState(0);
        }else {
        	 if (subzh.getAuthState() != 1) {
                 return "请检查实名认证状态";
             }
        	 subzh.setAuthState(authState); 
        }      
        int i = subzhservice.updateByPrimaryKey(subzh);
        return i > 0 ? "ok" : "认证失败";
    }
    
private Map<String, Object> getCounterFunds(Subzh subzh){
    	
    	Map<String, Object> map=new HashMap<String, Object>();
    	try{
			log.info("调协议查询可用资金");
			Map<String, Object> pmap=new HashMap<String, Object>();
			pmap.put("client_id", subzh.getSubzh());
			JSONObject descriptions = JSONObject.parseObject(JSON.toJSONString(pmap));
			//String con="{\"client_id\":\""+subzh.getSubzh()+"\"}";
			log.info("查询用户资金,输入参数"+descriptions);
			String rbStr = simulateStockService.commonFunction(descriptions.toJSONString(), 11103);//用户资金信息查询
			log.info("log——rbStr===》"+descriptions);
			if(rbStr==null||rbStr=="null" || rbStr.equals("")){
				map.put("status", 10);
				map.put("describe", "地址错误或网络错误");
				//rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
				log.info("log1——obj===》"+obj);
			}else if(rbStr.indexOf("{")<0){
				map.put("status", 11);
				map.put("describe", "返回信息出错");
				rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
				log.info("log2——obj===》"+obj);
			}else{//正常情况下
				 map=JSONObject.parseObject(rbStr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
    	
    	
		return map;   	
    }
}