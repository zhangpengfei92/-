package com.jcl.pojo;

/**
 * 实时资金明细表
 * 
 * @author ghc
 *
 */
public class Currentzj {

	private String cookie; // 用户唯一编号
	private String account; // 资金账号
	private String trade_date; // 清算日期
	private Double loan; // 用户借款
	private Double init; // 用户配资保证金
	private Double init_addto; // 用户追加保证金
	private Double available; // 可用资金
	private String no_fetch; // 可用不可取资金
	private Double position_profit; // 浮动盈亏
	private Double close_profit; // 平仓盈亏
	private Double total; // 总资产
	private String market_value; // 股票市值
	private Double last; // 上日结存
	private String close_line; // 平仓线
	private String warning_line; // 预警线
	private Double freeze; // 冻结保证金 + 占用保证金
	private Double margin; // 占用保证金
	private Double deposit; //// 当日入金
	private Double withdraw; //// 当日出金
	private Double fee; //// 手续费汇总
	private String time; //// 写入时间
	private String pt;// 所在平台
	private String channel;// 所属渠道
	private String agentzh;// 所属代理
	private String broker;// 所属经纪人
	private Double totalRight;// 静态权益
	private Double demicRight;// 动态权益
	private String owe; // 风险率
	private String dentioew; // 宜止涨 风险率算法
	private Double freezeVol;

	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public Double getFreezeVol() {
		return freeze - this.getMargin();
	}

	public void setFreezeVol(Double freezeVol) {
		this.freezeVol = freezeVol;
	}
	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}

	public Double getLoan() {
		return loan;
	}

	public void setLoan(Double loan) {
		this.loan = loan;
	}

	public Double getInit() {
		return init;
	}

	public void setInit(Double init) {
		this.init = init;
	}

	public Double getInit_addto() {
		return init_addto;
	}

	public void setInit_addto(Double init_addto) {
		this.init_addto = init_addto;
	}

	public Double getAvailable() {
		return available;
	}

	public void setAvailable(Double available) {
		this.available = available;
	}

	public String getNo_fetch() {
		return no_fetch;
	}

	public void setNo_fetch(String no_fetch) {
		this.no_fetch = no_fetch;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getMarket_value() {
		return market_value;
	}

	public void setMarket_value(String market_value) {
		this.market_value = market_value;
	}

	public String getClose_line() {
		return close_line;
	}

	public void setClose_line(String close_line) {
		this.close_line = close_line;
	}

	public String getWarning_line() {
		return warning_line;
	}

	public void setWarning_line(String warning_line) {
		this.warning_line = warning_line;
	}

	public Double getPosition_profit() {
		return position_profit;
	}

	public void setPosition_profit(Double position_profit) {
		this.position_profit = position_profit;
	}

	public Double getClose_profit() {
		return close_profit;
	}

	public void setClose_profit(Double close_profit) {
		this.close_profit = close_profit;
	}

	public Double getFreeze() {
		return freeze;
	}

	public void setFreeze(Double freeze) {
		this.freeze = freeze;
	}

	public Double getMargin() {
		return margin;
	}

	public void setMargin(Double margin) {
		this.margin = margin;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}

	public Double getTotalRight() {
		return totalRight;
	}

	public void setTotalRight(Double totalRight) {
		this.totalRight = totalRight;
	}

	public Double getDemicRight() {
		return demicRight;
	}

	public void setDemicRight(Double demicRight) {
		this.demicRight = demicRight;
	}
	

	public String getOwe() {
		// 动态权益为0时 风险率 = 0
		// 动态权益>0时 风险率 = 占用保证金(margin) / 动态权益(total) * 100
		if (this.getTotal() == 0) {
			return "0.00";
		} else {
			return String.valueOf(this.getMargin() / this.getTotal() * 100);
		}
	}

	public void setOwe(String owe) {
		this.owe = owe;
	}
	// 一直涨 风险率
	public String getDentioew() {
		// 占用的情况下，风险率默认是999%
		// 风险率=动态权益/占用保证金 
		if (this.getMargin() == 0) {
			return "999";
		} else {
			return String.valueOf(this.getTotal() / this.getMargin() * 100);
		}
	}

	public void setDentioew(String dentioew) {
		this.dentioew = dentioew;
	}
}
