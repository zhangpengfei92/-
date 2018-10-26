package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Spt {
    private String merch;

    private String state;

    private String subzh;

    private Date time;

    private BigDecimal coin;

    private String settleno;

    public String getMerch() {
        return merch;
    }

    public void setMerch(String merch) {
        this.merch = merch == null ? null : merch.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getSubzh() {
        return subzh;
    }

    public void setSubzh(String subzh) {
        this.subzh = subzh == null ? null : subzh.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getCoin() {
        return coin;
    }

    public void setCoin(BigDecimal coin) {
        this.coin = coin;
    }

    public String getSettleno() {
        return settleno;
    }

    public void setSettleno(String settleno) {
        this.settleno = settleno == null ? null : settleno.trim();
    }
}