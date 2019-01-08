package com.jcl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.jcl.vo.MsCodeResult;

public class RiskContract implements Serializable, Comparable<RiskContract>{
    private String contractCode;/*合约代码*/

    private String varietyCode;

    private String contractName;/*合约名称*/

    private BigDecimal minchangeprice;/*最小变动价位*/

    private Date publicDay;

    private Date promptDay;

    private String exchangeName; /*交易所名称*/

    private BigDecimal contractdetail;/*合约乘数*/

    private String unit;//币种
    
    private String market;//

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public String getVarietyCode() {
        return varietyCode;
    }

    public void setVarietyCode(String varietyCode) {
        this.varietyCode = varietyCode == null ? null : varietyCode.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public BigDecimal getMinchangeprice() {
        return minchangeprice;
    }

    public void setMinchangeprice(BigDecimal minchangeprice) {
        this.minchangeprice = minchangeprice;
    }

    public Date getPublicDay() {
        return publicDay;
    }

    public void setPublicDay(Date publicDay) {
        this.publicDay = publicDay;
    }

    public Date getPromptDay() {
        return promptDay;
    }

    public void setPromptDay(Date promptDay) {
        this.promptDay = promptDay;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName == null ? null : exchangeName.trim();
    }

    public BigDecimal getContractdetail() {
        return contractdetail;
    }

    public void setContractdetail(BigDecimal contractdetail) {
        this.contractdetail = contractdetail;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
    
    
    public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	@Override
	public int compareTo(RiskContract o) {
		//return this.getMarket().compareTo(o.getMarket());
		return this.getContractName().compareTo(o.getContractName());
	}
}