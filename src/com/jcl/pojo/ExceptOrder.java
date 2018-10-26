package com.jcl.pojo;

import java.util.Date;

public class ExceptOrder {
    private Long id;

    private String userId;//对应子账号  sub_zh

    private String mainzh;//对应报单主账号 main_zh

    private Byte market;//对应交易市场  mark

    private String hycode;//对应合约代码 code

    private String hypz;//对应合约  name

    private Byte direction;//对应买卖方向   order_bs

    private Integer vol;//对应委托数量order_vol

    private Double price;//对应委托价格  order_price

    private Date orderTime;//

    private String reason;//

    private Long userid;//

    private String agentzh;//对应代理商，agent
    
    //委托编号 order_id,order_type,order_direction开平，  order_date,order_time
    private String fangx;//方向
    private String exchange;//市场
    private String entrusttime;//时间
    private String orderDirec;//开平方向

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMainzh() {
        return mainzh;
    }

    public void setMainzh(String mainzh) {
        this.mainzh = mainzh == null ? null : mainzh.trim();
    }

    public Byte getMarket() {
        return market;
    }

    public void setMarket(Byte market) {
        this.market = market;
    }

    public String getHycode() {
        return hycode;
    }

    public void setHycode(String hycode) {
        this.hycode = hycode == null ? null : hycode.trim();
    }

    public String getHypz() {
        return hypz;
    }

    public void setHypz(String hypz) {
        this.hypz = hypz == null ? null : hypz.trim();
    }

    public Byte getDirection() {
        return direction;
    }

    public void setDirection(Byte direction) {
        this.direction = direction;
    }

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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

	public String getFangx() {
		return fangx;
	}

	public void setFangx(String fangx) {
		this.fangx = fangx;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getEntrusttime() {
		return entrusttime;
	}

	public void setEntrusttime(String entrusttime) {
		this.entrusttime = entrusttime;
	}

	public String getOrderDirec() {
		return orderDirec;
	}

	public void setOrderDirec(String orderDirec) {
		this.orderDirec = orderDirec;
	}
    
    
}