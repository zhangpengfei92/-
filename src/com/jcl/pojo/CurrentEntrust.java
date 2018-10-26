package com.jcl.pojo;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 实时委托数据
 *
 */
public class CurrentEntrust {
	
	private String main_zh;//主账号ID
	
	private String agent;//代理商ID 
	
	private String sub_zh;//资金账号 
	
	private String order_id;//委托编号
	
	private Integer mark;//市场
	
	private String code;//证券代码
	
	private String name;//证券名称
	
	private String order_type;//交易类型  市价/限价
	
	private String order_bs;//买，卖
	
	private String order_direction;//开仓，平仓
	
	private String hedge_type;//投机，套报
	
	private String order_source;//报单来源
	
	private String status;        
	
	private String close_id;//平仓单  持仓id
	
	private String order_price;//价格
	
	private Integer order_vol;//证券数量
	
	private String order_date;//委托日期
	
	private String order_time;//委托时间
	
	private BigDecimal order_margin;//冻结保证金
	
	private BigDecimal order_fee;//冻结手续费
	
	private BigDecimal profit;// 持仓盈亏   加了这个字段
	//可平量 = 持仓量(position_vol) - 卖出冻结量(sellfreeze_vol)
	
	private Integer trade_vol;//已成数量
	
	private BigDecimal trade_price;//成交均价
	
	private String pt;//所在平台
	private String channel;//所属渠道
	private String agentzh;//所属代理
	private String broker;//所属经纪人
	
	private String time;
	
	private String username;  //认证姓名
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

	public String getTime() {
		if(!StringUtils.isBlank(order_date) && !StringUtils.isBlank(order_time)) {
			if(order_time.length() == 5){
				order_time = "0" + order_time;
			} else if(order_time.length() == 4){
				order_time = "00" + order_time;
			} else if(order_time.length() == 3){
				order_time = "000" + order_time;
			} else if(order_time.length() == 2){
				order_time = "0000" + order_time;
			} else if(order_time.length() == 1){
				order_time = "00000" + order_time;
			} 
			return order_date.substring(0, 4)+"-"+order_date.substring(4, 6)+"-"+order_date.substring(6, 8)+" "+order_time.substring(0, 2)+":"+order_time.substring(2, 4)+":"+order_time.substring(4, 6);
		}else {
			return "";
		}
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

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
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

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getOrder_bs() {
		return order_bs;
	}

	public void setOrder_bs(String order_bs) {
		this.order_bs = order_bs;
	}

	public String getOrder_direction() {
		return order_direction;
	}

	public void setOrder_direction(String order_direction) {
		this.order_direction = order_direction;
	}

	public String getHedge_type() {
		return hedge_type;
	}

	public void setHedge_type(String hedge_type) {
		this.hedge_type = hedge_type;
	}

	public String getOrder_source() {
		return order_source;
	}

	public void setOrder_source(String order_source) {
		this.order_source = order_source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClose_id() {
		return close_id;
	}

	public void setClose_id(String close_id) {
		this.close_id = close_id;
	}

	public String getOrder_price() {
		return order_price;
	}

	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}

	public Integer getOrder_vol() {
		return order_vol;
	}

	public void setOrder_vol(Integer order_vol) {
		this.order_vol = order_vol;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public BigDecimal getOrder_margin() {
		return order_margin;
	}

	public void setOrder_margin(BigDecimal order_margin) {
		this.order_margin = order_margin;
	}

	public BigDecimal getOrder_fee() {
		return order_fee;
	}

	public void setOrder_fee(BigDecimal order_fee) {
		this.order_fee = order_fee;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public Integer getTrade_vol() {
		return trade_vol;
	}

	public void setTrade_vol(Integer trade_vol) {
		this.trade_vol = trade_vol;
	}

	public BigDecimal getTrade_price() {
		return trade_price;
	}

	public void setTrade_price(BigDecimal trade_price) {
		this.trade_price = trade_price;
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
	
}
