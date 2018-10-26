package com.jcl.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.pojo.Subzh;
import com.jcl.service.UserInfoDataService;
import com.jcl.util.Base64;
import com.jcl.util.CommonFunc;
import com.jcl.util.Constant;
import com.jcl.util.DeployProperties;
import com.jcl.util.FileUtil;
import com.jcl.util.MD5Change;
import com.jcl.util.RedisUtil;
import com.jcl.util.StringUtil;


@Controller
@RequestMapping("/userinfoData")
public class UserInfoDataController {
	
	public static Logger log = Logger.getLogger(UserInfoDataController.class);
	
	private static final String sendEmail_from = DeployProperties.getInstance().getSendEmailFrom();
	private static final String project_path = DeployProperties.getInstance().getPublicProjectePath();
	private static final String http_appFile_path = DeployProperties.getInstance().getPublichttpAppPath();//访问路径
	private static final String app_file_path = DeployProperties.getInstance().getPublicAppPath();//上传路径
	
	private static final String message_username = DeployProperties.getInstance().getSendMessageUsername();
	private static final String message_password = DeployProperties.getInstance().getSendMessagePassword();
	private static final String message_url = DeployProperties.getInstance().getSendMessageUrl();
	private static final String message_uid = DeployProperties.getInstance().getSendMessageUid();
	@Autowired
	private UserInfoDataService userInfoDataService;

