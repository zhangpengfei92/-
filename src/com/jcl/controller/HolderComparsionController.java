/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @HolderComparsionController.java
 * 功能概要  : 
 * 做成日期  : @2018年5月4
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcl.comm.PaginationContext;
import com.jcl.mongodb.BeanUtil;
import com.jcl.mongodb.MongoUtils;
import com.jcl.mongodb.Page;
import com.jcl.pojo.HoldComparison;
import com.jcl.pojo.Holderdb;
import com.jcl.pojo.Subzh;
import com.jcl.service.SubzhService;
import com.jcl.util.Constant;
import com.jcl.util.StringUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/** 
 * @author zpf
 * @version 1.0
 */
@RequestMapping("/HolderComparsion")
@Controller
public class HolderComparsionController {
	
	public static Logger log = Logger.getLogger(HolderComparsionController.class);
	private static final String SUB_HOLDER = "sub_holder";
	@Autowired
	private SubzhService subzhservice;
	@Autowired
	private Datastore dsForStock;
	/*@RequestMapping("/queryList")
	public String queryOrderList(Model model,HttpSession session) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "6");
		try {
			Page userpage=new Page();
			MongoUtils.change(SUB_HOLDER);
			userpage.setInitialSize(userpage.getPagenum());
			
			DBCollection collection = MongoUtils.change("sub_holder");
			BasicDBObject key = new BasicDBObject(); 
			key.put("main_zh", "$main_zh");  
			key.put("mark", "$mark");  
	        key.put("code", "$code");  
	        key.put("order_bs", "$order_bs");  
	        //条件  
	        BasicDBObject cond = new BasicDBObject();    
	        //初始化  
	        BasicDBObject initial = new BasicDBObject();    
	        initial.append("total", 0);    
	        //reduce  
	        String reduce = "function Reduce(doc, out) { " +    
	                "  out.total+=doc.vol;" +    
	                "}";    
	         Set<String> codeset=new HashSet<String>();
	         
	         List<HolderComparsionVo> hlist = new ArrayList<HolderComparsionVo>();
	        BasicDBList groupList=(BasicDBList) collection.group(key, cond, initial, reduce);  
	        if(groupList!=null&&groupList.size()>0){  
	            for(int i=0;i<groupList.size();i++){   
	                BasicDBObject obj=(BasicDBObject) groupList.get(i);  
	                HolderComparsionVo hvo = new HolderComparsionVo();
	                try {
	               
	                	codeset.add(obj.getString("code"));
	                	hvo.setMain_zh(obj.getString("main_zh"));
	                	hvo.setCode(obj.getString("code"));
	                	hvo.setMark(obj.getInt("mark"));
	                	hvo.setVol(obj.getInt("total"));
	                	hlist.add(hvo);

					} catch (Exception e) {
						e.printStackTrace();
					}  
	            }    
	        } 
	        List<HolderComparsionVo> list = new ArrayList<HolderComparsionVo>();
	     	for (int x = 0; x < hlist.size(); x++) {
				for (int j = x+1; j < hlist.size(); j++) {
					System.out.println(hlist.get(x).getCode()==hlist.get(j).getCode());
						if(hlist.get(x).getCode()==hlist.get(j).getCode()){	
							HolderComparsionVo hvo = new HolderComparsionVo();
							hvo.setMain_zh(hlist.get(x).getMain_zh());
							hvo.setCode(hlist.get(x).getCode());
							hvo.setMark(hlist.get(x).getMark());
							//判断是多还是空
							System.out.println(hlist.get(x).getOrder_bs()==1);
							if(hlist.get(x).getOrder_bs()==2) {
								hvo.setHoldMany(hlist.get(x).getVol());
								hvo.setHoldnull(0);
								hvo.setMzh(hvo.getHoldMany(), hvo.getHoldnull());
			                	list.add(hvo);
							}else{
								hvo.setHoldnull(hlist.get(x).getVol());
								hvo.setHoldMany(0);
								hvo.setMzh(hvo.getHoldMany(), hvo.getHoldnull());
								list.add(hvo);								
							}								
						}else {	
							System.out.println(hlist.get(x).getOrder_bs()==1);
							if(hlist.get(x).getOrder_bs()==2) {	
								HolderComparsionVo hvo = new HolderComparsionVo();
								hvo.setMain_zh(hlist.get(x).getMain_zh());
								hvo.setCode(hlist.get(x).getCode());
								hvo.setMark(hlist.get(x).getMark());
								hvo.setHoldMany(hlist.get(x).getVol()); 
								hvo.setHoldnull(0);
								hvo.setMzh(hvo.getHoldMany(), hvo.getHoldnull());
			                	list.add(hvo);
							}else{
								HolderComparsionVo hvo = new HolderComparsionVo();
								hvo.setMain_zh(hlist.get(x).getMain_zh());
								hvo.setCode(hlist.get(x).getCode());
								hvo.setMark(hlist.get(x).getMark());
								hvo.setHoldnull(hlist.get(x).getVol());
								hvo.setHoldMany(0);
								hvo.setMzh(hvo.getHoldMany(), hvo.getHoldnull());
			                	list.add(hvo);								
							}
								
							}
						}
					}
			userpage.setCountsize((long)list.size());
			userpage.setPagecount((long)list.size());
			model.addAttribute("hlist", list);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "fund/holderCompareList";	
	} */
	
	
	@RequestMapping("/queryList")
	public String holderDbList(Model model,HttpSession session,String bdzh,Integer mark,String code){
		try{
			session.setAttribute(Constant.SESSION_LEFTMENU, "6");
			long totalCount=0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);//当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
			String pt=(String) session.getAttribute(Constant.SESSION_PLATEFORM);
			int start = (PaginationContext.getPageNum()-1)*PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum()*PaginationContext.getPageSize();
			Page<Holderdb> fundPage=new Page<Holderdb>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<Holderdb> fmList=new ArrayList<Holderdb>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection=db.getCollection("main_holder");//主账号持仓对比 数据
			DBObject condition = new BasicDBObject();
			if(!StringUtil.isAnyNullOrEmpty(bdzh)){
				condition.put("account", new BasicDBObject("$eq", bdzh));
			}
			if(!StringUtil.isAnyNullOrEmpty(code)){
				condition.put("code", new BasicDBObject("$eq", code));
			}
			
			if(mark!=null){
				condition.put("mark", new BasicDBObject("$eq", mark));
			}

			Subzh subzh=new Subzh();
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
			subzh.setIsadmin(6);
			List<Subzh> sublist=subzhservice.getSubzhLevelList(subzh);//登录用户可以查看到的子账号
			BasicDBList values = new BasicDBList();
			if(sublist!=null && sublist.size()>0){
				for(Subzh sub:sublist){
					values.add(sub.getSubzh());
				}
			}
			if(values.size()>0){
				//condition.put("sub_zh",  new BasicDBObject("$in", values));
				DBObject subholder = new BasicDBObject();
				subholder.put("subholder", new BasicDBObject("$elemMatch", new BasicDBObject("account", new BasicDBObject("$in", values))));
				if(condition.containsField("account")||condition.containsField("code")||condition.containsField("mark")){
					condition=new BasicDBObject("$and", Arrays.asList(condition, subholder));//当日成交记录
				}else{
					condition=subholder;
				}
				
			}else{
				return "fund/holderCompareList";
			}
			
			
			DBObject orderBy = new BasicDBObject();  
			orderBy.put("vol", -1);//按vol倒序排  
			totalCount=dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start).limit(PaginationContext.getPageSize());
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				Holderdb ccdb=new Holderdb();
				List<Map<String,Object>> list=(List<Map<String,Object>>)dbObj.get("subholder");
				int subtotal=0;
				if(list!=null && list.size()>0){
					for(Map<String,Object> map:list){
						String account=(String)map.get("account");
						boolean b=checkIsInAccess(values,account);
						if(b){
							Integer vol2=(Integer)map.get("vol");
							if(vol2==null){
								vol2=0;
							}
							subtotal+=vol2;
						}
						
					}
				}
				
