package com.jcl.controller;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jcl.authdao.UserInfoMapper;
import com.jcl.mongodb.BeanUtil;
import com.jcl.mongodb.MongoUtils;
import com.jcl.pojo.Bdzh;
import com.jcl.pojo.BzjmbMenu;
import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.UserInfo;
import com.jcl.service.BdzhService;
import com.jcl.service.BzjmbMenuService;
import com.jcl.service.CodefeesetMenuService;
import com.jcl.service.RiskTempallService;
import com.jcl.service.SubzhService;
import com.jcl.service.UserInfoService;
import com.jcl.util.Base64;
import com.jcl.util.DeployProperties;
import com.jcl.util.StringUtil;
import com.jcl.util.Util;
import com.jcl.util.sms.MessageUtils;
import com.jcl.vo.Msm;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@RequestMapping("/app")
@Controller
public class AppController {
	public static Logger log = Logger.getLogger(AppController.class);
	@Autowired
	private SubzhService subzhService;
	@Autowired
	private BdzhService bdzhService;
	/*保证金方案信息管理service*/
	@Autowired
	private BzjmbMenuService bzjmbMenuService;
	@Autowired
	private CodefeesetMenuService codefeesetMenuService;
	
	//注入用户认证服务
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/*风控方案信息管理service*/
	@Autowired
	private RiskTempallService riskTempallService;
	
	private static String mainzhzj="main_money";
	@Autowired
	private Datastore dsForStock;
	/**
	 * 跳转到注册页面
	 * @param subzh
	 * @param model
	 * @return
	 */
	@RequestMapping("/skipRegister")
	public String skipRegister(Subzh subzh,Model model) {
		model.addAttribute("subzh", subzh);
		return "register_h5/registerDownload";
	}

