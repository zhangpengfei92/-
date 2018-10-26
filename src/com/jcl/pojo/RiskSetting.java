package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class RiskSetting {
    private Integer rid;

    private BigDecimal principalMin;

    private BigDecimal principalMax;

    private Double limitscope;

    private Double upScopeMax;

    private Double downScopeMax;

    private BigDecimal totalMax;

    private Integer doubbo;

    private Integer lessday;

    private BigDecimal singleTotalMax;

    private String defaultPrincipal;

    private Integer mon;

    private Integer tue;

    private Integer wed;

    private Integer thursday;

    private Integer fri;

    private String state;

    private String name;

    private Date createTime;

    private String cycleMin;

    private String cycleMinType;

    private String cycleMax;

    private String cycleMaxType;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public BigDecimal getPrincipalMin() {
        return principalMin;
    }

    public void setPrincipalMin(BigDecimal principalMin) {
        this.principalMin = principalMin;
    }

    public BigDecimal getPrincipalMax() {
        return principalMax;
    }

    public void setPrincipalMax(BigDecimal principalMax) {
        this.principalMax = principalMax;
    }

    public Double getLimitscope() {
        return limitscope;
    }

    public void setLimitscope(Double limitscope) {
        this.limitscope = limitscope;
    }

    public Double getUpScopeMax() {
        return upScopeMax;
    }

    public void setUpScopeMax(Double upScopeMax) {
        this.upScopeMax = upScopeMax;
    }

    public Double getDownScopeMax() {
        return downScopeMax;
    }

    public void setDownScopeMax(Double downScopeMax) {
        this.downScopeMax = downScopeMax;
    }

    public BigDecimal getTotalMax() {
        return totalMax;
    }

    public void setTotalMax(BigDecimal totalMax) {
        this.totalMax = totalMax;
    }

    public Integer getDoubbo() {
        return doubbo;
    }

    public void setDoubbo(Integer doubbo) {
        this.doubbo = doubbo;
    }

    public Integer getLessday() {
        return lessday;
    }

    public void setLessday(Integer lessday) {
        this.lessday = lessday;
    }

    public BigDecimal getSingleTotalMax() {
        return singleTotalMax;
    }

    public void setSingleTotalMax(BigDecimal singleTotalMax) {
        this.singleTotalMax = singleTotalMax;
    }

    public String getDefaultPrincipal() {
        return defaultPrincipal;
    }

    public void setDefaultPrincipal(String defaultPrincipal) {
        this.defaultPrincipal = defaultPrincipal == null ? null : defaultPrincipal.trim();
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public Integer getTue() {
        return tue;
    }

    public void setTue(Integer tue) {
        this.tue = tue;
    }

    public Integer getWed() {
        return wed;
    }

    public void setWed(Integer wed) {
        this.wed = wed;
    }

    public Integer getThursday() {
        return thursday;
    }

    public void setThursday(Integer thursday) {
        this.thursday = thursday;
    }

    public Integer getFri() {
        return fri;
    }

    public void setFri(Integer fri) {
        this.fri = fri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCycleMin() {
        return cycleMin;
    }

    public void setCycleMin(String cycleMin) {
        this.cycleMin = cycleMin == null ? null : cycleMin.trim();
    }

    public String getCycleMinType() {
        return cycleMinType;
    }

    public void setCycleMinType(String cycleMinType) {
        this.cycleMinType = cycleMinType == null ? null : cycleMinType.trim();
    }

    public String getCycleMax() {
        return cycleMax;
    }

    public void setCycleMax(String cycleMax) {
        this.cycleMax = cycleMax == null ? null : cycleMax.trim();
    }

    public String getCycleMaxType() {
        return cycleMaxType;
    }

    public void setCycleMaxType(String cycleMaxType) {
        this.cycleMaxType = cycleMaxType == null ? null : cycleMaxType.trim();
    }
}