				ccdb=getFromMongodb(dbObj,subtotal);
				
				fmList.add(ccdb);
			}
			fundPage.setList(fmList);
			fundPage.setCountsize(totalCount);
			fundPage.setPagecount(totalCount);
			model.addAttribute("page", fundPage);
			model.addAttribute("bdzh", bdzh);
			model.addAttribute("mark", mark);
			model.addAttribute("code", code);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "fund/holderCompareList";
	}
	
	
	
	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-6
	 * @decribe
	 * @param dbObj
	 * @param subtotal
	 * @return
	 */
	private Holderdb getFromMongodb(BasicDBObject dbObj, int subtotal) {
		Holderdb ccdb=new Holderdb();
		String account=dbObj.getString("account");
		String code=dbObj.getString("code");
		if(dbObj.containsField("vol")){
			Integer vol=dbObj.getInt("vol");
			ccdb.setVol(vol);
		}
		if(dbObj.containsField("today_vol")){
			Integer todayVol=dbObj.getInt("today_vol");
			ccdb.setToday_vol(todayVol);
		}
		if(dbObj.containsField("freeze_vol")){
			Integer freezeVol=dbObj.getInt("freeze_vol");
			ccdb.setFreeze_vol(freezeVol);
		}
		if(dbObj.containsField("today_freeze_vol")){
			Integer toFreezeVol=dbObj.getInt("today_freeze_vol");
			ccdb.setToday_freeze_vol(toFreezeVol);
		}
		if(dbObj.containsField("margin")){
			Double margin=dbObj.getDouble("margin");
			ccdb.setMargin(margin);
		}
		if(dbObj.containsField("open_cost")){
			Double openCost=dbObj.getDouble("open_cost");
			ccdb.setOpen_cost(openCost);
		}
		if(dbObj.containsField("position_cost")){
			Double positionCost=dbObj.getDouble("position_cost");
			ccdb.setPosition_cost(positionCost);
		}
		if(dbObj.containsField("order_bs")){
			Integer orderBs=dbObj.getInt("order_bs");
			ccdb.setOrder_bs(orderBs);
		}
		
		if(dbObj.containsField("name")){
			ccdb.setName(dbObj.getString("name"));
		}
		ccdb.setAccount(account);
		ccdb.setCode(code);
		ccdb.setSubNum(subtotal);
		return ccdb;
	}



	//判断某个查询的子账号是否是登录用户的权限范围内
	private boolean checkIsInAccess(BasicDBList values,String subzh){
		if(values==null){
			return false;
		}
		boolean b=false;
		for(Object o:values){
			if(StringUtil.isAnyNullOrEmpty(subzh)){
				return b;
			}
			if(subzh.equals(o)){
				b=true;
				break;
			}
		}
		return b;
	}
	
	
	
	@RequestMapping("/queryPage")
	public String queryPage(Model model,Integer pagenum,String bdzh) {
		
		try {
			Page userpage=new Page();
			userpage.setPagenum(pagenum);
			userpage.setInitialSize(pagenum);
			MongoUtils.change(SUB_HOLDER);
			List<HoldComparison> hlist=new ArrayList<HoldComparison>();
			DBCursor cursor ;
			if(bdzh==null||bdzh==""){
				bdzh="";
			cursor = MongoUtils.queryPage(userpage.getInitialSize(), userpage.getPagesize());
			}else {
				DBObject documents=new BasicDBObject("bdzh",bdzh);
				cursor = MongoUtils.queryPageByExample(userpage.getInitialSize(), userpage.getPagesize(),documents);
			}
			while(cursor.hasNext()) {
				HoldComparison holdComparison = new HoldComparison();
				DBObject object = cursor.next();
				hlist.add(BeanUtil.dbObject2Bean(object, holdComparison));
			}
			HoldComparison holdComparison1 = new HoldComparison();
			DBObject dbObject = BeanUtil.bean2DBObject(holdComparison1);
			Long count = MongoUtils.count(dbObject);
			userpage.setCountsize(count);
			userpage.setPagecount(count);
			model.addAttribute("hlist", hlist);
			model.addAttribute("subzh", bdzh);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "fund/holderCompareList";	
	} 
}
