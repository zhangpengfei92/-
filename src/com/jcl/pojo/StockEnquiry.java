package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class StockEnquiry {
    private Integer id;

    private String subzh;

    private String stockcode;

    private String stockname;

    private String type;

    private Integer enquirytime;

    private BigDecimal principalbalance;

    private BigDecimal principalfloat;

    private BigDecimal royaltybalance;

    private BigDecimal enquiryprice;

    private BigDecimal settleprice;

    private Integer status;

    private Date starttime;

    private Date endtime;

    private Date createtime;

    private Date buytime;

    private String enquirydesc;

    private Integer setfee;

    private String orgincode;

    private String orginname;

    private String agent;

    private String phone;

    private String ditch;

    private String agentid;

    private String ditchid;

    private BigDecimal orginfloat;

    private Integer issell;

    private BigDecimal profit;

    private BigDecimal freeprice;

    private Integer timefly;

    private BigDecimal cyclefloat;

    private BigDecimal mybjfloat;

    private BigDecimal agentf;

    private BigDecimal orginf;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getEnquirytime() {
        return enquirytime;
    }

    public void setEnquirytime(Integer enquirytime) {
        this.enquirytime = enquirytime;
    }

    public BigDecimal getPrincipalbalance() {
        return principalbalance;
    }

    public void setPrincipalbalance(BigDecimal principalbalance) {
        this.principalbalance = principalbalance;
    }

    public BigDecimal getPrincipalfloat() {
        return principalfloat;
    }

    public void setPrincipalfloat(BigDecimal principalfloat) {
        this.principalfloat = principalfloat;
    }

    public BigDecimal getRoyaltybalance() {
        return royaltybalance;
    }

    public void setRoyaltybalance(BigDecimal royaltybalance) {
        this.royaltybalance = royaltybalance;
    }

    public BigDecimal getEnquiryprice() {
        return enquiryprice;
    }

    public void setEnquiryprice(BigDecimal enquiryprice) {
        this.enquiryprice = enquiryprice;
    }

    public BigDecimal getSettleprice() {
        return settleprice;
    }

    public void setSettleprice(BigDecimal settleprice) {
        this.settleprice = settleprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public String getEnquirydesc() {
        return enquirydesc;
    }

    public void setEnquirydesc(String enquirydesc) {
        this.enquirydesc = enquirydesc == null ? null : enquirydesc.trim();
    }

    public Integer getSetfee() {
        return setfee;
    }

    public void setSetfee(Integer setfee) {
        this.setfee = setfee;
    }

    public String getOrgincode() {
        return orgincode;
    }

    public void setOrgincode(String orgincode) {
        this.orgincode = orgincode == null ? null : orgincode.trim();
    }

    public String getOrginname() {
        return orginname;
    }

    public void setOrginname(String orginname) {
        this.orginname = orginname == null ? null : orginname.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDitch() {
        return ditch;
    }

    public void setDitch(String ditch) {
        this.ditch = ditch == null ? null : ditch.trim();
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getDitchid() {
        return ditchid;
    }

    public void setDitchid(String ditchid) {
        this.ditchid = ditchid == null ? null : ditchid.trim();
    }

    public BigDecimal getOrginfloat() {
        return orginfloat;
    }

    public void setOrginfloat(BigDecimal orginfloat) {
        this.orginfloat = orginfloat;
    }

    public Integer getIssell() {
        return issell;
    }

    public void setIssell(Integer issell) {
        this.issell = issell;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getFreeprice() {
        return freeprice;
    }

    public void setFreeprice(BigDecimal freeprice) {
        this.freeprice = freeprice;
    }

    public Integer getTimefly() {
        return timefly;
    }

    public void setTimefly(Integer timefly) {
        this.timefly = timefly;
    }

    public BigDecimal getCyclefloat() {
        return cyclefloat;
    }

    public void setCyclefloat(BigDecimal cyclefloat) {
        this.cyclefloat = cyclefloat;
    }

    public BigDecimal getMybjfloat() {
        return mybjfloat;
    }

    public void setMybjfloat(BigDecimal mybjfloat) {
        this.mybjfloat = mybjfloat;
    }

    public BigDecimal getAgentf() {
        return agentf;
    }

    public void setAgentf(BigDecimal agentf) {
        this.agentf = agentf;
    }

    public BigDecimal getOrginf() {
        return orginf;
    }

    public void setOrginf(BigDecimal orginf) {
        this.orginf = orginf;
    }
}