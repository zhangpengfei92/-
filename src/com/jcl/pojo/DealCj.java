/**
 * 
 */
package com.jcl.pojo;

import java.util.Date;

/**
 * @author heqiwen
 * @date 2017-6-19
 * @describe 成交记录
 * @modify 
 * @Copyright jcl
 */
public class DealCj {
	private Integer id;//子账号
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	private String subzh;//子账号
	private String pt;//所在平台
	private String channel;//所属渠道
	private String agentzh;//所属代理
	private String broker;//所属经纪人
	
	private String entrustNo;//
	private String mainzh;//主账号
	private Integer exchangeType;//交易所
	private Integer directionType;//方向
	private String stockCode;//合约代码
	private String stockName;//合约品种
	private Integer entrustBs;//开平
	private Double businessVol;//成交数量
	private Double businessPrice;//成交价格
	private Integer businessDate;//操作日期
	private Integer businessTime;//操作时间
	private Double newPosition;//新仓位
	private Double serviceFee;//服务费
	private Double fee;//手续费
	private Double hedgeType;//成交类型
	


	private Double occurBalance;//成交金额
	private String orderNo;//订单编号
	private String dealcjtime;//成交时间
	private Date tradeDate;//成交时间
	private Integer ordertype;//
	
	private String channelname;
	private String brokername;
	private String agentname;
	private String phone;
	private Double dealje;
	private Long mdealtime;//

	private String ordertime;
	
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public Double getHedgeType() {
		return hedgeType;
	}
	public void setHedgeType(Double hedgeType) {
		this.hedgeType = hedgeType;
	}
	public String getSubzh() {
		return subzh;
	}
	public void setSubzh(String subzh) {
		this.subzh = subzh;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	public String getMainzh() {
		return mainzh;
	}
	public void setMainzh(String mainzh) {
		this.mainzh = mainzh;
	}
	
	public String getEntrustNo() {
		return entrustNo;
	}
	public void setEntrustNo(String entrustNo) {
		this.entrustNo = entrustNo;
	}
	public Integer getExchangeType() {
		return exchangeType;
	}
	public void setExchangeType(Integer exchangeType) {
		this.exchangeType = exchangeType;
	}
	public Integer getDirectionType() {
		return directionType;
	}
	public void setDirectionType(Integer directionType) {
		this.directionType = directionType;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Integer getEntrustBs() {
		return entrustBs;
	}
	public void setEntrustBs(Integer entrustBs) {
		this.entrustBs = entrustBs;
	}
	public Double getBusinessVol() {
		return businessVol;
	}
	public void setBusinessVol(Double businessVol) {
		this.businessVol = businessVol;
	}
	public Double getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(Double businessPrice) {
		this.businessPrice = businessPrice;
	}
	public Integer getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Integer businessDate) {
		this.businessDate = businessDate;
	}
	public Integer getBusinessTime() {
		return businessTime;
	}
	public void setBusinessTime(Integer businessTime) {
		this.businessTime = businessTime;
	}
	public Double getNewPosition() {
		return newPosition;
	}
	public void setNewPosition(Double newPosition) {
		this.newPosition = newPosition;
	}
	public Double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getDealcjtime() {
		return dealcjtime;
	}
	public void setDealcjtime(String dealcjtime) {
		this.dealcjtime = dealcjtime;
	}
	public Double getOccurBalance() {
		return occurBalance;
	}
	public void setOccurBalance(Double occurBalance) {
		this.occurBalance = occurBalance;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public Integer getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(Integer ordertype) {
		this.ordertype = ordertype;
	}
	public String getChannelname() {
		return channelname;
	}
	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}
	public String getBrokername() {
		return brokername;
	}
	public void setBrokername(String brokername) {
		this.brokername = brokername;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getDealje() {
		return dealje;
	}
	public void setDealje(Double dealje) {
		this.dealje = dealje;
	}
	public Long getMdealtime() {
		return mdealtime;
	}
	public void setMdealtime(Long mdealtime) {
		this.mdealtime = mdealtime;
	}
	
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public String getAgentzh() {
		return agentzh;
	}
	public void setAgentzh(String agentzh) {
		this.agentzh = agentzh;
	}
	public String getAgentname() {
		return agentname;
	}
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	
	
	private String exchangeTypeShift;
	public String getExchangeTypeShift() {
		if(this.exchangeType != null) {
			if(this.exchangeType == 24) {
				return "上海国际能源交易中心";
			}else if(this.exchangeType == 1) {
				return "上海证券交易所";
			}else if(this.exchangeType == 3){
				return "中国金融期货交易所";
			}else if(this.exchangeType == 4){
				return "上海期货交易所";
			}else if(this.exchangeType == 5){
				return "大连商品交易所";
			}else if(this.exchangeType == 6){
				return "郑州商品交易所";
			}else {
				return "";
			}
		}else {
			return "";
		}
	}
	
	private String entrustBsShift;
	public String getEntrustBsShift() {
		if(this.entrustBs != null) {
			if(this.entrustBs == 1) {
				return "卖出";
			}else {
				return "买入";
			}
		}else {
			return "";
		}
	}
	
	private String directionTypeShift;
	public String getDirectionTypeShift() {
		if(this.directionType != null) {
			if(this.directionType == 0) {
				return "开仓";
			}else if(this.directionType == 1) {
				return "平仓";
			}else if(this.directionType == 2){
				return "平今";
			}else if(this.directionType == 3) {
				return "平昨";
			}else{
				return "";
			}
		}else {
			return "";
		}
	}
	
	
	
	
	
	
}
