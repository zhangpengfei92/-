package com.jcl.pojo;

import org.bson.types.ObjectId;

/**
 * 
 * @author guohc
 *   实 时持仓数据
 */
public class CurrentHoder {
	private String main_zh;  //主账号ID
	private String agent;     //代理商ID
	private String sub_zh;       //资金账号
	private String mark;      //市场
	private String code;      //股票代码(交易编码)
	private String name;           //股票名字
	private String position_id;        //持仓编号
	private String product_code;      ////合约编码
	private Double position_vol;         //持仓量
	private Double today_vol;        //今持仓量
	private Double sellfreeze_vol;      //卖出冻结量
	private Double todaysellfreeze_vol;   ////今日卖出冻结
	private Double today_price;          //今持仓均价
	private Double price;              //持仓均价
	private Double loss_price;         //止损价格
	private Double bs_type;         //买卖方向
	private Double margin;         //占用保证金
	private Double profit_price;      //止盈价
	private String hedge_type;       //投机 /套报
	private String currency;           //币种代码
	private Double profit;           // // 持仓盈亏
	private Double sell_vol;           // // 可平量
	private Double history_vol;           // // 昨仓
	
	private String username;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getHistory_vol() {
		return history_vol;
	}
	public void setHistory_vol(Double history_vol) {
		this.history_vol = history_vol;
	}
	public Double getSell_vol() {
		return sell_vol;
	}
	public void setSell_vol(Double sell_vol) {
		this.sell_vol = sell_vol;
	}
	public String getMain_zh() {
		return main_zh;
	}
	public void setMain_zh(String main_zh) {
		this.main_zh = main_zh;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getSub_zh() {
		return sub_zh;
	}
	public void setSub_zh(String sub_zh) {
		this.sub_zh = sub_zh;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition_id() {
		return position_id;
	}
	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public Double getPosition_vol() {
		return position_vol;
	}
	public void setPosition_vol(Double position_vol) {
		this.position_vol = position_vol;
	}
	public Double getToday_vol() {
		return today_vol;
	}
	public void setToday_vol(Double today_vol) {
		this.today_vol = today_vol;
	}
	public Double getSellfreeze_vol() {
		return sellfreeze_vol;
	}
	public void setSellfreeze_vol(Double sellfreeze_vol) {
		this.sellfreeze_vol = sellfreeze_vol;
	}
	public Double getTodaysellfreeze_vol() {
		return todaysellfreeze_vol;
	}
	public void setTodaysellfreeze_vol(Double todaysellfreeze_vol) {
		this.todaysellfreeze_vol = todaysellfreeze_vol;
	}
	public Double getToday_price() {
		return today_price;
	}
	public void setToday_price(Double today_price) {
		this.today_price = today_price;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getLoss_price() {
		return loss_price;
	}
	public void setLoss_price(Double loss_price) {
		this.loss_price = loss_price;
	}
	public Double getBs_type() {
		return bs_type;
	}
	public void setBs_type(Double bs_type) {
		this.bs_type = bs_type;
	}
	public Double getMargin() {
		return margin;
	}
	public void setMargin(Double margin) {
		this.margin = margin;
	}
	public Double getProfit_price() {
		return profit_price;
	}
	public void setProfit_price(Double profit_price) {
		this.profit_price = profit_price;
	}
	public String getHedge_type() {
		return hedge_type;
	}
	public void setHedge_type(String hedge_type) {
		this.hedge_type = hedge_type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getAgentzh() {
		return agentzh;
	}
	public void setAgentzh(String agentzh) {
		this.agentzh = agentzh;
	}
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	private String pt;//所在平台
	private String channel;//所属渠道
	private String agentzh;//所属代理
	private String broker;//所属经纪人
	
}
