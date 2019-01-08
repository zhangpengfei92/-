package com.jcl.controller;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.dao.FundPzlogMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.FundPzlogExample;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.FundPzlogExample.Criteria;
import com.jcl.service.AgentzhfundLogService;
import com.jcl.service.FundPzLogService;
import com.jcl.service.FundService;
import com.jcl.service.PhonePayService;
import com.jcl.service.SubzhService;

import com.jcl.service.impl.PhonePayServiceImpl;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.FomaAmount;
import com.jcl.util.spt.SignMd5Utils;
import com.sandepay.agentPay.DemoBaseAgentPay;
import com.sandgatePay.gateway.demo.DemoBase;
import com.sandgatePay.gateway.demo.OrderCreateDemo;
import com.sandgatePay.gateway.demo.OrderCreateDemo.PayMode;
import cn.com.sandpay.cashier.sdk.util.CertUtil;
import cn.com.sandpay.cashier.sdk.util.CryptoUtil;

@Controller
@RequestMapping("/apppay/PhonePay")
public class PhonePayController {
	private static Logger log = Logger.getLogger(PhonePayController.class);

	@Autowired
	private SubzhService subzhService;

	@Autowired
	private SubzhMapper subzhMapper;

	@Autowired
	private AgentzhfundLogMapper agentzhfundLogMapper;

	/* 提现记录信息管理service */
	@Autowired
	private FundPzLogService fundPzLogService;
	// 查资金协议的接口
	@Autowired
	private FundService fundServiceimpl;

	// 衫德支付服务接口
	@Autowired
	private PhonePayService phonePayService;

	@Autowired
	private FundPzlogMapper pzlogMapper;

	private static final Object synObj = "126";

	@Autowired
	private AgentzhfundLogService agentzhfundLogService;
	/* 获取项目工程名 */
	private static final String ProjectName = DeployProperties.getInstance().getPublicProjectePath();
	// 回调
	private String notifyUrl = ProjectName + "/apppay/PhonePay/fastPayCallback";
	private String frontUrl = ProjectName + "/apppay/PhonePay/completePay";

	private static final String uid = DeployProperties.getInstance().getUnspayMarket();
	private static final String Token = DeployProperties.getInstance().getUnspayPassword();

	/* 支付完成页面 */
	@RequestMapping("/keypay")
	public String keypay(Model model, String subzh){
		String paypage = "phonePay/keypay";
		// 判断当前用户是否已经实名认证
		Map<String, Object> map = isok2(subzh, paypage);
		if ((Boolean) map.get("status")) {// true
			log.info(map.get("msg"));
			model.addAttribute("notifyUrl", notifyUrl);
			model.addAttribute("frontUrl", frontUrl);
			model.addAttribute("subzh", subzh);
			model.addAttribute("uid", uid);
			return (String) map.get("payPage");
		} else {
			log.info(map.get("msg"));
			model.addAttribute("msg", map.get("msg"));
			return (String) map.get("payPage");
		}
	}

	/* 支付完成页面 */
	@RequestMapping("/gopay")
	@ResponseBody
	public String gopay(String notify_url, String order_id, String order_name, String price, String return_url,
			String type, String uid, String order_uid) {
		Map<String, String> sortMap = new LinkedHashMap<String, String>();
		sortMap.put("notify_url", notify_url);
		sortMap.put("order_id", order_id);
		sortMap.put("order_name", order_name);
		sortMap.put("price", price);
		sortMap.put("return_url", return_url);
		sortMap.put("token", Token);
		sortMap.put("type", type);
		sortMap.put("uid", uid);
		// 入库操作
		List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(order_id);
		if (alist != null && alist.size() > 0) {
			log.info("订单重复：" + order_id);
			return null;
		}
		AgentzhfundLog agentzhfundLog = new AgentzhfundLog();
		agentzhfundLog.setSubzh(order_uid);
		agentzhfundLog.setType("1");
		agentzhfundLog.setBz((byte) 1);
		agentzhfundLog.setDescription("充值入参" + JSON.toJSONString(sortMap));
		agentzhfundLog.setFund(new BigDecimal(price));
		agentzhfundLog.setModifytime(new Date());
		agentzhfundLog.setOrderno(order_id);
		agentzhfundLog.setStatus(0);
		int i = agentzhfundLogService.saveAgentzhFundLog(agentzhfundLog);
		log.info(order_id + "保存充值订单数据id ........true");
		if (i > 0) {
			String string = SignMd5Utils.createSign1(sortMap);
			return string;
		}
		return null;
	}

