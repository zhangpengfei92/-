package com.jcl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.jcl.pojo.SinoPayRequestForm;

/**
 * 第三方支付接口
 */
public final class PayUtils {

	public static Logger log = Logger.getLogger(PayUtils.class);
	
	/**
	 * 拼接报文
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String,Object> getBody(SinoPayRequestForm merchantForm) {
		Map<String,Object> map = new HashMap<String, Object>();
		String url = "https://mobilegw.ips.com.cn/psfp-mgw/paymenth5.do";//h5
//		String url = "https://newpay.ips.com.cn/psfp-entry/gateway/payment.do";//web
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		try {
			StringBuffer sb = new StringBuffer();
	        sb.append("<body>");
	        sb.append("<MerBillNo>" + merchantForm.getMerBillNo() + "</MerBillNo>");
	        sb.append("<Lang>" + merchantForm.getLang() + "</Lang>");
	        sb.append("<Amount>" + merchantForm.getAmount() + "</Amount>");
	        sb.append("<Date>" + merchantForm.getDate() + "</Date>");
	        sb.append("<CurrencyType>" + merchantForm.getCurrencyType() + "</CurrencyType>");
	        sb.append("<GatewayType>" + merchantForm.getGatewayType() + "</GatewayType>");
	        sb.append("<Merchanturl>" + merchantForm.getMerchantUrl() + "</Merchanturl>");
	        sb.append("<FailUrl><![CDATA[" + merchantForm.getFailUrl() + "]]></FailUrl>");
	        sb.append("<Attach><![CDATA[" + merchantForm.getAttach() + "]]></Attach>");
	        sb.append("<OrderEncodeType>" + merchantForm.getOrderEncodeType() + "</OrderEncodeType>");
	        sb.append("<RetEncodeType>" + merchantForm.getRetEncodeType() + "</RetEncodeType>");
	        sb.append("<RetType>" + merchantForm.getRettype() + "</RetType>");
	        sb.append("<ServerUrl><![CDATA[" + merchantForm.getServerUrl() + "]]></ServerUrl>");
	        sb.append("<BillEXP>" + merchantForm.getBillExp() + "</BillEXP>");
	        sb.append("<GoodsName>" + merchantForm.getGoodsName() + "</GoodsName>");
	        sb.append("<IsCredit>" + merchantForm.getIsCredit() + "</IsCredit>");
	        sb.append("<BankCode>" + merchantForm.getBankcode() + "</BankCode>");
	        sb.append("<ProductType>" + merchantForm.getProductType() + "</ProductType>");
	        if (!merchantForm.getCardInfo().equals("")) {
	            String desKey = "";
	            String desIv = "";
	            sb.append("<CardInfo>" + Verify.encrypt3DES(merchantForm.getCardInfo(), desKey, desIv) + "</CardInfo>");
	        }
	        sb.append("</body>");
	        
	        // body部分
	        String bodyXml = sb.toString();
	
	        // MD5签名
	        String directStr = "0hOnCtSSOuRDA8pBQPNByvlHKXoDCGTxZTbaOFtngQ95hechJChJURaHp3DuHOHVwnd1BvPX1lDf1VeveOeH8xG4wDQY2PgjrqcmYAaBnJRjY9EZAfrDVDn3aKX5wNYD";
	        String sign = DigestUtils
	                .md5Hex(Verify.getBytes(bodyXml + merchantForm.getMerCode() + directStr,
	                        "UTF-8"));
	        // xml
	        String xml = "<Ips>" +
	                "<GateWayReq>" +
	                "<head>" +
	                "<Version>" + merchantForm.getVersion() + "</Version>" +
	                "<MerCode>" + merchantForm.getMerCode() + "</MerCode>" +
	                "<MerName>" + merchantForm.getMerName() + "</MerName>" +
	                "<Account>" + merchantForm.getMerAcccode() + "</Account>" +
	                "<MsgId>" + "msg" + date + "</MsgId >" +
	                "<ReqDate>" + date + "</ReqDate >" +
	                "<Signature>" + sign + "</Signature>" +
	                "</head>" + bodyXml +
	                "</GateWayReq>" +
	                "</Ips>";
	        log.info(">>>>> 订单支付 请求信息: " + xml);
	        map.put("action", url);
	        map.put("pGateWayReq", xml);
		} catch (Exception e) {
			log.error("支付请求失败",e);
		}
		return map;
	}

	public static void entity(){
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		SinoPayRequestForm merchantForm = new SinoPayRequestForm();
		merchantForm.setMerBillNo("DG00000001");//商户订单号 长度 30  字母和数字
		merchantForm.setGatewayType("01");//支付方式 默认01
		merchantForm.setDate(date);//订单日期 yyyyMMdd
		merchantForm.setCurrencyType("156");//币种 156人民币
        merchantForm.setAmount("0.01");//request.getParameter("Amount"));//订单金额 保留两位小数
        merchantForm.setLang("GB");//语言 GB
        merchantForm.setMerchantUrl("www.baidu.com");//支付结果成功返回的商户url
        merchantForm.setFailUrl("www.sina.com");//支付结果失败返回的商户url
        merchantForm.setAttach(null);//商户数据包 null
        merchantForm.setOrderEncodeType("5");//订单加密方式 默认 5 md5
        merchantForm.setRetEncodeType("17");//交易返回加密方式 默认 17 md5
        merchantForm.setRettype("1");//返回方式 默认 1
        merchantForm.setServerUrl("www.163.com");//返回地址
        merchantForm.setBillExp("1");//订单有效期
        merchantForm.setGoodsName("充值");//商品名称
        merchantForm.setIsCredit("0");//直连选项  1直连
        merchantForm.setBankcode("");//银行号 直连必填
        merchantForm.setProductType("");//产品类型 直连必填 1个人网银 2企业网银
        merchantForm.setUserRealName("");//姓名
        merchantForm.setUserId("");//平台用户名
        merchantForm.setCardInfo("");//持卡人信息  手机号|身份证|卡号
        merchantForm.setVersion("1.0");//版本号
        merchantForm.setMerCode("208711");//商户编号
        merchantForm.setMerName("无锡斗股");//商户名
        merchantForm.setMerAcccode("2087110017");//账户号
        
        getBody(merchantForm);
	}
	
	public static void main(String[] args) {
		entity();
	}
}
