package com.jcl.pojo;

/**
 * 委托买卖实体类
 * @author zhenghuayi
 *
 */
public class entryEntity {
	
	private String client_id;  //子帐号
	private String auth_id;  //后台强平约定
	public String getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(String auth_id) {
		this.auth_id = auth_id;
	}
	private Integer exchange_type;          //市场
	private Integer entrust_type;        //委托类型 0限价单 1市价单
	private Integer entrust_bs;         //买卖方向 0买 1卖
	private Integer entrust_direction;   //开平仓方向 0开仓  1平仓
	private String stock_code;         //股票代码
	private String entrust_price;     //委托价格，市价单填0
	private Integer entrust_vol;      //手数
	private Integer hedge_type;       //投机方式 4强平
	private Integer entrust_way;       //委托方式 4WEB后台
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public Integer getExchange_type() {
		return exchange_type;
	}
	public void setExchange_type(Integer exchange_type) {
		this.exchange_type = exchange_type;
	}
	public Integer getEntrust_type() {
		return entrust_type;
	}
	public void setEntrust_type(Integer entrust_type) {
		this.entrust_type = entrust_type;
	}
	public Integer getEntrust_bs() {
		return entrust_bs;
	}
	public void setEntrust_bs(Integer entrust_bs) {
		this.entrust_bs = entrust_bs;
	}
	public Integer getEntrust_direction() {
		return entrust_direction;
	}
	public void setEntrust_direction(Integer entrust_direction) {
		this.entrust_direction = entrust_direction;
	}
	public String getStock_code() {
		return stock_code;
	}
	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}
	public String getEntrust_price() {
		return entrust_price;
	}
	public void setEntrust_price(String entrust_price) {
		this.entrust_price = entrust_price;
	}
	public Integer getEntrust_vol() {
		return entrust_vol;
	}
	public void setEntrust_vol(Integer entrust_vol) {
		this.entrust_vol = entrust_vol;
	}
	public Integer getHedge_type() {
		return hedge_type;
	}
	public void setHedge_type(Integer hedge_type) {
		this.hedge_type = hedge_type;
	}
	public Integer getEntrust_way() {
		return entrust_way;
	}
	public void setEntrust_way(Integer entrust_way) {
		this.entrust_way = entrust_way;
	}
	
}