	/**
	 * app登录
	 * @param request
	 * @return map
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/userLogin")
	@ResponseBody
	public Map<String,Object> userLogin(HttpServletRequest request,HttpSession session) {
//		Gson gson = new Gson();
		String sessionId=request.getSession().getId();
		
		String userPhone = request.getParameter("phone");
		String userPwd = request.getParameter("password");
		/*手机类型*/
		String phoneType = request.getParameter("location");
		if(!StringUtil.isAllNullOrEmpty(phoneType)){
			byte[] base64 = Base64.decode(userPwd);
			try {
				userPwd = new String(base64,"iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", userPhone);
		map.put("password", userPwd);
		BigDecimal zero = BigDecimal.ZERO;
		//验证登录信息
		List<Subzh> list = userInfoDataService.userLogin(map);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(list != null && list.size()>0){
			session.setAttribute(Constant.SESSION_ACCOUNTID, list.get(0).getPhone());
			session.setAttribute(Constant.SESSION_LOGINNAME, list.get(0).getSubzh());
			Subzh sh = list.get(0);
			BigDecimal rzj = sh.getRzj();
			BigDecimal xzj = sh.getXzj();
			DecimalFormat df = new DecimalFormat("######0.00");
			if(rzj != null && rzj.compareTo(zero) !=0 ){
				rzj = new BigDecimal(df.format(rzj));
				sh.setRzj(rzj);
			}else{
				sh.setRzj(zero);
			}
			if(xzj != null && xzj.compareTo(zero) !=0){
				xzj = new BigDecimal(df.format(xzj));
				sh.setXzj(xzj);
			}else{
				sh.setXzj(zero);
			}
			if(sh.getBzj() != null){
				sh.setBzj(new BigDecimal(df.format(sh.getBzj())));
			}
			session.setAttribute("userinfo", sh);
			
			resultMap.put("code", "0");
			resultMap.put("message", "登录成功");
			resultMap.put("sid", sessionId);
			resultMap.put("subzh", sh.getSubzh());
		}else{
			resultMap.put("code", "1");
			resultMap.put("message", "账号或密码错误");
		}
		return resultMap;
	}

	/**
	 * app注册
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userRegister")
	@ResponseBody
	public Map<String,Object> userReg(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			String userPhone = request.getParameter("phone");
			String userPwd = request.getParameter("password");
			String channel = request.getParameter("channel");//渠道
			String broker = request.getParameter("broker");//经纪人
			//手机类型
			String localsource = request.getParameter("location");
			if(!StringUtil.isAllNullOrEmpty(localsource)){
				byte[] base64 = Base64.decode(userPwd);
				try {
					userPwd = new String(base64,"iso-8859-1");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if(StringUtil.isAllNullOrEmpty(localsource)){
				String yzm = request.getParameter("yzm");
				boolean bl = checkEmailCodeByEmail(userPhone,yzm);
				if(!bl){
					resultMap.put("code", "1");
					resultMap.put("message", "短信验证码不匹配");
					return resultMap;
				}
			}
			Map<String,Object> regMap = new HashMap<String,Object>();
			regMap.put("username", userPhone);
			List<Subzh> list = userInfoDataService.userLogin(regMap);
			if(list != null && list.size()>0){
				resultMap.put("code", "1");
				resultMap.put("message", "手机号已存在");
				return resultMap;
			}
			regMap.put("pagentzh", broker);
			String strs = "0123456789";
			String str = RandomStringUtils.random(8, strs);
			regMap.put("subzh", broker.substring(0, 2) + str);
			regMap.put("password", userPwd);
			regMap.put("phone", userPhone);
			regMap.put("headPicture", "touxiang.png");
			
			int i = userInfoDataService.regUserInfoData(regMap);
			
			if(i > 0){
				resultMap.put("code", "0");
				resultMap.put("message", "注册成功");
			}else{
				resultMap.put("code", "1");
				resultMap.put("message", "注册失败");
			}
		} catch (Exception e) {
			log.error("注册失败",e);
		}
		return resultMap;
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userUpdPwd")
	@ResponseBody
	public Map<String,Object> updatePwd(HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			String userPhone = request.getParameter("phone");
			String subzh = request.getParameter("subzh");
			String oldPwd = request.getParameter("password");
			String newPwd = request.getParameter("newpassword");
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username", userPhone);
			map.put("subzh", subzh);
			map.put("password", oldPwd);
			map.put("newPassword", newPwd);
			
			List<Subzh> list = userInfoDataService.userLogin(map);
			if(list != null && list.size()>0){
				int i = userInfoDataService.updatePwd(map);
				if(i > 0){
					resultMap.put("code", "0");
					resultMap.put("message", "修改密码成功");
				}else{
					resultMap.put("code", "1");
					resultMap.put("message", "修改密码失败");
				}
			}else{
				resultMap.put("code", "1");
				resultMap.put("message", "原密码错误");
			}
		} catch (Exception e) {
			resultMap.put("code", "1");
			resultMap.put("message", "修改密码失败");
			log.error("修改密码失败",e);
		}
		
		return resultMap;
	}
	/**
	 * 获取短信验证码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getMsg")
	@ResponseBody
	public Map<String,Object> getMsgByPhone(HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String phoneNumber = request.getParameter("phone");
		if(!StringUtil.isAllNullOrEmpty(RedisUtil.getString(phoneNumber+"time"))){
			resultMap.put("code", "2");
			return resultMap;
		}
		RedisUtil.setString(phoneNumber+"time",1*60, phoneNumber);
		/*生成6位验证码*/
		String sixRandomStr = CommonFunc.getSixRandomStr();
		RedisUtil.setString(phoneNumber,5*60, sixRandomStr);
		
		String content = sixRandomStr;
//		boolean msgFlag = false;
		if(!StringUtil.isAnyNullOrEmpty(phoneNumber)){
			
//			try {
//				MessageUtils.sendMassager(phoneNumber, content);
//				resultMap.put("code", "0");
//				resultMap.put("message", "短信发送成功");
//				resultMap.put("messagecode", sixRandomStr);
//			} catch (Exception e) {
//				resultMap.put("code", "1");
//			    log.info("发送短信异常：phone->" + phoneNumber + e.getMessage());
//			}// 发送短信
			
			/*将随机验证码保存在缓存中*/
//			RedisUtil.setString(phoneNumber,5*60, sixRandomStr);
			try {
				HttpClient httpClient = new HttpClient();
				
				String auth = MD5Change.GetMD5Code(message_username+message_password);
//				String content = java.net.URLEncoder.encode(sixRandomStr, "gbk");
				log.info("message_url->"+ message_url);
//				org.apache.commons.httpclient.methods.PostMethod
				PostMethod postMethod = new PostMethod(message_url);
				NameValuePair[] data = {
							new NameValuePair("uid", message_uid),
							new NameValuePair("auth", auth),
							new NameValuePair("mobile", phoneNumber),
							new NameValuePair("expid", "0"),
							new NameValuePair("msg",content) };
				postMethod.setRequestBody(data);
				int statusCode = httpClient.executeMethod(postMethod);
				
				if (statusCode == HttpStatus.SC_OK) {
					String sms = postMethod.getResponseBodyAsString();
					log.info("phone->" + phoneNumber+ " " + content + " " + sms);
					resultMap.put("code", "0");
					resultMap.put("message", "短信发送成功");
					resultMap.put("messagecode", sixRandomStr);
				} else {
					resultMap.put("code", "1");
					resultMap.put("message", "短信发送失败");
				}
			} catch (Exception e) {
//				this.renderText("false");
				resultMap.put("code", "1");
			    log.info("发送短信异常：phone->" + phoneNumber + e.getMessage());
			}
		}

		return resultMap;
	}
	
