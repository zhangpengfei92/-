package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Fundset {
    private Integer id;

    private Integer pcswitch;

    private Integer appswitch;

    private double czcost;

    private double txcost;

    private BigDecimal minmoney;

    private BigDecimal maxmoney;

    private String starttime;

    private String endtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPcswitch() {
        return pcswitch;
    }

    public void setPcswitch(Integer pcswitch) {
        this.pcswitch = pcswitch;
    }

    public Integer getAppswitch() {
        return appswitch;
    }

    public void setAppswitch(Integer appswitch) {
        this.appswitch = appswitch;
    }

    public double getCzcost() {
		return czcost;
	}

	public void setCzcost(double czcost) {
		this.czcost = czcost;
	}

	public double getTxcost() {
		return txcost;
	}

	public void setTxcost(double txcost) {
		this.txcost = txcost;
	}

	public BigDecimal getMinmoney() {
        return minmoney;
    }

    public void setMinmoney(BigDecimal minmoney) {
        this.minmoney = minmoney;
    }

    public BigDecimal getMaxmoney() {
        return maxmoney;
    }

    public void setMaxmoney(BigDecimal maxmoney) {
        this.maxmoney = maxmoney;
    }

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}