	@RequestMapping("/downloadPage")
	public String skipdownpage() {
		
		return "register_h5/downloadPage";
	}
	
	
	/**
	 * 注册接口
	 * @return
	 */
	@RequestMapping(value="/reg",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reg(Subzh subzh,String code) {
		try {
			if(StringUtils.isEmpty(subzh.getPhone())) return "手机号不能为空";
			subzh.setSubzh(subzh.getPhone());
			if(StringUtils.isEmpty(subzh.getPassword())) return "密码不能为空";
			Subzh subzh2 = subzhService.selectByPrimaryKeySubzh(subzh.getPhone());
			if(subzh2 != null) {
				return "用户已存在";
			}
			MongoUtils.change("sms");	
			DBObject d = new BasicDBObject();
			d.put("phone", subzh.getPhone());
			DBCursor cursor = MongoUtils.queryByDBObject(d);
			Msm msm = null;
			while (cursor.hasNext()) {
				DBObject result = cursor.next();
				msm = BeanUtil.dbObject2Bean(result, new Msm());
				long time = (new Date().getTime()-msm.getTime())/1000;
				System.out.println("进来了？"+time);
				if((new Date().getTime()-msm.getTime())/1000>60*5) {
					return "短信已失效,请重新发送";
				}
				if(StringUtils.isEmpty(code)) {
					return "短信验证码不能为空";
				}
				if(!code.equals(msm.getCode())) {
					return "验证码不匹配";
				}
			}
			if(msm==null) {
				return "找不到匹配的验证码";
			}
			subzh.setIsadmin(6);
			byte[] data = subzh.getPhone().getBytes();
			long cookie = Util.Hash64(data, 0, data.length);// 生成随机的cookie
			if (cookie < 0) {
				subzh.setCookie(String.valueOf(Util.readUnsignedLong(cookie)));
			} else {
				subzh.setCookie(String.valueOf(cookie));
			}
			subzh.setZhstate(0);
			subzh.setKhdate(new Date());
			subzh.setIsDelete(0);//是否删除
			subzh.setAuthState(0);//实名认证
			try {
				Bdzh bdzh1=new Bdzh();
				bdzh1.setZhstate(1);
				List<Bdzh> bdzhList = bdzhService.queryBy(bdzh1);
				DB db = dsForStock.getDB();
				DBCollection dbCollection=db.getCollection(mainzhzj);//主账号资金 数据
				int i=0;
				log.info("h5查关联主账号");
				if(bdzhList != null && bdzhList.size() > 0) {//默认资金权益
					for(Bdzh bdzh : bdzhList){
						/*if(bdzh.getSymoney() != null && bdzh.getSymoney().doubleValue() > 1000){//选择当前报单账户
							subzh.setBdtd(String.valueOf(bdzh.getBdzhid()));
							//更新报单账户
							if(bdzh.getAvaamoney() != null){可用资金
								bdzh.setAvaamoney(bdzh.getAvaamoney().subtract(new BigDecimal(1000)));
							} else {
								bdzh.setAvaamoney(new BigDecimal(-1000));
							}
							if(bdzh.getSubinterest() != null){子账户权益
								bdzh.setSubinterest(bdzh.getSubinterest().add(new BigDecimal(1000)));
							} else {
								bdzh.setSubinterest(new BigDecimal(1000));
							}
							bdzh.setSymoney(bdzh.getSymoney().subtract(new BigDecimal(1000)));
							log.info("更新报单账户资金信息：" + bdzhService.updateBdzh(bdzh));
						} */
						DBObject condition = new BasicDBObject();
						condition.put("account", new BasicDBObject("$eq", bdzh.getAccountid()));
						log.info("H5的注册方法：开始查主账号资金");
						DBCursor bdzhcursor = dbCollection.find(condition).skip(0).limit(10);
						log.info("H5的注册方法：查主账号资金结束");
						while (bdzhcursor.hasNext()) {
							BasicDBObject dbObj = (BasicDBObject) bdzhcursor.next();
							log.info("H5的注册方法：取设置主账号资金");
							if(dbObj.containsField("available")){//可用资金：  available可用资金
								double available=dbObj.getDouble("available");	
								if(available>0.01){
									subzh.setBdtd(String.valueOf(bdzh.getBdzhid()));
									i=1;
									break;
								}
							}
							
						}
						if(i>0){
							break;
						}
					}
					if(StringUtils.isEmpty(subzh.getBdtd())){
						int index=bdzhList.size()-1;
						subzh.setBdtd(String.valueOf(bdzhList.get(index).getBdzhid()));
					}
					
				}
			} catch (Exception ebdzh) {
				ebdzh.printStackTrace();
				log.error("查询报单账户资金权益信息异常：" + ebdzh.getMessage());
			}
			/*收费方案*/
			try {
				log.info("h5查关联方案");
				List<CodefeesetMenu> menuList = codefeesetMenuService.selectAll();
				if(menuList != null && menuList.size() > 0){
					boolean isFlag = false;
					for(CodefeesetMenu codefeesetMenu : menuList){
						if(codefeesetMenu.getIsdefault() != null && codefeesetMenu.getIsdefault() == 1){
							subzh.setFeeset(codefeesetMenu.getId().toString());
							isFlag = true;
							break;
						}
					}
					if(!isFlag){
						int index=menuList.size()-1;
						subzh.setFeeset(menuList.get(index).getId().toString());
					}
				} else {
					subzh.setFeeset("1");//默认1
				}
				/*保证金方案*/
				List<BzjmbMenu> bzjList = bzjmbMenuService.selectAll();
				if(bzjList != null && bzjList.size() > 0){
					int index=bzjList.size()-1;
					subzh.setMarginset(bzjList.get(index).getId().toString());
				} else {
					subzh.setMarginset("1");
				}
				/*风控方案*/
				List<RiskTempall> riskTempallList = riskTempallService.selectAll();
				if(riskTempallList != null && riskTempallList.size() > 0){
					int index=riskTempallList.size()-1;
					subzh.setRiskset(riskTempallList.get(index).getId());
				}  else {
					subzh.setRiskset(1);
				}
				log.info("h5查关联方案完成");
			} catch (Exception ef) {
				ef.printStackTrace();
				log.error("获取方案信息异常：" + ef.getMessage());
			}
			
			int result = subzhService.insertSelective(subzh);
			if(result > 0) {
				//将用户信息保存到认证库
				UserInfo userInfo = new UserInfo();
				userInfo.setUsername(subzh.getSubzh());
				userInfo.setPassword(subzh.getPassword());
				userInfo.setTelephone(subzh.getPhone());
				log.info("准备............认证库插入数据.....>");
				int add = userInfoMapper.insertSelective(userInfo);
				log.info("认证库插入数据.....>"+add);
				if(add > 0) {
					return "ok";
				}else {
					//删除
					boolean deleteBySubzh = subzhService.deleteBySubzh(subzh.getSubzh());
					if(!deleteBySubzh) {
						log.info("认证库插入失败，subzh表中：["+subzh.getSubzh()+"]删除失败！");
						return "数据回滚失败";
					}
					return "认证库插入失败";
				}
			}
			return "注册失败";
		} catch (Exception e) {
			e.printStackTrace();
			return "系统异常";
		}
	}
	
	//public static final String MESSAGE_CONFIG = DeployProperties.getInstance().getMessageConfig();
	
	/**
	 * 短信发送接口
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/sendsms",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sendsms(String phone) {
		try {
			if(StringUtils.isEmpty(phone))return "NoOk";
			Subzh subzh2 = subzhService.selectByPrimaryKeySubzh(phone);
			if(subzh2 != null) {
				return "用户已存在";
			}
			MongoUtils.change("sms");	
			DBObject d = new BasicDBObject();
			d.put("phone", phone);
			MongoUtils.deleteDB(d);
			String code = String.valueOf((int)(Math.random()*9000)+1000);
			String content = URLEncoder.encode("验证码:" + code+"。您正在使用短信验证码登陆功能，该验证码用于身份验证，请勿泄露给他人使用。","GBK");   //--股期-希奥
			System.out.println("短信验证码..........................>"+code);
			MessageUtils.sendqrMsg(phone, code);//启瑞
			//MessageUtils.sendMassager(phone, content);//--股期-希奥
			//MessageUtils.sendMsg(phone, code);//阿里云短信

			DBObject db = new BasicDBObject();
			db.put("code", code);
			db.put("phone", phone);
			db.put("time", new Date().getTime());
			MongoUtils.addOne(db);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "NoOk";
		}
	}
	
	
	/**
	 * 验证手机号是否唯一
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/verifyPhone",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String verifyPhone(String phone) {
		try {
			Subzh subzh2 = subzhService.selectByPrimaryKeySubzh(phone);
			if(subzh2 != null) {
				return "用户已存在";
			}
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "系统验证异常";
		}	
	}
	
	@RequestMapping("/getRegisterProtocol")
	public String getRegisterProtocol() {
		return "register_h5/registerProtocol";
	}
	
	
	/**
	 * 手机端短信发送接口
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/sendsmsPort",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String sendsmsPhone(HttpServletRequest request) {
		Map<String,String> dataMap = new HashMap<String,String>();
		log.info("手机发送短信");
		try {
			String phone = request.getParameter("phone");
			if(StringUtils.isEmpty(phone)) {
				dataMap.put("code", "500");
				dataMap.put("msg", "手机号不能为空");
				return JSON.toJSONString(dataMap);
			}
			if(!StringUtil.regularExpression(phone, "^(13|15|18|17|14)\\d{9}$")) {
				dataMap.put("code", "501");
				dataMap.put("msg", "请输入正确的手机号格式");
				return JSON.toJSONString(dataMap);
			}
			Subzh subzh2 = subzhService.selectByPrimaryKeySubzh(phone);
			if(subzh2 != null) {
				dataMap.put("code", "502");
				dataMap.put("msg", "用户已存在");
				return JSON.toJSONString(dataMap);
			}
			MongoUtils.change("sms");	
			DBObject d = new BasicDBObject();
			d.put("phone", phone);
			MongoUtils.deleteDB(d);
			String code = String.valueOf((int)(Math.random()*9000)+1000);
			//MessageUtils.sendMassager(phone, code);sendMsg
			log.info("手机验证"+code);
			MessageUtils.sendMsg(phone, code);//阿里云短信模板
			
			//String content = URLEncoder.encode("验证码:" + code,"GBK");   
			

			//MessageUtils.sendqrMsg(phone, code);//启瑞短信
			String content = URLEncoder.encode("验证码:" + code+"。您正在使用短信验证码登陆功能，该验证码用于身份验证，请勿泄露给他人使用。","GBK");   //--股期-希奥
			MessageUtils.sendMassager(phone, content);//--股期-希奥

			MessageUtils.sendqrMsg(phone, code);//启瑞短信
			

			//MessageUtils.sendqrMsg(phone, code);//启瑞短信
			

			DBObject db = new BasicDBObject();
			db.put("code", code);
			db.put("phone", phone);
			db.put("time", new Date().getTime());
			MongoUtils.addOne(db);
			dataMap.put("code", "200");
			dataMap.put("msg", "短信发送成功");
			return JSON.toJSONString(dataMap);
		} catch (Exception e) {
			dataMap.put("code", "503");
			dataMap.put("msg", "系统异常");
			return JSON.toJSONString(dataMap);
		}
	}
	
	
	/**
	 * 手机端注册接口
	 * @return
	 */
	@RequestMapping(value="/regPort",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String regPort(HttpServletRequest request) {
		Map<String,String> dataMap = new HashMap<String,String>();
		Subzh subzh = new Subzh();
		try {
			String phone = request.getParameter("phone").trim();
			String code = request.getParameter("code").trim();
			String password = new String(Base64.decode(request.getParameter("password")),"iso-8859-1");
			String affirmPassword = new String(Base64.decode(request.getParameter("affirmPassword")),"iso-8859-1");
			String inviteCode = request.getParameter("inviteCode").trim();
			if(StringUtils.isEmpty(phone)) {
				dataMap.put("code", "500");
				dataMap.put("msg", "手机号不能为空");
				return JSON.toJSONString(dataMap);
			}
			if(!StringUtil.regularExpression(phone, "^(13|15|18|17|14)\\d{9}$")) {
				dataMap.put("code", "501");
				dataMap.put("msg", "请输入正确的手机号格式");
				return JSON.toJSONString(dataMap);
			}
			MongoUtils.change("sms");	
			DBObject d = new BasicDBObject();
			d.put("phone", phone);
			DBCursor cursor = MongoUtils.queryByDBObject(d);
			Msm msm = null;
			while (cursor.hasNext()) {
				DBObject result = cursor.next();
				msm = BeanUtil.dbObject2Bean(result, new Msm());
				long time = (new Date().getTime()-msm.getTime())/1000;
				if(StringUtils.isEmpty(code)) {
					dataMap.put("code", "502");
					dataMap.put("msg", "短信验证码不能为空");
					return JSON.toJSONString(dataMap);
				}
				if((new Date().getTime()-msm.getTime())/1000>60*5) {
					dataMap.put("code", "503");
					dataMap.put("msg", "短信已失效,请重新发送");
					return JSON.toJSONString(dataMap);
				}
				log.info("code"+code+"----msm.getCode()"+msm.getCode());
				if(!code.equals(msm.getCode())) {
					dataMap.put("code", "504");
					dataMap.put("msg", "验证码不匹配");
					return JSON.toJSONString(dataMap);
				}
			}
			if(msm==null) {
				dataMap.put("code", "505");
				dataMap.put("msg", "找不到匹配的验证码");
				return JSON.toJSONString(dataMap);
			}
			subzh.setSubzh(phone);
			if(StringUtils.isEmpty(password)) {
				dataMap.put("code", "506");
				dataMap.put("msg", "密码不能为空");
				return JSON.toJSONString(dataMap);
			}
			if(StringUtils.isEmpty(affirmPassword)) {
				dataMap.put("code", "507");
				dataMap.put("msg", "确认密码不能为空");
				return JSON.toJSONString(dataMap);
			}
			if(!password.equals(affirmPassword)) {
				dataMap.put("code", "508");
				dataMap.put("msg", "密码与确认密码不一致");
				return JSON.toJSONString(dataMap);
			}
			if(StringUtils.isEmpty("inviteCode")) {
				dataMap.put("code", "509");
				dataMap.put("msg", "邀请码不能为空");
				return JSON.toJSONString(dataMap);
			}
			Subzh subzh2 = subzhService.selectByPrimaryKeySubzh(phone);
			if(subzh2 != null) {
				dataMap.put("code", "510");
				dataMap.put("msg", "用户已存在");
				return JSON.toJSONString(dataMap);
			}
			Subzh inviter = subzhService.getSubzhByInviteCode(inviteCode);
			if(inviter != null) {
				subzh.setPagentzh(inviter.getSubzh());
				subzh.setManage(inviter.getManage());
				subzh.setAllocpt(inviter.getAllocpt());
				if (inviter.getIsadmin() == 3) {//渠道
				    subzh.setAllocchannel(inviter.getSubzh());
                }
				if (inviter.getIsadmin() == 4) {//代理
					subzh.setAllocchannel(inviter.getAllocchannel());
					subzh.setAllocagent(inviter.getSubzh());
				}
				if (inviter.getIsadmin() == 5) {//经纪人
					subzh.setAllocchannel(inviter.getAllocchannel());
					subzh.setAllocagent(inviter.getAllocagent());
					subzh.setAllocbroker(inviter.getSubzh());
				}
			}else {
				dataMap.put("code", "511");
				dataMap.put("msg", "不存在的邀请码");
				return JSON.toJSONString(dataMap);
			}
			subzh.setPassword(password);
			subzh.setIsadmin(6);
			subzh.setKhdate(new Date());
			subzh.setIsDelete(0);//是否删除
			subzh.setAuthState(0);//实名认证
			subzh.setPhone(phone);
			byte[] data = phone.getBytes();
			long cookie = Util.Hash64(data, 0, data.length);// 生成随机的cookie
			if (cookie < 0) {
				subzh.setCookie(String.valueOf(Util.readUnsignedLong(cookie)));
			} else {
				subzh.setCookie(String.valueOf(cookie));
			}
			subzh.setZhstate(0);
			try {
				Bdzh bdzh1=new Bdzh();
				bdzh1.setZhstate(1);
				List<Bdzh> bdzhList = bdzhService.queryBy(bdzh1);
				DB db = dsForStock.getDB();
				DBCollection dbCollection=db.getCollection(mainzhzj);//主账号资金 数据
				int i=0;
				log.info("h5查关联主账号");
				if(bdzhList != null && bdzhList.size() > 0) {//默认资金权益
					for(Bdzh bdzh : bdzhList){
						/*if(bdzh.getSymoney() != null && bdzh.getSymoney().doubleValue() > 1000){//选择当前报单账户
							subzh.setBdtd(String.valueOf(bdzh.getBdzhid()));
							//更新报单账户
							if(bdzh.getAvaamoney() != null){可用资金
								bdzh.setAvaamoney(bdzh.getAvaamoney().subtract(new BigDecimal(1000)));
							} else {
								bdzh.setAvaamoney(new BigDecimal(-1000));
							}
							if(bdzh.getSubinterest() != null){子账户权益
								bdzh.setSubinterest(bdzh.getSubinterest().add(new BigDecimal(1000)));
							} else {
								bdzh.setSubinterest(new BigDecimal(1000));
							}
							bdzh.setSymoney(bdzh.getSymoney().subtract(new BigDecimal(1000)));
							log.info("更新报单账户资金信息：" + bdzhService.updateBdzh(bdzh));
						} */
						DBObject condition = new BasicDBObject();
						condition.put("account", new BasicDBObject("$eq", bdzh.getAccountid()));
						log.info("H5的注册方法：开始查主账号资金");
						DBCursor bdzhcursor = dbCollection.find(condition).skip(0).limit(10);
						log.info("H5的注册方法：查主账号资金结束");
						while (bdzhcursor.hasNext()) {
							BasicDBObject dbObj = (BasicDBObject) bdzhcursor.next();
							log.info("H5的注册方法：取设置主账号资金");
							if(dbObj.containsField("available")){//可用资金：  available可用资金
								double available=dbObj.getDouble("available");	
								if(available>0.01){
									subzh.setBdtd(String.valueOf(bdzh.getBdzhid()));
									i=1;
									break;
								}
							}
							
						}
						if(i>0){
							break;
						}
					}
					if(StringUtils.isEmpty(subzh.getBdtd())){
						int index=bdzhList.size()-1;
						subzh.setBdtd(String.valueOf(bdzhList.get(index).getBdzhid()));
					}
					
				}
			} catch (Exception ebdzh) {
				ebdzh.printStackTrace();
				log.error("查询报单账户资金权益信息异常：" + ebdzh.getMessage());
			}
			/*收费方案*/
			try {
				log.info("h5查关联方案");
				List<CodefeesetMenu> menuList = codefeesetMenuService.selectAll();
				if(menuList != null && menuList.size() > 0){
					boolean isFlag = false;
					for(CodefeesetMenu codefeesetMenu : menuList){
						if(codefeesetMenu.getIsdefault() != null && codefeesetMenu.getIsdefault() == 1){
							subzh.setFeeset(codefeesetMenu.getId().toString());
							isFlag = true;
							break;
						}
					}
					if(!isFlag){
						int index=menuList.size()-1;
						subzh.setFeeset(menuList.get(index).getId().toString());
					}
				} else {
					subzh.setFeeset("1");//默认1
				}
				/*保证金方案*/
				List<BzjmbMenu> bzjList = bzjmbMenuService.selectAll();
				if(bzjList != null && bzjList.size() > 0){
					int index=bzjList.size()-1;
					subzh.setMarginset(bzjList.get(index).getId().toString());
				} else {
					subzh.setMarginset("1");
				}
				/*风控方案*/
				List<RiskTempall> riskTempallList = riskTempallService.selectAll();
				if(riskTempallList != null && riskTempallList.size() > 0){
					int index=riskTempallList.size()-1;
					subzh.setRiskset(riskTempallList.get(index).getId());
				}  else {
					subzh.setRiskset(1);
				}
				log.info("h5查关联方案完成");
			} catch (Exception ef) {
				ef.printStackTrace();
				log.error("获取方案信息异常：" + ef.getMessage());
			}
			int result = subzhService.insertSelective(subzh);
			if(result > 0) {
				//将用户信息保存到认证库
				UserInfo userInfo = new UserInfo();
				userInfo.setUsername(subzh.getSubzh());
				userInfo.setPassword(subzh.getPassword());
				userInfo.setTelephone(subzh.getPhone());
				int add = userInfoMapper.insertSelective(userInfo);
				if(add > 0) {
					dataMap.put("code", "200");
					dataMap.put("msg", "注册成功");
					return JSON.toJSONString(dataMap);
				}else {
					//删除
					boolean deleteBySubzh = subzhService.deleteBySubzh(subzh.getSubzh());
					if(!deleteBySubzh) {
						log.info("手机注册接口认证库插入失败，subzh表中：["+subzh.getSubzh()+"]删除失败！");
						dataMap.put("code", "512");
						dataMap.put("msg", "认证库插入失败，数据回滚失败");
						return JSON.toJSONString(dataMap);
					}
					dataMap.put("code", "513");
					dataMap.put("msg", "认证库插入失败");    
					return JSON.toJSONString(dataMap);
				}
			}
			dataMap.put("code", "514");
			dataMap.put("msg", "注册失败");
			return JSON.toJSONString(dataMap);
		} catch (Exception e) {
			dataMap.put("code", "515");
			dataMap.put("msg", "系统异常");
			return JSON.toJSONString(dataMap);
		}
	}
	
}
