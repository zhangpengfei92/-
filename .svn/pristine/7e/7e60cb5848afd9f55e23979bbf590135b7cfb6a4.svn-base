package com.jcl.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.jcl.vo.Payroll;

public interface PayService {

	String paya(Payroll payroll, HttpSession session);

	String isPay(HttpServletRequest request, Model model, JSONObject allStr);

	void isCheckPaySpt(String username);

}
