package com.jcl.pojo;

import java.sql.Timestamp;

/**
 * Subcj entity. 
 */
public class Subcj implements java.io.Serializable, Comparable<Subcj> {

	private static final long serialVersionUID = 1L;
	private Long lsh;
	private String agentzh;//代理商账号
	private String subzh;//子账号
	private String wtbh;//委托编号 ,委托标识
	private String cjbh;//成交编号 ,可以多次成交
	
	private String maincjbh;//实际成交编号,可多次成交
	private String bz;//币种
	private String sc;//市场代码
	private String code;//吕种代码  股票代码
	private String hydm;//合约代码  股票名称
	private Integer ywlb;//业务类型
	private Integer xdzllx;//下单指令类型: 限价/市价(后来又指定xdzllx为 开平)
	private Double cjjg;//买入卖出或者开平仓 实际已经成交的价格  成交价格
	private Integer cjsl;//实际成交量,或者期货实际平仓平仓量  成交数量
	private Double yj;//佣金
	private Double qtfy;//其他费用
	private String maincjtime;//成交时间 
	private Timestamp cjtime;//成交时间
	private Double cost;//成本价格
	private Double stopjg;//止损价
	private Double profitjg;//止盈价
	private Double bond;//保证金
	private Double sxf;//手续费
	
	private Long userid;//创建人

	//在用于成交记录时,接口没有返回订单编号(成交编号cjbh),主账号mainzh,手续费,开平
	private String orderNo;
	private String mainzh;//(数据库里是mainzh)
	private String broker;
	private int exchange;//交易所类别
	//private int direction;
	private int entrust_bs;//买卖方向(数据库里是bs_type)
	private double servicefee;
	
	private double oldPosition;//旧仓位
	private double newPosition;//新仓位

	public Long getLsh() {
		return lsh;
	}

	public void setLsh(Long lsh) {
		this.lsh = lsh;
	}

	public String getAgentzh() {
		return agentzh;
	}

	public void setAgentzh(String agentzh) {
		this.agentzh = agentzh;
	}

	public String getSubzh() {
		return subzh;
	}

	public void setSubzh(String subzh) {
		this.subzh = subzh;
	}

	public String getWtbh() {
		return wtbh;
	}

	public void setWtbh(String wtbh) {
		this.wtbh = wtbh;
	}

	public String getCjbh() {
		return cjbh;
	}

	public void setCjbh(String cjbh) {
		this.cjbh = cjbh;
	}

	public String getMaincjbh() {
		return maincjbh;
	}

	public void setMaincjbh(String maincjbh) {
		this.maincjbh = maincjbh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHydm() {
		return hydm;
	}

	public void setHydm(String hydm) {
		this.hydm = hydm;
	}

	public Integer getYwlb() {
		return ywlb;
	}

	public void setYwlb(Integer ywlb) {
		this.ywlb = ywlb;
	}

	public Integer getXdzllx() {
		return xdzllx;
	}

	public void setXdzllx(Integer xdzllx) {
		this.xdzllx = xdzllx;
	}

	public Double getCjjg() {
		return cjjg;
	}

	public void setCjjg(Double cjjg) {
		this.cjjg = cjjg;
	}

	public Integer getCjsl() {
		return cjsl;
	}

	public void setCjsl(Integer cjsl) {
		this.cjsl = cjsl;
	}

	public Double getYj() {
		return yj;
	}

	public void setYj(Double yj) {
		this.yj = yj;
	}

	public Double getQtfy() {
		return qtfy;
	}

	public void setQtfy(Double qtfy) {
		this.qtfy = qtfy;
	}

	public String getMaincjtime() {
		return maincjtime;
	}

	public void setMaincjtime(String maincjtime) {
		this.maincjtime = maincjtime;
	}

	public Timestamp getCjtime() {
		return cjtime;
	}

	public void setCjtime(Timestamp cjtime) {
		this.cjtime = cjtime;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getStopjg() {
		return stopjg;
	}

	public void setStopjg(Double stopjg) {
		this.stopjg = stopjg;
	}

	public Double getProfitjg() {
		return profitjg;
	}

	public void setProfitjg(Double profitjg) {
		this.profitjg = profitjg;
	}

	public Double getBond() {
		return bond;
	}

	public void setBond(Double bond) {
		this.bond = bond;
	}

	public Double getSxf() {
		return sxf;
	}

	public void setSxf(Double sxf) {
		this.sxf = sxf;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getMainzh() {
		return mainzh;
	}

	public void setMainzh(String mainzh) {
		this.mainzh = mainzh;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public int getExchange() {
		return exchange;
	}

	public void setExchange(int exchange) {
		this.exchange = exchange;
	}

	public int getEntrust_bs() {
		return entrust_bs;
	}

	public void setEntrust_bs(int entrust_bs) {
		this.entrust_bs = entrust_bs;
	}

	public double getServicefee() {
		return servicefee;
	}

	public void setServicefee(double servicefee) {
		this.servicefee = servicefee;
	}

	public double getOldPosition() {
		return oldPosition;
	}

	public void setOldPosition(double oldPosition) {
		this.oldPosition = oldPosition;
	}

	public double getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(double newPosition) {
		this.newPosition = newPosition;
	}

	@Override
	public int compareTo(Subcj o) {
		if(o.getCjtime()==null){
			return -1;
		}
		return o.getCjtime().compareTo(this.getCjtime());
	}

}