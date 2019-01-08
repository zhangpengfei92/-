package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Feetemplate {
    private Integer id;

    private Integer sc;

    private String stockcode;

    private String stockname;

    private BigDecimal bbbz;

    private BigDecimal jgratio;

    private BigDecimal qdratio;

    private BigDecimal dlsratio;

    private BigDecimal jjrratio;

    private BigDecimal tldtbzj1;

    private BigDecimal tldtbzj2;

    private BigDecimal tlktbzj1;

    private BigDecimal tlktbzj2;

    private Integer sqfs;

    private Integer month;

    private Integer parentid;

    private Long userid;

    private String agentzh;

    private Date modifytime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSc() {
        return sc;
    }

    public void setSc(Integer sc) {
        this.sc = sc;
    }

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode == null ? null : stockcode.trim();
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname == null ? null : stockname.trim();
    }

    public BigDecimal getBbbz() {
        return bbbz;
    }

    public void setBbbz(BigDecimal bbbz) {
        this.bbbz = bbbz;
    }

    public BigDecimal getJgratio() {
        return jgratio;
    }

    public void setJgratio(BigDecimal jgratio) {
        this.jgratio = jgratio;
    }

    public BigDecimal getQdratio() {
        return qdratio;
    }

    public void setQdratio(BigDecimal qdratio) {
        this.qdratio = qdratio;
    }

    public BigDecimal getDlsratio() {
        return dlsratio;
    }

    public void setDlsratio(BigDecimal dlsratio) {
        this.dlsratio = dlsratio;
    }

    public BigDecimal getJjrratio() {
        return jjrratio;
    }

    public void setJjrratio(BigDecimal jjrratio) {
        this.jjrratio = jjrratio;
    }

    public BigDecimal getTldtbzj1() {
        return tldtbzj1;
    }

    public void setTldtbzj1(BigDecimal tldtbzj1) {
        this.tldtbzj1 = tldtbzj1;
    }

    public BigDecimal getTldtbzj2() {
        return tldtbzj2;
    }

    public void setTldtbzj2(BigDecimal tldtbzj2) {
        this.tldtbzj2 = tldtbzj2;
    }

    public BigDecimal getTlktbzj1() {
        return tlktbzj1;
    }

    public void setTlktbzj1(BigDecimal tlktbzj1) {
        this.tlktbzj1 = tlktbzj1;
    }

    public BigDecimal getTlktbzj2() {
        return tlktbzj2;
    }

    public void setTlktbzj2(BigDecimal tlktbzj2) {
        this.tlktbzj2 = tlktbzj2;
    }

    public Integer getSqfs() {
        return sqfs;
    }

    public void setSqfs(Integer sqfs) {
        this.sqfs = sqfs;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getAgentzh() {
        return agentzh;
    }

    public void setAgentzh(String agentzh) {
        this.agentzh = agentzh == null ? null : agentzh.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}