package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class FundSettlelog {
    private Integer id;

    private String subzh;

    private String allocbroker;

    private String allocchannel;

    private String phone;

    private String name;

    private Integer registnum;

    private Integer addfund;

    private BigDecimal addbalance;//代理商手续费

    private Integer stockfund;

    private BigDecimal stockbalance;

    private BigDecimal feebalance;//手数

    private BigDecimal deferredbalance;

    private BigDecimal feenextbalance;//渠道手续费

    private BigDecimal overbalance;//经纪人手续费

    private BigDecimal sumbalance;//手续费总额汇总

    private String settledesc;

    private Date settletime;

    private Date createtime;

    private Integer fundtype;

    private String agentzh;
    
    private String flage;
    
    private String cmd;
    
    private Double sumaddbalance;//代理商手续费汇总
    
    private Double sumfeenextbalance;//渠道手续费汇总

    private Double sumoverbalance;//经纪人手续费汇总
    
    private Double summoney;//手续费总额汇总
    
    

	public Double getSumaddbalance() {
		return sumaddbalance;
	}

	public void setSumaddbalance(Double sumaddbalance) {
		this.sumaddbalance = sumaddbalance;
	}

	public Double getSumfeenextbalance() {
		return sumfeenextbalance;
	}

	public void setSumfeenextbalance(Double sumfeenextbalance) {
		this.sumfeenextbalance = sumfeenextbalance;
	}

	public Double getSumoverbalance() {
		return sumoverbalance;
	}

	public void setSumoverbalance(Double sumoverbalance) {
		this.sumoverbalance = sumoverbalance;
	}

	public Double getSummoney() {
		return summoney;
	}

	public void setSummoney(Double summoney) {
		this.summoney = summoney;
	}

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