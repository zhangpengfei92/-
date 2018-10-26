package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SubFeelog {
    private Integer id;

    private String subzh;

    private BigDecimal nowbalance;

    private BigDecimal addbalance;

    private Date createtime;

    private Integer feetype;

    private String feedesc;

    private Integer enquiryid;

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

    public BigDecimal getNowbalance() {
        return nowbalance;
    }

    public void setNowbalance(BigDecimal nowbalance) {
        this.nowbalance = nowbalance;
    }

    public BigDecimal getAddbalance() {
        return addbalance;
    }

    public void setAddbalance(BigDecimal addbalance) {
        this.addbalance = addbalance;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFeetype() {
        return feetype;
    }

    public void setFeetype(Integer feetype) {
        this.feetype = feetype;
    }

    public String getFeedesc() {
        return feedesc;
    }

    public void setFeedesc(String feedesc) {
        this.feedesc = feedesc == null ? null : feedesc.trim();
    }

    public Integer getEnquiryid() {
        return enquiryid;
    }

    public void setEnquiryid(Integer enquiryid) {
        this.enquiryid = enquiryid;
    }
}