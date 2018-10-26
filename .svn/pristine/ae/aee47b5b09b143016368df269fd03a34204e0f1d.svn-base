package com.jcl.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.jcl.util.Constant;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response))
            {
                //本次用户登陆账号
                String account = this.getUsername(request);

                Subject subject = this.getSubject(request, response);
                //之前登陆的用户
             
                String username= (String) subject.getSession().getAttribute(Constant.SESSION_LOGINNAME);
                //如果两次登陆的用户不一样，则先退出之前登陆的用户
                if (account != null && username != null && !account.equals(username))
                {
                    subject.logout();
                }
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
	}

}