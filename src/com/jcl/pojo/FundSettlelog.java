package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class FundSettlelog {
    private Integer id;

    private String subzh;   // 用户账户

    private String allocbroker;     //代理商

    private String allocchannel;     //经纪人

    private String phone;     //手机号

    private String name;     //rb1901

    private Integer registnum;   //0

    private Integer addfund;    //0

    private BigDecimal addbalance;  //手续费

    private Integer stockfund;   //0

    private BigDecimal stockbalance;

    private BigDecimal feebalance;   //手数

    private BigDecimal deferredbalance;

    private BigDecimal feenextbalance;  //手粗费

    private BigDecimal overbalance;   //手续费

    private BigDecimal sumbalance;   //总手续费

    private String settledesc;        //螺纹1901

    private Date settletime;    //2018-11-29 00:00:00.000

    private Date createtime;   //2018-11-28 21:51:13.000

    private Integer fundtype;  //1

    private String agentzh;   //代理商
    
    private String flage;
    
    private String cmd;

    public String getFlage() {
    	if(this.getStockbalance() !=null){
    		if(this.getStockbalance().doubleValue()<0.1){
    			return "买入";
    		}else if(this.getStockbalance().doubleValue()>0.9){
    			return "卖出";
    		}
    	}
		return flage;
	}

	public void setFlage(String flage) {
		this.flage = flage;
	}

	public String getCmd() {
		if(this.getRegistnum()==0){
			return "开仓";
		}else if(this.getRegistnum()==1){
			return "平仓";
		}else if(this.getRegistnum()==2){
			return "平今";
		}else if(this.getRegistnum()==3){
			return "平昨";
		}
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubzh() {
        return subzh;
    }

    public void setSubzh(String subzh) {
        this.subzh = subzh == null ? null : subzh.trim();
    }

    public String getAllocbroker() {
        return allocbroker;
    }

    public void setAllocbroker(String allocbroker) {
        this.allocbroker = allocbroker == null ? null : allocbroker.trim();
    }

    public String getAllocchannel() {
        return allocchannel;
    }

    public void setAllocchannel(String allocchannel) {
        this.allocchannel = allocchannel == null ? null : allocchannel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRegistnum() {
        return registnum;
    }

    public void setRegistnum(Integer registnum) {
        this.registnum = registnum;
    }

    public Integer getAddfund() {
        return addfund;
    }

    public void setAddfund(Integer addfund) {
        this.addfund = addfund;
    }

    public BigDecimal getAddbalance() {
        return addbalance;
    }

    public void setAddbalance(BigDecimal addbalance) {
        this.addbalance = addbalance;
    }

    public Integer getStockfund() {
        return stockfund;
    }

    public void setStockfund(Integer stockfund) {
        this.stockfund = stockfund;
    }

    public BigDecimal getStockbalance() {
        return stockbalance;
    }

    public void setStockbalance(BigDecimal stockbalance) {
        this.stockbalance = stockbalance;
    }

    public BigDecimal getFeebalance() {
        return feebalance;
    }

    public void setFeebalance(BigDecimal feebalance) {
        this.feebalance = feebalance;
    }

    public BigDecimal getDeferredbalance() {
        return deferredbalance;
    }

    public void setDeferredbalance(BigDecimal deferredbalance) {
        this.deferredbalance = deferredbalance;
    }

    public BigDecimal getFeenextbalance() {
        return feenextbalance;
    }

    public void setFeenextbalance(BigDecimal feenextbalance) {
        this.feenextbalance = feenextbalance;
    }

    public BigDecimal getOverbalance() {
        return overbalance;
    }

    public void setOverbalance(BigDecimal overbalance) {
        this.overbalance = overbalance;
    }

    public BigDecimal getSumbalance() {
        return sumbalance;
    }

    public void setSumbalance(BigDecimal sumbalance) {
        this.sumbalance = sumbalance;
    }

    public String getSettledesc() {
        return settledesc;
    }

    public void setSettledesc(String settledesc) {
        this.settledesc = settledesc == null ? null : settledesc.trim();
    }

    public Date getSettletime() {
        return settletime;
    }

    public void setSettletime(Date settletime) {
        this.settletime = settletime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFundtype() {
        return fundtype;
    }

    public void setFundtype(Integer fundtype) {
        this.fundtype = fundtype;
    }

    public String getAgentzh() {
        return agentzh;
    }

    public void setAgentzh(String agentzh) {
        this.agentzh = agentzh == null ? null : agentzh.trim();
    }
}