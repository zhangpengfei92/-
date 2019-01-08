/**
 * 
 */
package com.jcl.pojo;

import com.jcl.stock.simulate.StringUtil;

/**
 * @author heqiwen
 * @date 2018-5-22
 * @describe 交易管理中查询条件所需实体
 * @modify 
 * @Copyright jcl
 */
public class TradeParam {

	private String subzh;//用户账户
	private String jg;//机构
	private String pt;//平台
	private String channel;//所属渠道
	private String agentzh;//代理商
	private String broker;//所属经纪人
	private Integer exchange;//交易市场
	private String stockCode;//证券代码，合约代码
	private String stockName;//合约名称
	
	private String starttime;//开始时间
	private String endtime;//结束时间
	private Integer lsflag;//1当日，2历史
	
	private String client_id;//
	private Integer start;//
	private Integer limit;//
	private Integer start_date;
	private Integer end_date;
	
	
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
	public Integer getExchange() {
		return exchange;
	}
	public void setExchange(Integer exchange) {
		this.exchange = exchange;
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
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getStart_date() {
		return start_date;
	}
	public void setStart_date(Integer start_date) {
		this.start_date = start_date;
	}
	public Integer getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Integer end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		client_id=getSubzh();
		if(!StringUtil.isAnyNullOrEmpty(starttime) || !StringUtil.isAnyNullOrEmpty(starttime)){
			return "{\"client_id\":\"" + client_id + "\",\"start\":" + start
					+ ", \"limit\":" + limit + ", \"start_date\":" + start_date
					+ ", \"end_date\":" + end_date + "}";
		}else{
			return "{\"client_id\":\"" + client_id + "\", \"start\":" + start+ ", \"limit\":" + limit + "}";
		}
		
		
	}
	
	public String toFundString(){
		return "{\"client_id\":\""+subzh+"\"}";
	}
	public Integer getLsflag() {
		return lsflag;
	}
	public void setLsflag(Integer lsflag) {
		this.lsflag = lsflag;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
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
	
	
	
	
}