	@RequestMapping("/PhonePayIndex/{id}")
	public String PhonePayIndex(@PathVariable("id") String id, Model model, String subzh) {
		String paypage = "";
		if ("2".equals(id)) {// 2.快捷 1.网关
			/* paypage="phonePay/shandecheckpay"; */
			paypage = "/cxpay/index";
		} else if ("1".equals(id)) {
			/* paypage="phonePay/shandecheckpayWeb"; */
			paypage = "/cxpay/index";
		}
		// 判断当前用户是否已经实名认证
		Map<String, Object> map = isok(subzh, paypage);
		if ((Boolean) map.get("status")) {// true
			log.info(map.get("msg"));
			Subzh sub = (Subzh) map.get("users");
			if (sub != null) {
				// 手机号注册的用户
				/*
				 * String fixSubzh=""; if(subzh.length()==11){
				 * fixSubzh=subzh.substring(1); }else{ fixSubzh=subzh; }
				 */
				String orderno = subzh+ DateUtil.dateFormat(new Date(), "yyyyMMddHHMMSSS").substring(10);
				model.addAttribute("orderno", orderno);
				// model.addAttribute("fixSubzh", fixSubzh);
				model.addAttribute("sub", sub);
				return (String) map.get("payPage");

			}
		} else {
			log.info(map.get("msg"));
			model.addAttribute("msg", map.get("msg"));
			return (String) map.get("payPage");
		}
		return null;
	}


	/* 支付完成页面 */
	@RequestMapping("/completePay")
	public String completePay() {
		return "phonePay/sureGold";
	}

	// H5提现申请页面
	@RequestMapping("/withdrawIndex")
	public String withdrawIndex(String subzh, Model model) {

		Map<String, Object> map = isok(subzh, "phonePay/withdrawaotu");
		if ((Boolean) map.get("status")) {// true

			log.info(map.get("msg"));
			Subzh sub = (Subzh) map.get("users");
			if (null != sub && sub.getIsadmin() == 6) {
				BigDecimal fundbalance = fundServiceimpl.getfundbalance(sub);

				if (fundbalance == null || fundbalance.doubleValue() < 0) {
					log.info("账户资产不足，非法提交");
					return "phonePay/nofund";
				}
				log.info("用户可提金额 : " + fundbalance.setScale(2, BigDecimal.ROUND_DOWN));
				sub.setFundbalance(fundbalance);
			}
			if (sub.getFundbalance() == null) {
				sub.setFundbalance(new BigDecimal(0));
			} else {
				sub.setFundbalance(sub.getFundbalance().setScale(2, BigDecimal.ROUND_DOWN));
			}
			model.addAttribute("sub", sub);
			
			return (String) map.get("payPage");

		} else {
			log.info(map.get("msg"));
			model.addAttribute("msg", map.get("msg"));
			return (String) map.get("payPage");
		}
	}

	// 提现请求入库页面
	@RequestMapping("/withdrawend")
	public String withdrawend(AgentzhfundLog agentzhfundLog, Model model) {
		Map<String, Object> map = phonePayService.withdrawend(agentzhfundLog);
		if (map != null && map.size() > 0) {
			log.info(map.toString());
			if ((Boolean) map.get("status")) {
				model.addAttribute("msg", map.get("msg"));
			} else {
				model.addAttribute("msg", map.get("msg"));

			}
		} else {
			model.addAttribute("msg", "提现失败");
		}
		return "phonePay/noneed";
	}

