package com.jcl.pojo;

import java.math.BigDecimal;

public class FeeScheme {
	/*主键*/
    private Integer lsh;
    /*收费方案类型,1经纪商交易佣金,2印花税,3过户费*/
    private Byte schemetype;
    /*收费方向 1卖，0买*/
    private String direction;
    /*收费比例*/
    private BigDecimal percentage;
    /*最低收费*/
    private BigDecimal lowfee;
    /*方案名称*/
    private String schemename;
    /*显示状态，1显示，0不显示*/
    private Byte showstatus;
    /*关联收费方案*/
    private Integer feeschemeid;

    public Integer getLsh() {
        return lsh;
    }

    public void setLsh(Integer lsh) {
        this.lsh = lsh;
    }

    public Byte getSchemetype() {
        return schemetype;
    }

    public void setSchemetype(Byte schemetype) {
        this.schemetype = schemetype;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getLowfee() {
        return lowfee;
    }

    public void setLowfee(BigDecimal lowfee) {
        this.lowfee = lowfee;
    }

    public String getSchemename() {
        return schemename;
    }

    public void setSchemename(String schemename) {
        this.schemename = schemename == null ? null : schemename.trim();
    }

    public Byte getShowstatus() {
        return showstatus;
    }

    public void setShowstatus(Byte showstatus) {
        this.showstatus = showstatus;
    }

    public Integer getFeeschemeid() {
        return feeschemeid;
    }

    public void setFeeschemeid(Integer feeschemeid) {
        this.feeschemeid = feeschemeid;
    }
}