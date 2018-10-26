package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SubzhFundLog {
    private Integer id;

    private String subzh;

    private String name;

    private String type;

    private Byte bz;

    private BigDecimal fund;

    private BigDecimal afterfund;

    private Date modifytime;

    private Byte status;

    private Long userid;

    private String agentzh;

    private String reason;

    private String bankaccname;//银行名称

    private String bankcardnum;//卡号

    private String openbankname;//开户行名称

    private String bankflownum;//存订单号

    private String description;
    
    private String province;//开户所在省
  	private String city;//开户所在市

  	
  	//扩展提现时需要字段，未与数据库对应
  	private String bankcode;//银行卡编号
  		
  	private String idcard;//身份证
  	
  	private String phoneNum;//预留手机号
  	
  	private String amount;//提现时输入的资金
    

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Byte getBz() {
        return bz;
    }

    public void setBz(Byte bz) {
        this.bz = bz;
    }

    public BigDecimal getFund() {
        return fund;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public BigDecimal getAfterfund() {
        return afterfund;
    }

    public void setAfterfund(BigDecimal afterfund) {
        this.afterfund = afterfund;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getBankaccname() {
        return bankaccname;
    }

    public void setBankaccname(String bankaccname) {
        this.bankaccname = bankaccname == null ? null : bankaccname.trim();
    }

    public String getBankcardnum() {
        return bankcardnum;
    }

    public void setBankcardnum(String bankcardnum) {
        this.bankcardnum = bankcardnum == null ? null : bankcardnum.trim();
    }

    public String getOpenbankname() {
        return openbankname;
    }

    public void setOpenbankname(String openbankname) {
        this.openbankname = openbankname == null ? null : openbankname.trim();
    }

    public String getBankflownum() {
        return bankflownum;
    }

    public void setBankflownum(String bankflownum) {
        this.bankflownum = bankflownum == null ? null : bankflownum.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}