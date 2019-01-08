/**
 * 
 */
package com.jcl.pojo;

/**
 * @author heqiwen
 * @date 2018-5-22
 * @describe 交易管理   ----持仓数据
 * @modify 
 * @Copyright jcl
 */
public class Holder {

	private String subzh;//用户账户
	private String pt;//所在平台
	private String channel;//所属渠道
	private String agentzh;//所属代理
	private String broker;//所属经纪人
	private Integer zuocang;//昨仓
	//private Double holdPrice;//持仓均价-----
	private Double keepCostPrice;//持仓均价  速期
	
	private String businessNo;//成交编号
	private String stockCode;//合约代码
	private String stockName;//合约名称
	//private Integer directionType;//方向--------
	private Integer entrustBs;//方向    速期
	
	private Integer currentVol;//持仓量,总持仓
	//private Double costPrice;//成本价------
	private Double incomeBalance;//累计盈亏，浮动盈亏
	private Double lastPrce;//最新价
	private Integer enableVol;//可卖量
	private Double profit;//持仓盈亏
	//private Double stopProfit;//止盈价
	private Integer holderDate;//
	private Integer exchangeType;//
	
	private String holderTime;//
	private Integer todayVol;//
	private Double todayCostPrice;//
	private String channelname;
	private String brokername;
	private String agentname;
	
	private String username;
	
	private String fangx;//
	
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
	public Integer getZuocang() {
		return zuocang;
	}
	public void setZuocang(Integer zuocang) {
		this.zuocang = zuocang;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
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
	public Integer getCurrentVol() {
		return currentVol;
	}
	public void setCurrentVol(Integer currentVol) {
		this.currentVol = currentVol;
	}
	
	public Double getIncomeBalance() {
		return incomeBalance;
	}
	public void setIncomeBalance(Double incomeBalance) {
		this.incomeBalance = incomeBalance;
	}
	public Double getLastPrce() {
		return lastPrce;
	}
	public void setLastPrce(Double lastPrce) {
		this.lastPrce = lastPrce;
	}
	public Integer getEnableVol() {
		return enableVol;
	}
	public void setEnableVol(Integer enableVol) {
		this.enableVol = enableVol;
	}
	
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	public Integer getHolderDate() {
		return holderDate;
	}
	public void setHolderDate(Integer holderDate) {
		this.holderDate = holderDate;
	}
	
	public Integer getExchangeType() {
		return exchangeType;
	}
	public void setExchangeType(Integer exchangeType) {
		this.exchangeType = exchangeType;
	}
	public String getHolderTime() {
		return holderTime;
	}
	public void setHolderTime(String holderTime) {
		this.holderTime = holderTime;
	}
	public Integer getTodayVol() {
		return todayVol;
	}
	public void setTodayVol(Integer todayVol) {
		this.todayVol = todayVol;
	}
	public Double getTodayCostPrice() {
		return todayCostPrice;
	}
	public void setTodayCostPrice(Double todayCostPrice) {
		this.todayCostPrice = todayCostPrice;
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
	public String getAgentname() {
		return agentname;
	}
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	public Integer getEntrustBs() {
		return entrustBs;
	}
	public void setEntrustBs(Integer entrustBs) {
		this.entrustBs = entrustBs;
	}
	
	
	public Double getKeepCostPrice() {
		return keepCostPrice;
	}
	public void setKeepCostPrice(Double keepCostPrice) {
		this.keepCostPrice = keepCostPrice;
	}
	public String getFangx() {
		return fangx;
	}
	public void setFangx(String fangx) {
		this.fangx = fangx;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
