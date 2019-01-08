package com.synPay;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import com.alibaba.fastjson.JSON;
import com.client.config.BryConfig;
import com.client.utils.SignUtils;
import com.payment.common.utils.DateUtil;
import com.payment.msg.gateway.GateWayPayRequest;

import sun.misc.BASE64Encoder;

public class TestPayment extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String txSN = request.getParameter("txSN");
		String tranAmt = request.getParameter("tranAmt");
		String accountType = request.getParameter("accountType");
		String prodInfo = request.getParameter("prodInfo");
		String usage = request.getParameter("usage");
		String returnURL = request.getParameter("returnURL");
		String notificationURL = request.getParameter("notificationURL");
		GateWayPayRequest gateWayPayRequest = new GateWayPayRequest();
		gateWayPayRequest.setTxSN(txSN);
		gateWayPayRequest.setTranAmt(Long.parseLong(tranAmt));
		gateWayPayRequest.setAccountType(accountType);
		gateWayPayRequest.setProdInfo(prodInfo);
		gateWayPayRequest.setReturnURL(returnURL);
		gateWayPayRequest.setNotificationURL(notificationURL);
		gateWayPayRequest.setUsage(usage);
		gateWayPayRequest.setTxCode("10012");
		gateWayPayRequest.setMerchantNo(BryConfig.merchantNo);
		gateWayPayRequest.setTransDate(DateUtil.getStandardDate("yyyy-MM-dd HH:mm:ss", new Date()));
		gateWayPayRequest.setVersion("1.0");
		gateWayPayRequest.setLsh(RandomStringUtils.randomNumeric(17));
		String sign = "";
		try {
			sign = SignUtils.createSignData(gateWayPayRequest, BryConfig.MER_PRK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("txCode", gateWayPayRequest.getTxCode());
		reqMap.put("signature", sign);
		reqMap.put("version", gateWayPayRequest.getVersion());
		reqMap.put("message", new BASE64Encoder().encode(JSON.toJSONString(gateWayPayRequest).getBytes("UTF-8")));
		reqMap.put("merchantId", BryConfig.merchantNo);
		StringBuffer formHtml = new StringBuffer();
		formHtml.append("<form name='form' method='post' action='"
				+ BryConfig.HTTPS_AYN_URL
				+ "'>");
		for (Map.Entry<String, String> entry : reqMap.entrySet()) {
			formHtml.append("<input type='hidden' name='" + entry.getKey() + "' value='" + entry.getValue() + "'/>");
		}
		formHtml.append("</form>");
		formHtml.append("<script type='text/javascript'>");
		formHtml.append(" form.submit();");
		formHtml.append("</script>");
		request.setAttribute("submitForm", formHtml);
		request.getRequestDispatcher("/request.jsp").forward(request, response);
	}

}
