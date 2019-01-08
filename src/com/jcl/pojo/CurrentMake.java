package com.jcl.pojo;
/**
 * 实时成交
 *
 */

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class CurrentMake {
	
	private String main_zh;//主账号ID
	
	private String agent;//代理商ID 
	
	private String sub_zh;//资金账号   
	
	private Integer mark;//市场
	
	private String code;//证券代码
	
	private String name;//证券名称
	
	private String order_id;//委托编号
	
	private String trade_id;//成交编号
	
	private String order_type;//交易类型  市价/限价
	
	private Integer order_bs;//买，卖
	
	private Integer order_direction;//开仓，平仓
	
	private String hedge_type;//投机，套报
	
	private String close_id;//平仓单  持仓id
	
	private BigDecimal trade_price;//成交价
	
	private Integer trade_vol;//成交数量
	
	private BigDecimal trade_amount;//成交金额/平仓盈亏
	
	private String trade_date;//成交日期
	
	private String trade_time;//成交时间
	
	private BigDecimal fee;//手续费
	
	private String used;
	
	private String username;
	
	private String pt;//所在平台
	private String channel;//所属渠道
	private String agentzh;//所属代理
	private String broker;//所属经纪人
	
	private String makeTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMakeTime() {
		if(!StringUtils.isBlank(trade_date) && !StringUtils.isBlank(trade_time)) {
			if(trade_time.length() == 5){
				trade_time = "0" + trade_time;
			} else if(trade_time.length() == 4){
				trade_time = "00" + trade_time;
			} else if(trade_time.length() == 3){
				trade_time = "000" + trade_time;
			} else if(trade_time.length() == 2){
				trade_time = "0000" + trade_time;
			} else if(trade_time.length() == 1){
				trade_time = "00000" + trade_time;
			} 
			return trade_date.substring(0, 4)+"-"+trade_date.substring(4, 6)+"-"+trade_date.substring(6, 8)+" "+trade_time.substring(0, 2)+":"+trade_time.substring(2, 4)+":"+trade_time.substring(4, 6);
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
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public Integer getOrder_bs() {
		return order_bs;
	}
	public void setOrder_bs(Integer order_bs) {
		this.order_bs = order_bs;
	}
	public Integer getOrder_direction() {
		return order_direction;
	}
	public void setOrder_direction(Integer order_direction) {
		this.order_direction = order_direction;
	}
	public String getHedge_type() {
		return hedge_type;
	}
	public void setHedge_type(String hedge_type) {
		this.hedge_type = hedge_type;
	}
	public String getClose_id() {
		return close_id;
	}
	public void setClose_id(String close_id) {
		this.close_id = close_id;
	}
	public BigDecimal getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(BigDecimal trade_price) {
		this.trade_price = trade_price;
	}
	public Integer getTrade_vol() {
		return trade_vol;
	}
	public void setTrade_vol(Integer trade_vol) {
		this.trade_vol = trade_vol;
	}
	public BigDecimal getTrade_amount() {
		return trade_amount;
	}
	public void setTrade_amount(BigDecimal trade_amount) {
		this.trade_amount = trade_amount;
	}
	public String getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}
	public String getTrade_time() {
		return trade_time;
	}
	public void setTrade_time(String trade_time) {
		this.trade_time = trade_time;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
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
