/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @PhonePayServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年10月17日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.dao.FundPzlogMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.FundPzlogExample;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.FundPzlogExample.Criteria;
import com.jcl.service.PhonePayService;
import com.jcl.service.SubzhService;
import com.jcl.stock.entity.CONST;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.FomaAmount;
import com.jcl.util.StringUtil;
import com.jcl.util.spt.SignMd5Utils;
import com.sandepay.agentPay.DemoBaseAgentPay;
import com.sandgatePay.gateway.demo.DemoBase;
import com.sandgatePay.gateway.demo.OrderCreateDemo;
import com.sandgatePay.gateway.demo.OrderCreateDemo.PayMode;

import cn.com.sandpay.cashier.sdk.util.CertUtil;
import cn.com.sandpay.cashier.sdk.util.CryptoUtil;

/**
 * @author zpf
 * @version 1.0
 * 
 *          衫德支付的实现
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PhonePayServiceImpl implements PhonePayService {

	public static Logger log = Logger.getLogger(FundServiceImpl.class);

	private static final Object synObj = "126";

	/* 获取项目工程名 */
	private static final String ProjectName = DeployProperties.getInstance().getPublicProjectePath();
	// 回调
	private String notifyUrl = "/apppay/PhonePay/shandePayCallback";
	private String frontUrl = "/apppay/PhonePay/completePay";

	@Autowired
	public SubzhMapper subzhMapper;

	@Autowired
	public AgentzhfundLogMapper agentzhfundLogMapper;

	@Autowired
	public FundPzlogMapper pzlogMapper;

	@Autowired
	public SimulateStockService simulateStockService;

	// 网关接口
	@Override
	public Map<String, Object> orderPay(HttpServletRequest req) {
		Map<String, Object> resmap = new HashMap<String, Object>();

		Map<String, String[]> params = req.getParameterMap();
		JSONObject reqObj = new JSONObject();
		Map<String, String> map = new HashMap<String, String>();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			if (values.length > 0) {
				reqObj.put(key, values[0]);
				map.put(key, values[0]);
			}
		}
		OrderCreateDemo demo = new OrderCreateDemo();
		String reqAddr = "/order/pay"; // 接口报文规范中获取
		// 设置报文头
		demo.setHeader(PayMode.bank_pc);
		demo.body.put("orderCode", map.get("orderCode"));
		// 商户订单号
		String totalAmount = map.get("totalAmount");
		DecimalFormat df = new DecimalFormat("#");
		BigDecimal bigDecimal = new BigDecimal(totalAmount).multiply(new BigDecimal(100));
		String format = df.format(bigDecimal);
		demo.body.put("totalAmount", FomaAmount.getFomaAmount(format)); // 订单金额
		demo.body.put("subject", "shoping"); // 订单标题
		demo.body.put("body", "用户"); // 订单描述
		if (map.get("txnTimeOut") == null || map.get("txnTimeOut") == "") {
			demo.body.put("txnTimeOut", DemoBase.getNextDayTime()); // 订单超时时间
		} else {
			demo.body.put("txnTimeOut", map.get("txnTimeOut")); // 订单超时时间
		}
		// 银行编号
		String bankcode = map.get("bankcode");
		demo.body.put("payMode", "bank_pc");//支付模式
		JSONObject payExtra = new JSONObject();
		payExtra.put("payType", "1");
		payExtra.put("bankCode", bankcode); // 银行卡编号
		demo.body.put("payExtra", payExtra); // 支付扩展域
		demo.body.put("clientIp", "127.0.0.1"); // 客户端IP
		demo.body.put("notifyUrl", ProjectName + notifyUrl); // 异步通知地址
		demo.body.put("frontUrl", ProjectName + frontUrl); // 前台通知地址
		demo.body.put("storeId", ""); // 商户门店编号
		demo.body.put("terminalId", ""); // 商户终端编号
		demo.body.put("operatorId", ""); // 操作员编号
		demo.body.put("clearCycle", ""); // 清算模式
		demo.body.put("royaltyInfo", ""); // 分账信息
		demo.body.put("riskRateInfo", ""); // 风控信息域
		demo.body.put("bizExtendParams", ""); // 业务扩展参数
		demo.body.put("merchExtendParams", ""); // 商户扩展参数
		demo.body.put("extend", ""); // 扩展域
		JSONObject orderCreateResp = DemoBase.requestServer(demo.header, demo.body, reqAddr);
		if (orderCreateResp.getJSONObject("head").getString("respCode").equals("000000")) {
			// 保存充值信息
			try {
				// 取订单号
				String orderno = map.get("orderCode");

				if (StringUtil.isAllNullOrEmpty(orderno)) {
					log.info("订单号为空");
					resmap.put("status", false);
					resmap.put("msg", "订单号为空");
					return resmap;
				}
				// 取用户名
				String subzh = orderno.split("_")[0];
				// 判断订单是否重复
				List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(map.get("orderCode"));
				if (alist != null && alist.size() > 0) {
					log.info("订单重复：" + map.get("orderCode"));
					resmap.put("status", false);
					resmap.put("msg", "订单重复：" + map.get("orderCode"));
					return resmap;
				}

				Subzh subzhEntity = subzhMapper.selectByPrimaryKeySubzh(subzh);
				if (subzhEntity == null) {
					log.info("用户信息不存在");
					resmap.put("status", false);
					resmap.put("msg", "用户信息不存在");
					return resmap;
				}
				BigDecimal fund = new BigDecimal(0);
				if (map.get("totalAmount") != null || map.get("totalAmount") != "") {
					fund = new BigDecimal(map.get("totalAmount"));
				}
				
				
				
				AgentzhfundLog agentzhfundLog = new AgentzhfundLog();
				agentzhfundLog.setSubzh(subzh);
				agentzhfundLog.setType("1");
				agentzhfundLog.setBz((byte) 1);
				agentzhfundLog.setFund(new BigDecimal(map.get("totalAmount")));
				agentzhfundLog.setModifytime(new Date());
				agentzhfundLog.setOrderno(map.get("orderCode")); //订单号
				agentzhfundLog.setDescription("在线充值报文:" + demo.body+demo.header); 
				agentzhfundLog.setStatus(0);
				int i = agentzhfundLogMapper.insertSelective(agentzhfundLog);
				if (i > 0) {
					log.info(map.get("orderCode") + "保存充值订单数据入库成功" );
					String credential = orderCreateResp.getJSONObject("body").getString("credential");
					log.info("生成的支付凭证为：" + credential);
					resmap.put("status", true);
					resmap.put("msg", credential);
					return resmap;
				}
			} catch (Exception e) {
				log.error("网关入金异常", e);
			}
		}
		return resmap;
	}

	// 快捷接口
	@Override
	public Map<String, Object> fastPay(HttpServletRequest req) {
		Map<String, Object> resmap = new HashMap<String, Object>();

		Map<String, String[]> params = req.getParameterMap();
		Map<String, String> map = new HashMap<String, String>();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			if (values.length > 0) {
				map.put(key, values[0]);
			}
		}
		// 组后台报文
		JSONObject head = new JSONObject();
		head.put("version", map.get("version"));
		head.put("method", map.get("method"));
		head.put("productId", map.get("productId"));
		head.put("accessType", map.get("accessType"));
		head.put("mid", map.get("mid"));
		head.put("plMid", map.get("plMid"));
		head.put("channelType", map.get("channelType"));
		head.put("reqTime", map.get("reqTime"));

		JSONObject body = new JSONObject();
		body.put("userId", map.get("userId"));
		body.put("clearCycle", map.get("clearCycle"));
		body.put("currencyCode", map.get("currencyCode"));
		body.put("frontUrl", ProjectName + frontUrl);
		body.put("notifyUrl", ProjectName + notifyUrl);
		body.put("orderCode", map.get("orderCode"));
		body.put("orderTime", map.get("orderTime"));
		String totalAmount = map.get("totalAmount");
		DecimalFormat df = new DecimalFormat("#");
		BigDecimal bigDecimal = new BigDecimal(totalAmount).multiply(new BigDecimal(100));
		body.put("totalAmount", FomaAmount.getFomaAmount(df.format(bigDecimal)));
		body.put("body", map.get("body"));
		body.put("subject", map.get("subject"));
		body.put("extend", map.get("extend"));

		JSONObject data = new JSONObject();
		data.put("head", head);
		data.put("body", body);
		// 保存充值信息
		try {
			// 取订单号
			String orderno = map.get("orderCode");

			if (StringUtil.isAllNullOrEmpty(orderno)) {
				log.info("订单号为空");
				resmap.put("status", false);
				resmap.put("msg", "订单号为空");
				return resmap;
			}
			// 取用户名
			String subzh = orderno.split("_")[0];
			// 判断订单是否重复
			List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(map.get("orderCode"));
			if (alist != null && alist.size() > 0) {
				log.info("订单重复：" + map.get("orderCode"));
				resmap.put("status", false);
				resmap.put("msg", "订单重复：" + map.get("orderCode"));
				return resmap;
			}

			Subzh subzhEntity = subzhMapper.selectByPrimaryKeySubzh(subzh);
			if (subzhEntity == null) {
				log.info("用户信息不存在");
				resmap.put("status", false);
				resmap.put("msg", "用户信息不存在");
				return resmap;
			}
			BigDecimal fund = new BigDecimal(0);
			if (map.get("totalAmount") != null || map.get("totalAmount") != "") {
				fund = new BigDecimal(map.get("totalAmount"));
			}
			AgentzhfundLog agentzhfundLog = new AgentzhfundLog();
			agentzhfundLog.setSubzh(subzh);
			agentzhfundLog.setType("1");
			agentzhfundLog.setBz((byte) 1);
			agentzhfundLog.setFund(new BigDecimal(map.get("totalAmount")));
			agentzhfundLog.setModifytime(new Date());
			agentzhfundLog.setOrderno(map.get("orderCode")); //订单号
			agentzhfundLog.setDescription("在线充值报文:" + body+head); 
			agentzhfundLog.setStatus(0);
			int i = agentzhfundLogMapper.insertSelective(agentzhfundLog);
			if (i > 0) {
				String reqSign = URLEncoder.encode(
						new String(Base64.encodeBase64(CryptoUtil.digitalSign(JSON.toJSONString(data).getBytes("UTF-8"),
								CertUtil.getPrivateKey(), "SHA1WithRSA"))),
						"UTF-8");
				JSONObject r = new JSONObject();
				r.put("data", JSON.toJSONString(data));
				r.put("sign", reqSign);// 签名串
				resmap.put("status", true);
				resmap.put("msg", r);
				log.info("衫德快捷支付输入参数 ：" + JSON.toJSONString(data) + "--签名串  ：" + reqSign);
				return resmap;
			}
		} catch (Exception e) {
			log.error("快捷入金入金异常", e);
		}
		return resmap;
	}

	// 充值回调接口
	@Override
	public Map<String, Object> shandePayCallback(HttpServletRequest req) {
		Map<String, Object> resmap = new HashMap<String, Object>();
		log.info("充值回调开始");
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
					if (dataJson.getJSONObject("head").getString("respCode").equals("000000")) {
						String orderNo = dataJson.getJSONObject("body").getString("orderCode");
						List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(orderNo);
						if (alist == null) {
							log.info("订单号不存在");
							resmap.put("status", false);
							resmap.put("msg", "订单号" + orderNo + "不存在");
							return resmap;
						}
						if (alist.size() != 1) {
							log.info("订单号重复");
							resmap.put("status", false);
							resmap.put("msg", "订单号" + orderNo + "重复");
							return resmap;
						}
						AgentzhfundLog agentzhfundLog = alist.get(0);
						Subzh subzh = subzhMapper.selectByPrimaryKeySubzh(agentzhfundLog.getSubzh());
						if (subzh == null) {
							log.info("用户信息不存在");
							resmap.put("status", false);
							resmap.put("msg", "用户" + agentzhfundLog.getSubzh() + "信息不存在");
							return resmap;
						}
						List<FundPzlog> sfplist = getFundPzlogList(subzh);
						if (agentzhfundLog != null && agentzhfundLog.getStatus() == 0) {
							// 调协议给账户添加充值金额
							subzh.setZhstate(1);
							int count = subzhMapper.updateByPrimaryKeySelective(subzh);
							if (count > 0 && subzh.getZhstate() == 1) {// 状态为1，表示账户激活，激活账户才能调柜台入金协议
								Map<String, Object> amap = addMoney(subzh, agentzhfundLog);
								if (null != amap && amap.size() > 0) {
									if (null != amap.get("status") && (Boolean) amap.get("status")) {
										agentzhfundLog.setStatus(1);// 修改状态为1
																	// --表示充值成功
										resmap.put("status", true);
										resmap.put("msg", "充值成功");
										FundPzlog fundPzlog = saveFundpzlog(agentzhfundLog.getSubzh(),
												agentzhfundLog.getFund(), agentzhfundLog.getOrderno(),
												DateUtil.getSystemDate(), 6);
									} else {
										agentzhfundLog.setStatus(2);// 修改状态为2
																	// --表示充值失败
										resmap.put("status", false);
										resmap.put("msg", "充值失败");

										if ((sfplist == null) && (sfplist.size() <= 1)) {
											subzh.setZhstate(Integer.valueOf(0));
										}
									}
								} else {
									agentzhfundLog.setStatus(2);// 修改状态为2
																// --表示充值失败
									resmap.put("status", false);
									resmap.put("msg", "充值失败");
									if ((sfplist == null) && (sfplist.size() <= 1)) {
										subzh.setZhstate(Integer.valueOf(0));
									}
								}

								log.info("修改用户激活状态" + subzhMapper.updateByPrimaryKeySelective(subzh));
							}
						} else {
							log.info(orderNo + "未查到订单，或者订单已处理");
						}
						agentzhfundLog.setBanchname("data :" + data + ";sign" + sign);
						log.info("修改agentzhfundLog状态"
								+ agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog));
					}
				} else {
					log.error("通知数据异常！！！");
				}
			}

		} catch (Exception e) {
			log.error("提现申请异常", e);
		}
		return resmap;
	}

	// 审核通过接口
	@Override
	public Map<String, Object> AgentPay(Integer qlId, Integer status) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			synchronized (synObj) {
				AgentzhfundLog agentzhfundLog = null;
				if (null == qlId && qlId == 0) {
					map.put("msg", "提现信息不存在：" + qlId);
					map.put("status", false);
					return map;
				}

				agentzhfundLog = agentzhfundLogMapper.selectByPrimaryKey(qlId);

				if (agentzhfundLog == null) {
					map.put("msg", "提现订单不存在" + qlId);
					map.put("status", false);
					return map;
				}

				if (agentzhfundLog.getStatus() == 4) {
					if (status != 5) {
						map.put("status", false);
						map.put("msg", "审核未通过 ：" + status);
						return map;
					}
				} else {
					map.put("status", false);
					map.put("msg", "提现信息未提交");
					return map;
				}
				// 将数据库保存的对应提现分别set到对应的实体类字段
				String description = agentzhfundLog.getDescription();
				JSONObject jsonobj = JSONObject.parseObject(description);
				agentzhfundLog.setAmount(jsonobj.getString("amount"));
				agentzhfundLog.setBankCardNumber(jsonobj.getString("bankCardNumber"));
				agentzhfundLog.setPhoneNum(jsonobj.getString("phoneNum"));
				agentzhfundLog.setIdcard(jsonobj.getString("idcard"));
				agentzhfundLog.setBankcode(jsonobj.getString("bankcode"));
				// status状态 4提现申请 5：审核通过 6审核拒绝 7提现成功 8提现失败
				if (agentzhfundLog != null && status == 5 && agentzhfundLog.getStatus() == 4) {
					// 代付
					JSONObject request = new JSONObject();
					request.put("version", DemoBaseAgentPay.version); // 版本号
					request.put("productId", DemoBaseAgentPay.PRODUCTID_AGENTPAY_TOC); // 产品ID
					request.put("tranTime", DemoBaseAgentPay.getCurrentTime()); // 交易时间
					request.put("orderCode", agentzhfundLog.getOrderno()); // 订单号
					request.put("timeOut", DemoBaseAgentPay.getNextDayTime()); // 订单超时时间
					DecimalFormat df = new DecimalFormat("#");
					BigDecimal subtract = agentzhfundLog.getFund().multiply(new BigDecimal(100));
					request.put("tranAmt", FomaAmount.getFomaAmount(FomaAmount.getFomaAmount(df.format(subtract)))); // 金额
					request.put("currencyCode", DemoBaseAgentPay.CURRENCY_CODE); // 币种
					request.put("accAttr", "0"); // 账户属性 0-对私 1-对公
					request.put("accType", "4"); // 账号类型 3-公司账户 4-银行卡
					request.put("accNo", agentzhfundLog.getBankCardNumber()); // 收款人账户号
					request.put("accName", agentzhfundLog.getName()); // 收款人账户名
					request.put("provNo", ""); // 收款人开户省份编码
					request.put("cityNo", ""); // 收款人开会城市编码
					request.put("bankName", ""); // 收款账户开户行名称
					request.put("bankType", "123456123456"); // 收款人账户联行号
					request.put("remark", "代付"); // 摘要
					request.put("channelType", ""); // 渠道类型
					request.put("reqReserved", ""); // 请求方保留域
					request.put("extend", "");
					String reqAddr = "/agentpay"; // 接口报文规范中获取
					JSONObject resp = DemoBaseAgentPay.requestServer(request, reqAddr, DemoBaseAgentPay.AGENT_PAY,
							"16468578", null);
					log.info("订单号" + agentzhfundLog.getOrderno() + "体现响应报文" + resp);
					Subzh subzhEntity = subzhMapper.selectByPrimaryKeySubzh(agentzhfundLog.getSubzh());
					if (resp != null) {
						// 成功
						if ("0000".equals(resp.getString("respCode"))) {
							// 修改操作状态成功
							agentzhfundLog.setStatus(7);
							map.put("status", true);
							map.put("msg", resp.getString("respDesc"));
							saveFundpzlog(agentzhfundLog.getSubzh(), agentzhfundLog.getFund(),
									agentzhfundLog.getOrderno(), DateUtil.getSystemDate(), 7);
						} else if ("0001".equals(resp.getString("respCode"))
								|| "0002".equals(resp.getString("respCode"))) {
							// 0001 银行处理中 0002 银行返回超时 重新查询订单状态
							map.put("status", true);
							map.put("msg", resp.getString("respDesc"));
							agentzhfundLog.setStatus(5);
						} else if ("0003".equals(resp.getString("respCode"))
								|| "0004".equals(resp.getString("respCode"))) {
							// 处理异常,稍后再试
							map.put("status", false);
							map.put("msg", resp.getString("respDesc"));
						} else {
							// 处理失败,退还钱
							agentzhfundLog.setStatus(8);
							map.put("status", false);
							map.put("msg", resp.getString("respDesc"));

							if (subzhEntity != null && subzhEntity.getIsadmin() == 6) {
								if (null != agentzhfundLog.getStatus() && agentzhfundLog.getStatus() == 8) {
									// 调柜台协议，把钱加到柜台账户
									log.info("调柜台协议将用户的提现失败的金额反回给客户");
									Map<String, Object> amap = addMoney(subzhEntity, agentzhfundLog);
									if (null != amap && amap.size() > 0) {
										if (null != amap.get("status") && (Boolean) amap.get("status")) {
											log.info("将提现失败金额返还给客户成功");
										} else {
											log.info("将提现失败金额返还给客户失败");
										}
									} else {
										log.info("将提现失败金额返还给客户失败");
									}
								}
								BigDecimal balance = subzhEntity.getFundbalance().add(agentzhfundLog.getFund());// 失败，则将提现的钱返还给账户
								subzhEntity.setFundbalance(balance);
							} else if (subzhEntity != null && subzhEntity.getIsadmin() != 6) {
								BigDecimal balance = subzhEntity.getFundbalance().add(agentzhfundLog.getFund());// 失败，则将提现的钱返还给账户
								subzhEntity.setFundbalance(balance);
							}
							log.info("提现失败账户金额增加：" + subzhMapper.updateByPrimaryKey(subzhEntity));
						}
						String flage = resp.getString("respDesc");
						log.info("flage----" + flage);
						log.info("resp.toString()----" + resp.toString() + "resp.length" + resp.toString().length());
						agentzhfundLog.setBanchname("账户" + subzhEntity.getSubzh() + "提现相应报文:" + resp.toString());
						;
						agentzhfundLog.setModifytime(new Date());
						log.info("更改提现流水表状态：" + agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog));
					} else {
						log.error("服务器请求异常！！！");
					}
				}

			}
		} catch (Exception e) {
			log.error("提现异常", e);
		}
		return map;
	}

	// 提现申请接口
	@Override
	public Map<String, Object> withdrawend(AgentzhfundLog agentzhfundLog) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 根据传过来subzh去查询用户信息
		Subzh sub = subzhMapper.selectBySubzh(agentzhfundLog.getSubzh());
		List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(agentzhfundLog.getOrderno());
		if (alist != null && alist.size() == 1) {
			log.info("订单号重复");
			map.put("status", false);
			map.put("msg", "订单号重复，请稍后重新提交");
			return map;
		}


		BigDecimal fund = new BigDecimal(0);
		if (agentzhfundLog.getFund()!=null) {
			fund = agentzhfundLog.getFund();
		}

		agentzhfundLog.setFund(fund);
		// 判断用户信息是否存在
		if (null == sub) {
			log.info("sub==null:用户信息为null");
			map.put("status", false);
			map.put("msg", "用户信息不存在");
			return map;
		}

		// 判断用户的账户资金是否大于提现金额
		if (sub.getFundbalance() == null
			||sub.getFundbalance().doubleValue() - Double.valueOf(agentzhfundLog.getAmount()) < 0) {
			log.info("result1:余额不足");
			map.put("status", false);
			map.put("msg", "余额不足");
			return map;
		}
		log.info("getSubzh:==》" + sub.getSubzh());
		sub.setFundbalance(sub.getFundbalance().subtract(fund));
		int num = subzhMapper.updateByPrimaryKeySelective(sub);
		if (num > 0) {
			log.info("提现减去账户" + sub.getSubzh() + "的钱  ：  " + fund);
			agentzhfundLog = saveAgentzhfundLog(agentzhfundLog, agentzhfundLog.getSubzh(), agentzhfundLog.getOrderno(), DateUtil.getSystemDate(), fund, 0, 2);
			// 调柜台协议
			map.put("status", true);
			map.put("msg", "提现申请提交成功");
			if (null != sub.getIsadmin() && sub.getIsadmin() == 6) {	
				final String subzh=sub.getSubzh();
				final BigDecimal fundbalance=agentzhfundLog.getFund();
				final Integer aflId=agentzhfundLog.getId();
				if(agentzhfundLog.getId()!=null) {
					new Thread(){
						@Override
						public void run(){							
							this.getId();
							try {
								Map<String, Object> gmap = getMoney(subzh, fundbalance, aflId);	
								log.info("调柜台出金协议结果"+gmap);							
							} catch (Exception e) {
								log.error("创建一条调柜台出金协议的线程失败",e);
							}						
						}								
					}.start();
				}
				/*if (null != gmap && gmap.size() > 0) {
					if (null != gmap.get("status") && (Boolean) gmap.get("status")) {
						map.put("status", true);
						map.put("msg", "提现申请提交成功");
					} else {
						map.put("status", false);
						map.put("msg", "提现申请提交失败");
					}
				} else {
					map.put("status", false);
					map.put("msg", "提现申请提交失败");
				}*/
			}
			if (sub.getIsadmin() != 6 && num > 0) {
				agentzhfundLog.setStatus(4);
				map.put("status", true);
				map.put("msg", "提现申请提交成功");
			}
			if (agentzhfundLog.getStatus() == 4) {
				log.info("修改提现申请状态" + agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog));
			}
		}
		return map;
	}

	/**
	 * 
	 * @param agentzhfundLog
	 * @param subzh
	 *            用户id--subzh
	 * @param order_no
	 *            交易订单号
	 * @param pay_time
	 *            交易时间
	 * @param total_fee
	 *            交易金额
	 * @param paystate
	 *            操作状态
	 * @param bz
	 *            操作类型
	 * @return
	 */
	public AgentzhfundLog saveAgentzhfundLog(AgentzhfundLog agentzhfundLog, String subzh, String order_no,
			Date pay_time, BigDecimal total_fee, int paystate, int bz) {
		try {
			String type = bz == 1 ? "1" : "2";
			agentzhfundLog.setSubzh(subzh);
			agentzhfundLog.setOrderno(order_no);
			agentzhfundLog.setType(type);
			agentzhfundLog.setBz((byte) bz);// 充值
			agentzhfundLog.setModifytime(pay_time);
			agentzhfundLog.setFund(total_fee);
			agentzhfundLog.setStatus(paystate);// 支付成功
			agentzhfundLog.setName(agentzhfundLog.getName());

			TreeMap<String, Object> tmap = new TreeMap<String, Object>();
			if (bz == 2) {// 提现
				tmap.put("amount", total_fee);
				tmap.put("bankCardNumber", agentzhfundLog.getBankCardNumber());
				tmap.put("phoneNum", agentzhfundLog.getPhoneNum());
				tmap.put("idcard", agentzhfundLog.getIdcard());
				tmap.put("bankcode", agentzhfundLog.getBankcode());
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			} else {
				tmap.put("充值方式", type);
				tmap.put("充值人", agentzhfundLog.getName());
				tmap.put("充值单号", order_no);
				tmap.put("充值金额", agentzhfundLog.getFund());
				tmap.put("充值时间", agentzhfundLog.getModifytime());
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			}
			log.info("log6:" + agentzhfundLog.getDescription());
			int num = agentzhfundLogMapper.insertSelective(agentzhfundLog);
			if (num > 0) {
				log.info("agentzhfundLogMapper==SUCCESS:" + num);

				List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(order_no);
				if (alist != null && alist.size() == 1) {
					agentzhfundLog = alist.get(0);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return agentzhfundLog;
	}

	/**
	 * 配资方法
	 * 
	 * @param username
	 *            用户名
	 * @param accmoney
	 *            配资金额
	 * @param orderno
	 *            订单号
	 * @param paytime
	 *            配资时间
	 * @param fundtype
	 *            配资类型
	 * @return
	 */
	public FundPzlog saveFundpzlog(String username, BigDecimal accmoney, String orderno, Date paytime, int fundtype) {
		FundPzlog fundPzlog = new FundPzlog();
		log.info("log:开始记录配资" + username + "---8--" + "--" + accmoney + "--");
		fundPzlog.setSubzh(username);
		// 1:配资 资金比例 2:加配资金比例 3:减配 4:追加保证金 5:出金 6:充值 7:提现 8:调账入金 9调账出金*/
		fundPzlog.setFundtype(fundtype);
		fundPzlog.setSetpro(0);
		fundPzlog.setFundbalance(accmoney);
		fundPzlog.setCreatetime(DateUtil.getSystemDate());

		TreeMap<String, Object> tmap = new TreeMap<String, Object>();
		tmap.put("操作人", fundPzlog.getSubzh());
		tmap.put("操作单号", orderno);
		tmap.put("操作金额", accmoney);
		tmap.put("操作时间", paytime);
		JSONObject descriptions = JSONObject.parseObject(JSON.toJSONString(tmap));
		fundPzlog.setSetdesc(descriptions.toJSONString());
		try {
			int n = pzlogMapper.insertSelective(fundPzlog);
			log.info("log操作配资===》" + n + "=====>" + fundPzlog.getSetdesc());
		} catch (Exception e) {
			log.info("操作配资失败", e);
		}
		return fundPzlog;
	}

	/**
	 * 调柜台入金协议
	 * 
	 * @param subzh
	 *            账户信息
	 * @param agentzhfundLog
	 *            提现信息
	 * @return
	 */

	public Map<String, Object> addMoney(Subzh subzh, AgentzhfundLog agentzhfundLog){
		Map<String, Object> map = new HashMap<String, Object>();
		log.info("调柜台的入金金额" + agentzhfundLog.getFund());
		// 计算汇率，调柜台协议，把钱加到柜台账户
		BigDecimal fundbalance = agentzhfundLog.getFund();
		try {
			if (subzh != null && subzh.getIsadmin() == 6) {
				log.info("{\"seq_no\":" + subzh.getId() + ",\"client_id\":\"" + subzh.getSubzh()
						+ "\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":" + fundbalance
						+ ",\"warning_line\":0.00,\"open_line\":0.00}" + "-------"
						+ DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
				String rbStr = simulateStockService.commonFunction(
						"{\"seq_no\":" + subzh.getId() + ",\"client_id\":\"" + subzh.getSubzh()
								+ "\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":" + fundbalance
								+ ",\"warning_line\":0.00,\"open_line\":0.00}",
						DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
				if (!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1) {
					JsonParser parser = new JsonParser();
					JsonElement element = parser.parse(rbStr);
					JsonObject jsonObj = element.getAsJsonObject();
					log.info("调入金协议成功1：" + rbStr + "---" + DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					if (CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()) {
						// 掉协议成功，入金成功
						log.info("调入金协议成功2：" + rbStr);
						map.put("status", true);
						map.put("msg", "调入金协议成功");
					} else {
						// 入金失败
						log.info("调入金协议失败：" + rbStr);
						map.put("status", false);
						map.put("msg", "调入金协议失败");
					}
				} else {
					log.info("调入金协议失败：" + rbStr);
					map.put("status", false);
					map.put("msg", "调入金协议失败");
				}
			} else {
				if (subzh.getFundbalance() != null) {
					subzh.setFundbalance(subzh.getFundbalance().add((agentzhfundLog.getFund())));
				}
				subzhMapper.updateByPrimaryKeySelective(subzh);
			}
		} catch (Exception e) {
			log.error("调入金协议出现异常", e);
		}
		return map;
	}

	/**
	 * //调柜台出金协议
	 * 
	 * @param subzh
	 *            账户信息
	 * @param afl
	 *            出金信息
	 * @return
	 */

	public Map<String, Object> getMoney(Subzh subzh, AgentzhfundLog afl) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 计算汇率，调柜台协议，减去提现金额
		log.info("调柜台的出金金额" + afl.getFund());
		BigDecimal fundbalance = afl.getFund();
		if (null != afl && afl.getId() != null && afl.getId() != 0) {
			try {
				log.info("提现调柜台协议开始");

				String str = "{\"seq_no\":" + afl.getId() + ",\"client_id\":\"" + subzh.getSubzh()
						+ "\",\"fund_type\":1,\"prev_fund\":0.00,\"after_fund\":" + fundbalance
						+ ",\"warning_line\":0.00,\"open_line\":0.00}";
				log.info("出金协议参数" + str);
				long starttime = System.currentTimeMillis();
				String rbStr = simulateStockService.commonFunction(str, DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
				long endtime = System.currentTimeMillis();
				log.info("开始时间"+starttime+"-------结束时间"+endtime+"---本次用时"+(endtime-starttime)+"--设置超时时间"+DefineNumber.SO_TIME_OUT);
				
				log.info("柜台返回参数" + rbStr);
				if (!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1) {
					JsonParser parser = new JsonParser();
					JsonElement element = parser.parse(rbStr);
					JsonObject jsonObj = element.getAsJsonObject();
					if (CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()) {
						log.info("调柜台协议成功");
						// 保存资金流水信息
						map.put("status", true);
						map.put("msg", "申请提现成功");
					} else {
						// 调柜台协议失败删除该条记录
						log.info(jsonObj.get("describe"));
						map.put("status", false);
						map.put("msg", "调柜台出金协议失败" + jsonObj.get("describe"));
					}
				}
			} catch (Exception e) {
				// 调柜台协议失败删除该条记录
				log.error("柜台调协议异常：" + e);
				map.put("status", false);
				map.put("msg", "提现出现异常，请联系管理员");
			}
		}
		return map;
	}
	
	public Map<String, Object> getMoney(String subzh,BigDecimal fundbalance,Integer aflId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 计算汇率，调柜台协议，减去提现金额
		log.info("调柜台的出金金额" + fundbalance);

		if (aflId != null && aflId!= 0) {
			try {
				log.info("提现调柜台协议开始");

				String str = "{\"seq_no\":" +aflId + ",\"client_id\":\"" + subzh
						+ "\",\"fund_type\":1,\"prev_fund\":0.00,\"after_fund\":" + fundbalance
						+ ",\"warning_line\":0.00,\"open_line\":0.00}";
				log.info("出金协议参数" + str);
				String rbStr = simulateStockService.commonFunction(str, DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);				
				log.info("柜台返回参数" + rbStr);
				if (!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1) {
					JsonParser parser = new JsonParser();
					JsonElement element = parser.parse(rbStr);
					JsonObject jsonObj = element.getAsJsonObject();
					if (CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()) {
						log.info("调柜台协议成功");
						// 保存资金流水信息
						map.put("status", true);
						map.put("msg", "申请提现成功");
					} else {
						// 调柜台协议失败删除该条记录
						log.info(jsonObj.get("describe"));
						map.put("status", false);
						map.put("msg", "调柜台出金协议失败" + jsonObj.get("describe"));
					}
				}
			} catch (Exception e) {
				// 调柜台协议失败删除该条记录
				log.error("柜台调协议异常：" + e);
				map.put("status", false);
				map.put("msg", "提现出现异常，请联系管理员");
			}
		}
		return map;
	}
	
	// 根据用户名去查询配资信息
	public List<FundPzlog> getFundPzlogList(Subzh subzh) {
		List<FundPzlog> sfplist = new ArrayList<FundPzlog>();
		try {
			FundPzlogExample example = new FundPzlogExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andSubzhEqualTo(subzh.getSubzh());
			sfplist = pzlogMapper.selectByExample(example);
		} catch (Exception e) {
			log.error("查询用户配资信息", e);
		}
		return sfplist;
	}

	@Override
	public Map<String, Object> keyPayCallback(HttpServletRequest req, String token){
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
		sortMap.put("token", token);
		String string = SignMd5Utils.createSign1(sortMap);
		if ("0000".equals(code) && string.equals(sign)) {
			List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(order_id);
			if (alist == null) {
				log.info("订单号不存在");
				return null;
			}
			if (alist.size() != 1) {
				log.info("订单号重复");
				return null;
			}
			AgentzhfundLog agentzhfundLog = alist.get(0);
			Subzh subzh = subzhMapper.selectByPrimaryKeySubzh(agentzhfundLog.getSubzh());
			if (subzh == null) {
				log.info("用户信息不存在");
				return null;
			}
			List<FundPzlog> sfplist = getFundPzlogList(subzh);
			if (agentzhfundLog != null && agentzhfundLog.getStatus() == 0) {
				// 调协议给账户添加充值金额
				subzh.setZhstate(1);
				int count = subzhMapper.updateByPrimaryKeySelective(subzh);
				if (count > 0 && subzh.getZhstate() == 1) {// 状态为1，表示账户激活，激活账户才能调柜台入金协议
					
					Map<String, Object> amap = addMoney(subzh, agentzhfundLog);
					if (null != amap && amap.size() > 0) {
						if (null != amap.get("status") && (Boolean) amap.get("status")) {
							agentzhfundLog.setStatus(1);// 修改状态为1 --表示充值成功
							saveFundpzlog(agentzhfundLog.getSubzh(), agentzhfundLog.getFund(),
									agentzhfundLog.getOrderno(), DateUtil.getSystemDate(), 6);
						} else {
							agentzhfundLog.setStatus(2);// 修改状态为2 --表示充值失败
							
							if ((sfplist == null) && (sfplist.size() <= 1)) {
								subzh.setZhstate(Integer.valueOf(0));
							}
						}
					} else {
						agentzhfundLog.setStatus(2);// 修改状态为2 --表示充值失败
						if ((sfplist == null) && (sfplist.size() <= 1)) {
							subzh.setZhstate(Integer.valueOf(0));
						}
					}

					log.info("修改用户激活状态" + subzhMapper.updateByPrimaryKeySelective(subzh));
				}
			} else {
				log.info(order_id + "未查到订单，或者订单已处理");
			}
			agentzhfundLog.setBanchname("充值回调 :"+jsonString);
			log.info("修改agentzhfundLog状态" + agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog));
		} else {
			log.info("订单号验签失败.............." + order_id);
		}
		return null;
	}
}
