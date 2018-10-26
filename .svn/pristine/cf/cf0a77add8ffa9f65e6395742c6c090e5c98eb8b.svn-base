package com.jcl.filter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.jcl.pojo.PreMenu;
import com.jcl.pojo.Subzh;
import com.jcl.service.SubzhService;
import com.jcl.service.SysuserService;
import com.jcl.util.Constant;

public class loginShiroRealam extends AuthorizingRealm {
	
	public static Logger log = Logger.getLogger(loginShiroRealam.class);

	@Resource
	private SysuserService sysuserService;
	
	@Resource
	private SubzhService subzhServiceImpl;
	/**
	 * 授权 分配角色
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) super.getAvailablePrincipal(principals);
		List<PreMenu> plist= subzhServiceImpl.selectByRoleAndPer(username);
		Set<String> roleNames = new HashSet<String>();
		for (PreMenu premenu : plist) {
				if(premenu.getPreId()!=null){
					roleNames.add(String.valueOf(premenu.getPreId()));
				}
				roleNames.add(premenu.getMenuCode());
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		return info;
	}

	/**
	 * 登入验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String userName = token.getUsername();
		Subzh subzh= subzhServiceImpl.loginBySubzh(userName);
		if (subzh!=null) {
				Integer isadmin=subzh.getIsadmin();
				if(null != isadmin){
					if(subzh.getIsadmin() ==6){//1机构，2平台，3渠道，4代理商，5经纪人，6普通用户
						throw new LockedAccountException("普通用户不能登录");
					}
				}else{
					throw new LockedAccountException("此用户isadmin属性有问题，需要联系管理员");
				}
				if(subzh.getIsDelete()!=null && 1==subzh.getIsDelete()){
					throw new LockedAccountException("此用户已经被删除不能登录");
				}
				SimpleAuthenticationInfo sainfo = new SimpleAuthenticationInfo(
				subzh.getSubzh(),subzh.getPassword(), getName());
				this.setSession(Constant.SESSION_ACCOUNTID, subzh.getSubzh());
				this.setSession(Constant.SESSION_LOGINNAME,subzh.getLoginname());
				if(isadmin==1){//设置登录用户的所属机构
					this.setSession(Constant.SESSION_AGENTZHGL, subzh.getSubzh());
					Subzh s=new Subzh();
					s.setIsadmin(2);
					s.setManage(subzh.getSubzh());
					List<Subzh> mrpt=subzhServiceImpl.getSubzhLevelList(s);
					if(mrpt!=null && mrpt.size()>0){//如果是机构登录，就设置一个默认平台
						this.setSession(Constant.SESSION_PLATEFORM, mrpt.get(mrpt.size()-1).getSubzh());
					}
				}else{
					this.setSession(Constant.SESSION_AGENTZHGL, subzh.getManage());
					if(isadmin==2){
						this.setSession(Constant.SESSION_PLATEFORM, subzh.getSubzh());
					}else{
						this.setSession(Constant.SESSION_PLATEFORM, subzh.getAllocpt());
					}
				}
				this.setSession(Constant.SESSION_ISADMIN, isadmin);
				return sainfo;

		} else {
			throw new AuthenticationException("账号或密码错误");
		}

	}

	private void setSession(Object key, Object value) {
		Session session = getSession();
		log.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
		if (null != session) {
			session.setAttribute(key, value);
		}
	}

	private Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (InvalidSessionException e) {

		}
		return null;
	}
}
