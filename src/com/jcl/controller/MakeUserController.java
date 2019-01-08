/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @MakeUserContyroller.java
 * 功能概要  : 
 * 做成日期  : @2018年12月7日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.authdao.UserInfoMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhExample.Criteria;
import com.jcl.pojo.UserInfo;
import com.jcl.stock.simulate.Util;
import com.jcl.util.CommonFunc;
import com.jcl.util.StringUtil;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/** 
 * @author zpf
 * @version 1.0
 */

@Controller
@RequestMapping("/make")
public class MakeUserController {
	
	private static Logger log = Logger.getLogger(MakeUserController.class);
	
	@Autowired
	private SubzhMapper subzhMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@RequestMapping("/makeuser")
	@ResponseBody
	public String makeuser() {
		log.info("开始生产1000个用户");
		String str="1880000";		
		try {
		for (int i = 0; i <1000; i++) {
			//Thread.sleep(1000);
			String phone ="";
			if(i<10) {
				phone=str+"000"+i;
			}else if(i<100&&i>=10){
				phone=str+"00"+i;
			}else if(i<1000&&i>=100){
				phone=str+"0"+i;
			}else if(i==1000) {
				phone=str+i;
			}
			Subzh subzh=new Subzh();
			subzh.setSubzh(phone);			
			if(StringUtil.isAnyNullOrEmpty(subzh.getCookie())){
				byte[] data = phone.getBytes();
				long cookie = Util.Hash64(data, 0, data.length);//生成随机的cookie
				if(cookie < 0){
					subzh.setCookie(String.valueOf(Util.readUnsignedLong(cookie)));
				} else {
					subzh.setCookie(String.valueOf(cookie));
				}
			}
			subzh.setIsDelete(0);
			subzh.setIsadmin(6);
			subzh.setPhone(phone);
			subzh.setKhdate(new Date());
			subzh.setMarginset("1");
			subzh.setPagentzh("PT267200");
			subzh.setPassword("123456");
			subzh.setFeeset("1");
			subzh.setRiskset(1);
			subzh.setRisktype(1);
			subzh.setBdtd("1");
			subzh.setAllocchannel("QD100");
			subzh.setAllocpt("PT267200");
			subzh.setManage("JG267200");
			subzh.setZhstate(0);
			subzh.setAuthState(0);
			log.info("当前用户"+subzh.getSubzh());	
			int a = subzhMapper.insertSelective(subzh);
			if(a>0) {
				UserInfo userinfo=new UserInfo();
				userinfo.setUsername(phone);
				userinfo.setPassword("123456");
				userinfo.setPhone(phone);
				userInfoMapper.insertSelective(userinfo);
				log.info("已经生产了"+i+1+"个用户");	
			}
		}		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "make ---- success";	
	}
	
	@RequestMapping("/addmoney")
	@ResponseBody
	public String  addmoney() {
		log.info("开始给1000个用户加钱");
		List<Subzh> slist = subzhMapper.selectLikeSubzh("%1880000%");
		log.info("存在的用户"+slist.size());
		for (Subzh subzh : slist) {
			String str = "{\"subzh\":\""+subzh.getSubzh()+"\",\"setpro\":3,\"fundtype\":1,\"fundBalance\":0,\"nowBalance\":500000,\"feeBalance\":0.0}";
			str = Base64.encode(str.getBytes());
			//log.info("data=" + str);
			str = CommonFunc.sendPost("http://127.0.0.1:8081/ctpcms/servlet/PageFundPzlogServlet", "data="+str);
			log.info("给用户"+subzh.getSubzh()+"加钱----"+str);
		}
		return "add -------- success";		
	}
}