	/**
	 * 杉德代付
	 * 
	 * @return 审核通过
	 */
	@RequestMapping(value = "/gopay", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String AgentPay(Integer qlId, Integer status) {

		Map<String, Object> map = phonePayService.AgentPay(qlId, status);
		if (map != null && map.size() > 0) {
			log.info(map.toString());
			if ((Boolean) map.get("status")) {
				return "success";
			} else {

				return (String) map.get("msg");
			}
		} else {
			return "fail";
		}
	}

	// 拒绝通过审核
	@RequestMapping("/checkWithdraw")
	@ResponseBody
	public String checkWithdraw(Integer id, Integer status) {
		Map<String, Object> map = fundServiceimpl.checkWithdraw(id, status);
		log.info("拒绝通过审核-----" + map.toString());
		if (null != map && map.get("status") == "true") {
			return "200";
		} else {
			return "400";
		}
	}

	/**
	 * 统一下单接口-银行网关支付 网关支付
	 */
	@RequestMapping("/orderPay")
	public String orderPay(HttpServletRequest req, Model model) {
		Map<String, Object> map = phonePayService.orderPay(req);
		if (map != null && map.size() > 0) {
			log.info(map.toString());
			if ((Boolean) map.get("status")) {
				model.addAttribute("JWP_ATTR", map.get("msg"));
				return "phonePay/shandesendpay";
			} else {
				model.addAttribute("msg", map.get("msg"));
				return "phonePay/noneed";
			}
		} else {
			model.addAttribute("msg", "订单异常");
			return "phonePay/noneed";
		}
	}

	/**
	 * 快捷支付
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/fastPay")
	@ResponseBody
	public String fastPay(HttpServletRequest req) {
		Map<String, Object> map = phonePayService.fastPay(req);
		if (map != null && map.size() > 0) {
			log.info(map.toString());
			if ((Boolean) map.get("status")) {
				JSONObject r = (JSONObject) map.get("msg");
				return r.toString();
			} else {

				return "fail";
			}
		} else {
			return "fail";
		}
	}

	/**
	 * keypay支付回调处理
	 * 
	 * @return
	 */
	@RequestMapping("/fastPayCallback")
	public void fastPayCallback(HttpServletRequest req) {
		log.info("进入充值回调.....................>");
		Map<String, String[]> parameterMap = req.getParameterMap();
		// 遍历map中的键
		String jsonString = JSON.toJSONString(parameterMap);
		log.info("回调返回................>" + jsonString);
		Map<String, String> sortMap = new LinkedHashMap<String, String>();
		String order_id = req.getParameter("order_id");
		String code = req.getParameter("code");
		String sign = req.getParameter("sign");
		String price = req.getParameter("price");
		sortMap.put("order_id", order_id);
		sortMap.put("price", price);
		sortMap.put("token", Token);
		String string = SignMd5Utils.createSign1(sortMap);
		if ("0000".equals(code) && string.equals(sign)) {
			List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(order_id);
			if (alist == null) {
				log.info("订单号不存在");
				return;
			}
			if (alist.size() != 1) {
				log.info("订单号重复");
				return;
			}
			AgentzhfundLog agentzhfundLog = alist.get(0);
			agentzhfundLog.setBanchname("充值回调 :" + jsonString);
			Subzh subzh = subzhMapper.selectByPrimaryKeySubzh(agentzhfundLog.getSubzh());
			if (subzh == null) {
				log.info("用户信息不存在");
				return;
			}
			if (agentzhfundLog.getStatus() == 0) {
				// 修改交易状态
				subzh.setZhstate(1);
				int count = subzhMapper.updateByPrimaryKeySelective(subzh);
				// 写资金流水表
				FundPzlog pzlog = new FundPzlog();
				pzlog.setSubzh(subzh.getSubzh());
				int key = fundPzLogService.fundInto(agentzhfundLog);
				if (key > 0) {
					log.info("资金流水入库成功!" + agentzhfundLog.getOrderno());
					subzh.setId(key);
					// 调协议给账户添加充值金额
					if (count > 0 && subzh.getZhstate() == 1) {// 状态为1，表示账户激活，激活账户才能调柜台入金协议
						//调用协议增加资金
						phonePayService.addMoney(subzh, agentzhfundLog);
					}
				}else{
					log.info("资金流水入库失败!" + agentzhfundLog.getOrderno());
				}
			} else {
				log.info(order_id + "未查到订单，或者订单已处理");
			}
		} else {
			log.info("订单号验签失败.............." + order_id);
		}
		// phonePayService.keyPayCallback(req, Token);
	}

	/**
	 * 共享在线,杉德支付回调处理
	 * 
	 * @return
	 */
	@RequestMapping("/shandePayCallback")
	public void shandePayCallback(HttpServletRequest req) {
		String data = req.getParameter("data");
		String sign = req.getParameter("sign");
		log.info("接收到后台通知数据：" + data);
		log.info("接收到后台通知签名：" + sign);
		// 验证签名
		boolean valid;
		try {
			valid = CryptoUtil.verifyDigitalSign(data.getBytes("utf-8"), Base64.decodeBase64(sign),
					CertUtil.getPublicKey(), "SHA1WithRSA");
			if (!valid) {
				log.error("verify sign fail.");
				log.error("签名字符串(data)为：" + data);
				log.error("签名值(sign)为：" + sign);
			} else {
				log.info("verify sign success");
				JSONObject dataJson = JSONObject.parseObject(data);
				if (dataJson != null) {
					/*
					 * if (dataJson.getJSONObject("head").getString("respCode").
					 * equals("000000")) { String
					 * orderNo=dataJson.getJSONObject("body").getString(
					 * "orderCode"); AgentzhfundLog findOrderNo =
					 * agentzhfundLogService.findOrderNo(orderNo);
					 * if(findOrderNo !=null &&
					 * "2".equals(findOrderNo.getType()) &&
					 * findOrderNo.getStatus()==0){ //给账户添加充值金额 subzhEntity =
					 * subzhService.getSubzhBySubid(findOrderNo.getSubzh());
					 * synchronized (synObj) { if (subzhEntity.getFundBalance()
					 * != null)
					 * subzhEntity.setFundBalance(Double.valueOf(subzhEntity.
					 * getFundBalance().doubleValue() +
					 * findOrderNo.getFund().doubleValue())); else {
					 * subzhEntity.setFundBalance(findOrderNo.getFund()); }
					 * log.info("保存资产状态：" +
					 * subzhService.saveSubzh(subzhEntity));
					 * findOrderNo.setStatus(1);
					 * findOrderNo.setModifytime(Calendar.getInstance().getTime(
					 * ));//订单时间 log.info(orderNo+"订单号修改订单状态：" +
					 * agentzhfundLogService.saveAgentzhfundLog(findOrderNo));
					 * FundPzlog pzlog = new FundPzlog();
					 * pzlog.setCreatetime(new Date());
					 * pzlog.setSubzh(findOrderNo.getSubzh());
					 * pzlog.setFundBalance(findOrderNo.getFund());
					 * pzlog.setFundtype(FundPzlog.FUNDTYPE_SIX); //充值
					 * pzlog.setSetdesc(orderNo);
					 * log.info(orderNo+"订单号增加资金充值流水：" +
					 * fundPzlogService.saveFundPzlog(pzlog)); } }else{
					 * log.info(orderNo+"未查到订单，或者订单已处理"); } }
					 */
				} else {
					log.error("通知数据异常！！！");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("接收到后台通知数据：" + data);
		log.info("接收到后台通知签名：" + sign);
		// 验证签名

		try {
			valid = CryptoUtil.verifyDigitalSign(data.getBytes("utf-8"), Base64.decodeBase64(sign),
					CertUtil.getPublicKey(), "SHA1WithRSA");
			if (!valid) {
				log.error("verify sign fail.");
				log.error("签名字符串(data)为：" + data);
				log.error("签名值(sign)为：" + sign);
			} else {
				log.info("verify sign success");
				JSONObject dataJson = JSONObject.parseObject(data);
				if (dataJson != null) {
					/*
					 * if (dataJson.getJSONObject("head").getString("respCode").
					 * equals("000000")) { String
					 * orderNo=dataJson.getJSONObject("body").getString(
					 * "orderCode"); AgentzhfundLog findOrderNo =
					 * agentzhfundLogService.findOrderNo(orderNo);
					 * if(findOrderNo !=null &&
					 * "2".equals(findOrderNo.getType()) &&
					 * findOrderNo.getStatus()==0){ //给账户添加充值金额 subzhEntity =
					 * subzhService.getSubzhBySubid(findOrderNo.getSubzh());
					 * synchronized (synObj) { if (subzhEntity.getFundBalance()
					 * != null)
					 * subzhEntity.setFundBalance(Double.valueOf(subzhEntity.
					 * getFundBalance().doubleValue() +
					 * findOrderNo.getFund().doubleValue())); else {
					 * subzhEntity.setFundBalance(findOrderNo.getFund()); }
					 * log.info("保存资产状态：" +
					 * subzhService.saveSubzh(subzhEntity));
					 * findOrderNo.setStatus(1);
					 * findOrderNo.setModifytime(Calendar.getInstance().getTime(
					 * ));//订单时间 log.info(orderNo+"订单号修改订单状态：" +
					 * agentzhfundLogService.saveAgentzhfundLog(findOrderNo));
					 * FundPzlog pzlog = new FundPzlog();
					 * pzlog.setCreatetime(new Date());
					 * pzlog.setSubzh(findOrderNo.getSubzh());
					 * pzlog.setFundBalance(findOrderNo.getFund());
					 * pzlog.setFundtype(FundPzlog.FUNDTYPE_SIX); //充值
					 * pzlog.setSetdesc(orderNo);
					 * log.info(orderNo+"订单号增加资金充值流水：" +
					 * fundPzlogService.saveFundPzlog(pzlog)); } }else{
					 * log.info(orderNo+"未查到订单，或者订单已处理"); } }
					 */
				} else {
					log.error("通知数据异常！！！");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = phonePayService.shandePayCallback(req);
	}

	// 判断该用户是否能出入金
	public Map<String, Object> isok2(String subzh, String payPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		String errorpay = "phonePay/noneed";
		Subzh sub = null;
		if (null == subzh || subzh == "") {
			log.info("用户名不存在");
			map.put("msg", "用户名不存在");
			map.put("status", false);
			map.put("payPage", "phonePay/nogold");
			return map;
		}
		try {
			sub = subzhService.loginBySubzh(subzh);
			// 判断用户信息是否存在
			if (null == sub) {
				log.info("用户信息不存在");
				map.put("msg", "用户信息不存在");
				map.put("status", false);
				map.put("payPage", "phonePay/nogold");
				log.info("map  :-----------" + map.toString());
				return map;
			}
			// 当用户操作充值（网关或者银联）判读用户是否是普通用户
			Boolean flag = true;
			Integer isadmin = 0;
			if (payPage == "phonePay/shandecheckpay" || payPage == "phonePay/shandecheckpayWeb") {
				isadmin = sub.getIsadmin();
				if (null != isadmin && isadmin != 0 && isadmin != 6) {
					log.info("非普通用户无法充值");
					map.put("msg", "非普通用户无法充值");
					map.put("status", false);
					map.put("payPage", errorpay);
					return map;
				}
			}
			// 当用户操作的是提现，判读用户是否是普通用户
			if (payPage == "phonePay/withdrawaotu") {
				isadmin = sub.getIsadmin();
				if (null != isadmin && isadmin != 0 && isadmin != 6) {// 如果用户不是普通用户，则无需实名认证
					flag = false;
				}
			}


			if (flag) {// 当用户操作提现且不是普通用户时，不必进行是否实名认证的判断
				// 判断用户是否实名认证
				if (sub.getAuthState() != null && sub.getAuthState() != 2) {
					String msg = "";
					Integer state = sub.getAuthState();
					msg = state == 0 ? "用户未实名认证" : state == 1 ? "用户实名认证审核中" : "用户实名认证未通过";
					map.put("msg", msg);
					map.put("status", false);
					map.put("payPage", errorpay);
					return map;
				}
			}
			map.put("msg", "用户已实名认证");
			map.put("status", true);
			map.put("users", sub);
			map.put("payPage", payPage);
		} catch (Exception e) {
			log.error("查询用户异常");
		}

		return map;
	}
	// 查询用户实时资金
	@RequestMapping("/querysubzhfund")
	public String querysubzhfund(String subzh, Model model) {
		log.info("查询用户" + subzh + "的实时可用资金");
		try {
			Subzh sub = subzhService.selectByPrimaryKey(subzh);

			if (sub != null) {
				BigDecimal fundbalance = fundServiceimpl.getfundbalance(sub);
				if (fundbalance == null || fundbalance.doubleValue() < 0) {
					sub.setFundbalance(new BigDecimal(0));
				} else {
					sub.setFundbalance(sub.getFundbalance().setScale(2, BigDecimal.ROUND_DOWN));
				}
				log.info(subzh + "的实时可用资金为 ：" + fundbalance);
				model.addAttribute("sub", sub);
			}
		} catch (Exception e) {
			log.error("查询用户实时资金异常", e);
		}
		return "fund/subfund";
	}
  	
	
	// 查询用户实时资金
	@RequestMapping("/pagequeryfund")
	public Subzh pagequeryfund(String subzh) {
		log.info("查询用户" + subzh + "的实时可用资金");
		try {
			Subzh sub = subzhService.selectByPrimaryKey(subzh);

			if (sub != null) {
				BigDecimal fundbalance = fundServiceimpl.getfundbalance(sub);
				if (fundbalance == null || fundbalance.doubleValue() < 0) {
					if(sub.getIsadmin()==6){
						sub.setFundbalance(new BigDecimal(0));
					}
				} else {
					sub.setFundbalance(sub.getFundbalance().setScale(2, BigDecimal.ROUND_DOWN));
				}
				log.info(subzh + "的实时可用资金为 ：" + fundbalance);
				return sub;
			}
		} catch (Exception e) {
			log.error("查询用户实时资金异常", e);
		}
		return null;
	}
  	

	// 判断该用户是否能出入金
	public Map<String, Object> isok(String subzh, String payPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		String errorpay = "phonePay/noneed";
		Subzh sub = null;
		if (null == subzh || subzh == "") {
			log.info("用户名不存在");
			map.put("msg", "用户名不存在");
			map.put("status", false);
			map.put("payPage", "");
			return map;
		}
		try {
			sub = subzhService.loginBySubzh(subzh);
			// 判断用户信息是否存在
			if (null == sub) {
				log.info("用户信息不存在");
				map.put("msg", "用户信息不存在");
				map.put("status", false);
				map.put("payPage", errorpay);
				log.info("map  :-----------" + map.toString());
				return map;
			}
			// 当用户操作充值（网关或者银联）判读用户是否是普通用户
			Boolean flag = true;

			Integer isadmin = 0;
			if (payPage == "phonePay/isclose" || payPage == "phonePay/isclose") {
				isadmin = sub.getIsadmin();
				if (null != isadmin && isadmin != 0 && isadmin != 6) {
					log.info("非普通用户无法充值");
					map.put("msg", "非普通用户无法充值");
					map.put("status", false);
					map.put("payPage", errorpay);
					return map;
				}
			}

			// 当用户操作的是提现，判读用户是否是普通用户
			if (payPage == "phonePay/withdrawaotu") {
				isadmin = sub.getIsadmin();
				if (null != isadmin && isadmin != 0 && isadmin != 6) {// 如果用户不是普通用户，则无需实名认证
					flag = false;
				}
			}

			if (flag) {// 当用户操作提现且不是普通用户时，不必进行是否实名认证的判断
				// 判断用户是否实名认证
				if (sub.getAuthState() != null && sub.getAuthState() != 2) {
					String msg = "";
					Integer state = sub.getAuthState();
					msg = state == 0 ? "用户未实名认证" : state == 1 ? "用户实名认证审核中" : "用户实名认证未通过";
					map.put("msg", msg);
					map.put("status", false);
					map.put("payPage", errorpay);
					return map;
				}
			}
			map.put("msg", "用户已实名认证");
			map.put("status", true);
			map.put("users", sub);
			map.put("payPage", payPage);

		} catch (Exception e) {
			log.error("查询用户异常");
		}

		return map;
	}	
}