package com.jcl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcl.util.Constant;



/**
 * PathFilter
 */
public class PathFilter implements Filter {
	
	/**
	 * 默认构造方法.
	 */
	public PathFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(null == req.getSession().getAttribute(Constant.SESSION_PATH)){
			String path = req.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + path;
			req.getSession().setAttribute(Constant.SESSION_PATH, path);
			req.getSession().setAttribute(Constant.SESSION_BASEPATH, basePath);
			req.getSession().setAttribute(Constant.SESSION_CSSPATH, path + "/css");
			req.getSession().setAttribute(Constant.SESSION_JSPATH, path + "/js");
			req.getSession().setAttribute(Constant.SESSION_IMAGESPATH, path + "/images");
		}
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