	/**
	 * 校验手机验证码
	 * @return
	 */
	@RequestMapping(value="/checkMsg")
	@ResponseBody
	public Map<String,Object> truemessages(HttpServletRequest request){
		String phone = request.getParameter("phone");
		String messagecode = request.getParameter("messagecode");
		String code = RedisUtil.getString(phone);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if (messagecode.equals(code)) {
			resultMap.put("code", "0");
			resultMap.put("message", "短信验证成功");
		}else {
			resultMap.put("code", "1");
			resultMap.put("message", "短信验证失败");
		}
		return resultMap;
	}
	/**
	 * 重设密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/resPwd")
	@ResponseBody
	public Map<String,Object> resPwd(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			String userPhone = request.getParameter("phone");
			String userPwd = request.getParameter("password");
			String location = request.getParameter("location");
			if(StringUtil.isAllNullOrEmpty(location)){
				userPwd = StringUtil.getElement(userPwd,"password");
			}
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username", userPhone);
			map.put("newPassword", userPwd);
			
			int i = userInfoDataService.updatePwd(map);
			if(i > 0){
				session.setAttribute(Constant.SESSION_LOGINNAME, null);
				session.setAttribute(Constant.SESSION_ACCOUNTID, null);
				session.setAttribute("usertype", null);
				resultMap.put("code", "0");
				resultMap.put("message", "重设密码成功");
			}else{
				resultMap.put("code", "1");
				resultMap.put("message", "重设密码失败");
			}
		} catch (Exception e) {
			log.error("重设密码失败",e);
		}
		
		return resultMap;
	}
	
	/**
	 * 个人设置
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/setPersonal")
	@ResponseBody
	public Map<String,Object> setPersonal (HttpServletRequest request){
//		Gson gson = new Gson();
		String userPhone = request.getParameter("phone");
		String truename = request.getParameter("truename");
		String profile = request.getParameter("profile");
		if(!StringUtil.isAnyNullOrEmpty(truename)){
			try {
				truename = new String(truename.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				log.info(e.getMessage());
			}
		}
		if(!StringUtil.isAnyNullOrEmpty(profile)){
			try {
				profile = new String(profile.getBytes("iso-8859-1"),"utf-8");
//				profile = java.net.URLDecoder.decode(profile, "utf-8");
			} catch (UnsupportedEncodingException e) {
				log.info(e.getMessage());
			}
		}
		String avatar = request.getParameter("avatar");

		Map<String,Object> infoMap = new HashMap<String,Object>();
		infoMap.put("username", userPhone);
		//查询个人信息by phone
		List<Subzh> resultList = userInfoDataService.userLogin(infoMap);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(resultList != null && resultList.size() > 0 ){
//			resultList.get(0).setTruename(truename);
//			resultList.get(0).setProfile(profile);
			resultList.get(0).setHeadpicture(avatar);
			int i = 0;
			try {
				i = userInfoDataService.updateUserInfoData(resultList.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//返回参数
			Map<String,Object> contentMap = new HashMap<String,Object>();
			contentMap.put("truename", truename);
			contentMap.put("profile", profile);
			contentMap.put("avatar", avatar);
			if(i > 0){
				resultMap.put("code", "0");
				resultMap.put("message", "个人设置成功");
//				resultMap.put("content", gson.toJson(contentMap));
				resultMap.put("content", contentMap);
			}else{
				resultMap.put("code", "1");
				resultMap.put("message", "个人设置失败");
			}
		}
		return resultMap;
	}
	
	/**
	 * 上传图片
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/uploadImage",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> uploadImage(HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String userPhone = request.getParameter("phone");
		String temp = String.valueOf(System.currentTimeMillis());
    	String image = request.getParameter("image");//图片内容字符串值 
    	if(StringUtil.isAllNullOrEmpty(image)){
    		resultMap.put("code", "1");
			resultMap.put("message", "图片字段为空");
			return resultMap;
    	}
    	int i = FileUtil.saveToImgByStr(image, Constant.APACHEPATH + "/", userPhone + temp + ".jpg");
    	log.info("imageName ======》"+userPhone + temp + ".jpg");
    	String http_path = Constant.APACHEPATH_HTTP+ "/"+ userPhone + temp + ".jpg";
    	if(i == 1){
    		resultMap.put("code", "0");
			resultMap.put("message", "上传图片成功");
			resultMap.put("imagePath", http_path);
    	}else{
    		resultMap.put("code", "1");
			resultMap.put("message", "上传图片失败");
    	}
		return resultMap;
	}
	
	
	
	/**
	 * 静态h5页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/pageJump")
	@ResponseBody
	public Map<String,Object> pageJump(HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String type = request.getParameter("type");
		String url = project_path+"/";
		if("1".equals(type)){//帮助
			resultMap.put("httpUrl", url+"bzzx.html");
		}else if("2".equals(type)){//协议及声明
			resultMap.put("httpUrl", url+"mzsm.html");
		}else if("3".equals(type)){//协议及声明
			resultMap.put("httpUrl", url+"yyfw.html");
		}else {//签名范例
			resultMap.put("httpUrl", url+"qmfl.html");
		}
		resultMap.put("code", "0");
		resultMap.put("message", "跳转成功");
		return resultMap;
	}
	
	/**
	 * 获取渠道经纪人
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getSubzh")
	@ResponseBody
	public Map<String,Object> getSubzh(HttpServletRequest request){
		String channel = request.getParameter("channel");
		Map<String,Object> resultMap = new HashMap<String,Object>();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("isadmin", 3);
			List<Subzh> list = userInfoDataService.userLogin(map);
			resultMap.put("channel", list);
		if(!StringUtil.isAllNullOrEmpty(channel)){
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("isadmin", 2);
			map2.put("channel", channel);
			List<Subzh> resultList = userInfoDataService.userLogin(map2);
			if(resultList != null && resultList.size() > 0){
				resultMap.put("broker", resultList);
			}
		}
		resultMap.put("code", "0");
		resultMap.put("message", "跳转成功");
		return resultMap;
	}
	
	/**
	 * 判断手机号是否重复
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/checkPhone")
	@ResponseBody
	public Map<String,Object> checkPhone(HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String userPhone = request.getParameter("username");
		Map<String,Object> regMap = new HashMap<String,Object>();
		regMap.put("username", userPhone);
		List<Subzh> list = userInfoDataService.userLogin(regMap);
		if(list == null || list.size() == 0){
			resultMap.put("code", "1");
			resultMap.put("message", "手机号不存在");
		}else{
			resultMap.put("code", "0");
			resultMap.put("message", "手机号存在");
		}
		return resultMap;
	}
	
	public boolean checkEmailCodeByEmail(String phone,String yzm){
		String code = RedisUtil.getString(phone);
		code = code.toLowerCase();
		yzm = yzm.toLowerCase();
		if(yzm.equals(code)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(10000.10);
		BigDecimal b = new BigDecimal(0);
		System.out.println(a.toString());
	}
}
