package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class AgentzhfundLog {
    private Integer id;

    private String subzh;

    private String name;//持仓 人名称
    
	private String type;//各种支付对应的名称（如ALIPAY，WEIXIN，。。。。）

    private Byte bz;//1充值，2提现

    private BigDecimal fund;//金额
    
    /*状态  充值时 0:预支付 申请状态 1：成功 ，2处理中，3失败   
    * 	  *状态  4提现申请 5：审核通过 6审核拒绝 7提现成功 8提现失败*/
    private Integer status;

    private BigDecimal afterfund;

    private String description;
    
    private String province;//开户所在省
	private String city;//开户所在市
	private String banchname;//开户分行名称
	private String bankname;//银行名称
	/*更新时间*/
	private Date modifytime;
	private String orderno;//金策略生成的
	private String accNo;//平台生成的编号 
	private Date createtime;//创建时间
	
	//扩展提现时需要字段，未与数据库对应
	private String bankcode;//银行卡编号
	
	private String bankCardNumber;//银行卡号
		
	private String idcard;//身份证
	
	private String phoneNum;//预留手机号
	
	private String amount;//提现时输入的资金
	
	private String cmd;
	//状态
	private String accountType;
	
	private String allocbroker;/* 被分配的经纪人 */
	private String allocchannel;/* 被分配的渠道*/
	private String allocagent;//分配的代理商，（在渠道和经纪人之间）
	
	private String bankID;
	
    public String getBankID() {
    	if(description !=null){
    		Map map = JSON.parseObject(this.getDescription(), Map.class);
    		return String.valueOf(map.get("bankCardNumber"));
    	}
		return "";
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getAllocbroker() {
		return allocbroker;
	}

	public void setAllocbroker(String allocbroker) {
		this.allocbroker = allocbroker;
	}

	public String getAllocchannel() {
		return allocchannel;
	}

	public void setAllocchannel(String allocchannel) {
		this.allocchannel = allocchannel;
	}

	public String getAllocagent() {
		return allocagent;
	}

	public void setAllocagent(String allocagent) {
		this.allocagent = allocagent;
	}

	public String getCmd() {
		return "提现";
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getAccountType() {
	
		if(null!=this.getStatus()){
		if(this.getStatus()==4){
			return "提现申请";
		}else if(this.getStatus()==5){
			return "通过";
		}else if(this.getStatus()==6){
			return "拒绝";
		}else if(this.getStatus()==7){
			return "提现成功";
		}else if(this.getStatus()==8){
			return "提现失败";
		}else if(this.getStatus()==11){
			return "调账出金失败";
		}else if(this.getStatus()==9){
			return "调账出金成功";
		}
		
		}
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

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

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAfterfund() {
        return afterfund;
    }

    public void setAfterfund(BigDecimal afterfund) {
        this.afterfund = afterfund;
    }
    
    public String getBanchname() {
		return banchname;
	}

	public void setBanchname(String banchname) {
		this.banchname = banchname;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
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


	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
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

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	} 
}