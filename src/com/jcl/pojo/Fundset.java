package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Fundset {
    private Integer id;

    private Integer fundtype;

    private Integer setpro;

    private BigDecimal servicebalance;

    private BigDecimal yjxbalance;

    private BigDecimal pcxbalance;

    private String setdesc;

    private Date createtime;

    private String agentzh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFundtype() {
        return fundtype;
    }

    public void setFundtype(Integer fundtype) {
        this.fundtype = fundtype;
    }

    public Integer getSetpro() {
        return setpro;
    }

    public void setSetpro(Integer setpro) {
        this.setpro = setpro;
    }

    public BigDecimal getServicebalance() {
        return servicebalance;
    }

    public void setServicebalance(BigDecimal servicebalance) {
        this.servicebalance = servicebalance;
    }

    public BigDecimal getYjxbalance() {
        return yjxbalance;
    }

    public void setYjxbalance(BigDecimal yjxbalance) {
        this.yjxbalance = yjxbalance;
    }

    public BigDecimal getPcxbalance() {
        return pcxbalance;
    }

    public void setPcxbalance(BigDecimal pcxbalance) {
        this.pcxbalance = pcxbalance;
    }

    public String getSetdesc() {
        return setdesc;
    }

    public void setSetdesc(String setdesc) {
        this.setdesc = setdesc == null ? null : setdesc.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAgentzh() {
        return agentzh;
    }

    public void setAgentzh(String agentzh) {
        this.agentzh = agentzh == null ? null : agentzh.trim();
    }
}