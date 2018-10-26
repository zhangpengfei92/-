package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SubServiceFee {
    private Integer id;

    private String subzh;

    private String agentphone;

    private BigDecimal feepoint;

    private BigDecimal feebalance;

    private BigDecimal warnbalance;

    private Integer status;

    private Date createtime;

    private Date modifytime;

    private String pagentzh;

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

    public String getAgentphone() {
        return agentphone;
    }

    public void setAgentphone(String agentphone) {
        this.agentphone = agentphone == null ? null : agentphone.trim();
    }

    public BigDecimal getFeepoint() {
        return feepoint;
    }

    public void setFeepoint(BigDecimal feepoint) {
        this.feepoint = feepoint;
    }

    public BigDecimal getFeebalance() {
        return feebalance;
    }

    public void setFeebalance(BigDecimal feebalance) {
        this.feebalance = feebalance;
    }

    public BigDecimal getWarnbalance() {
        return warnbalance;
    }

    public void setWarnbalance(BigDecimal warnbalance) {
        this.warnbalance = warnbalance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getPagentzh() {
        return pagentzh;
    }

    public void setPagentzh(String pagentzh) {
        this.pagentzh = pagentzh == null ? null : pagentzh.trim();
    }
}