package com.jcl.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.http.HttpRequest;
import com.jcl.util.Constant;

@Controller
@RequestMapping("/login")
public class LoginController {

	/*@Autowired
	private SysuserService sysuserService;*/

	// 返回登录首页
	@RequestMapping("/returnindex")
	public String returnindex() {
		return "redirect:/";

	}

	// 简单登录验证
	@RequestMapping("/Loging")
	@ResponseBody
	public String login(String username, String password, HttpSession session) {
		try {
		/*Sysuser sysuser = sysuserService.selectByName(username);
		if (sysuser != null) {*/
			/*if (sysuser.getUsername().equals(username) && sysuser.getPassword().equals(password)) {
				session.setAttribute(Constant.SESSION_ACCOUNTID, sysuser.getId());
				session.setAttribute(Constant.SESSION_LOGINNAME, sysuser.getNickname());
				*/
				 //SimpleHash simpleHash = new SimpleHash("MD5", password, username, 3);
					//UsernamePasswordToken token = new UsernamePasswordToken(username,simpleHash.toString());
					UsernamePasswordToken token = new UsernamePasswordToken(username,password);
					Subject currentUser = SecurityUtils.getSubject();
					// 使用shiro来验证
					token.setRememberMe(true);
					currentUser.login(token);// 验证角色和权限
					session.setAttribute(Constant.SESSION_LOGINNAME, username);
					//Employee admin = employeeService.selectByName(userName,deptId);
					//session.setAttribute("admin", new Admin());
				
				return "true";
			/*}else{
				return "false";
			}	*/	
		/*}else{
			return "error";
		}*/
		} catch (AuthenticationException e) {
			System.out.println(e.toString());
			//return e.toString();
			return "false";
		}
	}

	// 退出登录
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) {
		//session.setAttribute(Constant.SESSION_ACCOUNTID, null);
		//session.setAttribute(Constant.SESSION_LOGINNAME, null);
		//注销
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/";
	}

	// 校验验证码
	@RequestMapping("/validationyzm")  
	@ResponseBody
	public String validationyzm( HttpSession session,HttpServletRequest request) {
		String yzmcode = (String) session.getAttribute(Constant.SESSION_CAPTCHA);
		String yzm=request.getParameter("yzm");
		if (yzm.equalsIgnoreCase(yzmcode)) {
			return "true";
		} else {
			return "false";
		}

	}

}
