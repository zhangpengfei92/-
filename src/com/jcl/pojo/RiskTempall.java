package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class RiskTempall {
    private Integer id;

    private Integer newstock;//上海股指期货

    private Integer newstockDay;//上海商品

    private Integer rubbishstock;//大连商品

    private Integer businessplate;//郑州商品

    private Date modifytime;

    private String type;//方案名称

    private String agentzh;

    private Integer ineLimit;//原油   正在使用中

    private BigDecimal warningvalue;//预警阈值

    private BigDecimal closeoutvalue;//强平阈值

    private Integer crudeoil;//原油   暂未使用

    private BigDecimal closevalue;//收盘强平阈值

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewstock() {
        return newstock;
    }

    public void setNewstock(Integer newstock) {
        this.newstock = newstock;
    }

    public Integer getNewstockDay() {
        return newstockDay;
    }

    public void setNewstockDay(Integer newstockDay) {
        this.newstockDay = newstockDay;
    }

    public Integer getRubbishstock() {
        return rubbishstock;
    }

    public void setRubbishstock(Integer rubbishstock) {
        this.rubbishstock = rubbishstock;
    }

    public Integer getBusinessplate() {
        return businessplate;
    }

    public void setBusinessplate(Integer businessplate) {
        this.businessplate = businessplate;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAgentzh() {
        return agentzh;
    }

    public void setAgentzh(String agentzh) {
        this.agentzh = agentzh == null ? null : agentzh.trim();
    }

    public Integer getIneLimit() {
        return ineLimit;
    }

    public void setIneLimit(Integer ineLimit) {
        this.ineLimit = ineLimit;
    }

    public BigDecimal getWarningvalue() {
        return warningvalue;
    }

    public void setWarningvalue(BigDecimal warningvalue) {
        this.warningvalue = warningvalue;
    }

    public BigDecimal getCloseoutvalue() {
        return closeoutvalue;
    }

    public void setCloseoutvalue(BigDecimal closeoutvalue) {
        this.closeoutvalue = closeoutvalue;
    }

    public Integer getCrudeoil() {
        return crudeoil;
    }

    public void setCrudeoil(Integer crudeoil) {
        this.crudeoil = crudeoil;
    }

    public BigDecimal getClosevalue() {
        return closevalue;
    }

    public void setClosevalue(BigDecimal closevalue) {
        this.closevalue = closevalue;
    }
}