package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Subzh extends SubzhKey {
	
	private Integer id;
	
    private String password;//登录密码
    private String name;//开户姓名

    private String pagentzh;//
    private Integer isDelete;//0正常状态，1删除状态

    private String phone;//登录手机号

    private Date khdate;//开户时间

    private String marginset;//保证金方案

    private String feeset;//收费方案

    private Integer riskset;//风控方案

    private Integer openright;//开仓权限

    private Integer accounttype;//账户类型

    private String qq;//qq存在速期项目中，它存放开户行

    private String mail;//邮箱

    private BigDecimal initmoney;//初始资金

    private String address;//地址

    private String note;//备注

    private String bz;//币种

    private Long userid;//用户id

    private String headpicture;//头像

    private String loginname;//登录名称

    private String notetel;//备注电话

    private Integer risktype;//手续费分成方案  

    private Integer accountpattern;//账户模式  0:分账户    2:独立账户

    private Integer zijinaccount;//资金账户   1:在岸人民币账户  2：美元账户   3：港币账户  4：离岸人民币账户

    private String jypz;//交易品种   1：原油期货

    private String bdtd;//保单通道  报单账户或者报单账户组

    private BigDecimal bzj;// 保证金    劣后

    private BigDecimal rzj;// 融资金额    优先*/

    private BigDecimal yjx;//预警线

    private BigDecimal pcx;//平仓线

    private BigDecimal xzj;//限制可用金额

    private Integer ccbl;//持仓比例    0:全局设置   1：单独设置

    private Integer isadmin;//1机构，2平台，3渠道，4代理商，5经纪人，6普通用户

    private String jyright;//交易状态  1：禁止开仓   2：竞争平仓 3：竞争撤单

    private Integer riskstate; //风控状态   0：正常   1：预警   2：强平   3：冻结

    private Integer mncj;//开通模拟成交    1：是  其他 ：否

    private String riskholderid;/* 子账户持仓比例单独设置   对应risk_holder表主键ID  */

    private BigDecimal totalDefer;/* 递延费  */

    private BigDecimal fundbalance;/* 账户资产即可提现资金  首次通过充值  */

    private Integer zhstate;/* 账户状态  0：未激活  1：正常（可交易）  2：申请清算*/

    private String allocbroker;/* 被分配的经纪人 */
    private String allocchannel;/* 被分配的渠道*/

    private String schemename;//扩展收费方案名称
    
    private String accountid;//扩展主账户账户
    
    private String type;//扩展风控方案名称
    
    private List<Role> roleList; //角色
    
    private String allocagent;//分配的代理商，（在渠道和经纪人之间）
    private String allocpt;//用户所在平台
    private String manage;//用户所在机构
    private BigDecimal coefficient;//分成系数

    private String brokername;/* 被分配的经纪人  这不会在数据库中显示*/
    private String channelname;/* 被分配的渠道  这不会在数据库中显示*/
    private String marginName;//保证金方案
    private String feeName;//收费方案
    private String riskName;//风控方案
    private String bdtdName;//保单通道  报单账户或者报单账户组
    private String agentname;//代理商名字
    private String feetemplatename;// 手续费分成方案名字
    
    
    public String getFeetemplatename() {
		return feetemplatename;
	}
	public void setFeetemplatename(String feetemplatename) {
		this.feetemplatename = feetemplatename;
	}
	private String bank;//银行名称
    private String bankCard;//银行卡号
    private String idNo;//证件号码 
    private String frontPic;//身份证正面
    private String backPic;//身份证背面
    private String cardPic;//银行卡照片
    private Integer authState;//0未实名认证 1审核中 2已通过 3不通过
    private String inviteCode;//邀请码
	
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getSchemename() {
		return schemename;
	}

	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getKhdate() {
        return khdate;
    }

    public void setKhdate(Date khdate) {
        this.khdate = khdate;
    }

    public String getMarginset() {
        return marginset;
    }

    public void setMarginset(String marginset) {
        this.marginset = marginset == null ? null : marginset.trim();
    }

    public String getFeeset() {
        return feeset;
    }

    public void setFeeset(String feeset) {
        this.feeset = feeset == null ? null : feeset.trim();
    }

    public Integer getRiskset() {
        return riskset;
    }

    public void setRiskset(Integer riskset) {
        this.riskset = riskset;
    }

    public Integer getOpenright() {
        return openright;
    }

    public void setOpenright(Integer openright) {
        this.openright = openright;
    }

    public Integer getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public BigDecimal getInitmoney() {
        return initmoney;
    }

    public void setInitmoney(BigDecimal initmoney) {
        this.initmoney = initmoney;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getHeadpicture() {
        return headpicture;
    }

    public void setHeadpicture(String headpicture) {
        this.headpicture = headpicture == null ? null : headpicture.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }


    public String getNotetel() {
        return notetel;
    }

    public void setNotetel(String notetel) {
        this.notetel = notetel == null ? null : notetel.trim();
    }

    public Integer getRisktype() {
        return risktype;
    }

    public void setRisktype(Integer risktype) {
        this.risktype = risktype;
    }

    public Integer getAccountpattern() {
        return accountpattern;
    }

    public void setAccountpattern(Integer accountpattern) {
        this.accountpattern = accountpattern;
    }

    public Integer getZijinaccount() {
        return zijinaccount;
    }

    public void setZijinaccount(Integer zijinaccount) {
        this.zijinaccount = zijinaccount;
    }

    public String getJypz() {
        return jypz;
    }

    public void setJypz(String jypz) {
        this.jypz = jypz;
    }

    public String getBdtd() {
        return bdtd;
    }

    public void setBdtd(String bdtd) {
        this.bdtd = bdtd == null ? null : bdtd.trim();
    }

    public BigDecimal getBzj() {
        return bzj;
    }

    public void setBzj(BigDecimal bzj) {
        this.bzj = bzj;
    }

    public BigDecimal getRzj() {
        return rzj;
    }

    public void setRzj(BigDecimal rzj) {
        this.rzj = rzj;
    }

    public BigDecimal getYjx() {
        return yjx;
    }

    public void setYjx(BigDecimal yjx) {
        this.yjx = yjx;
    }

    public BigDecimal getPcx() {
        return pcx;
    }

    public void setPcx(BigDecimal pcx) {
        this.pcx = pcx;
    }

    public BigDecimal getXzj() {
        return xzj;
    }

    public void setXzj(BigDecimal xzj) {
        this.xzj = xzj;
    }

    public Integer getCcbl() {
        return ccbl;
    }

    public void setCcbl(Integer ccbl) {
        this.ccbl = ccbl;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public String getJyright() {
        return jyright;
    }

    public void setJyright(String jyright) {
        this.jyright = jyright == null ? null : jyright.trim();
    }

    public Integer getRiskstate() {
        return riskstate;
    }

    public void setRiskstate(Integer riskstate) {
        this.riskstate = riskstate;
    }

    public Integer getMncj() {
        return mncj;
    }

    public void setMncj(Integer mncj) {
        this.mncj = mncj;
    }

    public String getRiskholderid() {
        return riskholderid;
    }

    public void setRiskholderid(String riskholderid) {
        this.riskholderid = riskholderid == null ? null : riskholderid.trim();
    }

    public BigDecimal getTotalDefer() {
        return totalDefer;
    }

    public void setTotalDefer(BigDecimal totalDefer) {
        this.totalDefer = totalDefer;
    }


    public BigDecimal getFundbalance() {
        return fundbalance;
    }

    public void setFundbalance(BigDecimal fundbalance) {
        this.fundbalance = fundbalance;
    }

    public Integer getZhstate() {
        return zhstate;
    }

    public void setZhstate(Integer zhstate) {
        this.zhstate = zhstate;
    }

    public String getAllocbroker() {
        return allocbroker;
    }

    public void setAllocbroker(String allocbroker) {
        this.allocbroker = allocbroker == null ? null : allocbroker.trim();
    }

    public String getAllocchannel() {
        return allocchannel;
    }

    public void setAllocchannel(String allocchannel) {
        this.allocchannel = allocchannel == null ? null : allocchannel.trim();
    }

	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}

	public BigDecimal getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(BigDecimal coefficient) {
		this.coefficient = coefficient;
	}

	public String getBrokername() {
		return brokername;
	}

	public void setBrokername(String brokername) {
		this.brokername = brokername;
	}

	public String getChannelname() {
		return channelname;
	}
	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}

	public String getMarginName() {
		return marginName;
	}

	public void setMarginName(String marginName) {
		this.marginName = marginName;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getBdtdName() {
		return bdtdName;
	}

	public void setBdtdName(String bdtdName) {
		this.bdtdName = bdtdName;
	}

	public String getPagentzh() {
		return pagentzh;
	}
	public void setPagentzh(String pagentzh) {
		this.pagentzh = pagentzh;
	}

	public String getAllocagent() {
		return allocagent;
	}
	public void setAllocagent(String allocagent) {
		this.allocagent = allocagent;
	}

	public String getAllocpt() {
		return allocpt;
	}
	public void setAllocpt(String allocpt) {
		this.allocpt = allocpt;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getBankCard() {
        return bankCard;
    }
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }
    public String getIdNo() {
        return idNo;
    }
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    public String getFrontPic() {
        return frontPic;
    }
    public void setFrontPic(String frontPic) {
        this.frontPic = frontPic;
    }
    public String getBackPic() {
        return backPic;
    }
    public void setBackPic(String backPic) {
        this.backPic = backPic;
    }
    public String getCardPic() {
        return cardPic;
    }
    public void setCardPic(String cardPic) {
        this.cardPic = cardPic;
    }
    public Integer getAuthState() {
        return authState;
    }
    public void setAuthState(Integer authState) {
        this.authState = authState;
    }
    public String getInviteCode() {
        return inviteCode;
    }
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
	@Override
	public String toString() {
		return "Subzh [id=" + id + ", password=" + password + ", name=" + name + ", pagentzh=" + pagentzh
				+ ", isDelete=" + isDelete + ", phone=" + phone + ", khdate=" + khdate + ", marginset=" + marginset
				+ ", feeset=" + feeset + ", riskset=" + riskset + ", openright=" + openright + ", accounttype="
				+ accounttype + ", qq=" + qq + ", mail=" + mail + ", initmoney=" + initmoney + ", address=" + address
				+ ", note=" + note + ", bz=" + bz + ", userid=" + userid + ", headpicture=" + headpicture
				+ ", loginname=" + loginname + ", notetel=" + notetel + ", risktype=" + risktype + ", accountpattern="
				+ accountpattern + ", zijinaccount=" + zijinaccount + ", jypz=" + jypz + ", bdtd=" + bdtd + ", bzj="
				+ bzj + ", rzj=" + rzj + ", yjx=" + yjx + ", pcx=" + pcx + ", xzj=" + xzj + ", ccbl=" + ccbl
				+ ", isadmin=" + isadmin + ", jyright=" + jyright + ", riskstate=" + riskstate + ", mncj=" + mncj
				+ ", riskholderid=" + riskholderid + ", totalDefer=" + totalDefer + ", fundbalance=" + fundbalance
				+ ", zhstate=" + zhstate + ", allocbroker=" + allocbroker + ", allocchannel=" + allocchannel
				+ ", schemename=" + schemename + ", accountid=" + accountid + ", type=" + type + ", roleList="
				+ roleList + ", allocagent=" + allocagent + ", allocpt=" + allocpt + ", manage=" + manage
				+ ", coefficient=" + coefficient + ", brokername=" + brokername + ", channelname=" + channelname
				+ ", marginName=" + marginName + ", feeName=" + feeName + ", riskName=" + riskName + ", bdtdName="
				+ bdtdName + ", agentname=" + agentname + ", feetemplatename=" + feetemplatename + ", bank=" + bank
				+ ", bankCard=" + bankCard + ", idNo=" + idNo + ", frontPic=" + frontPic + ", backPic=" + backPic
				+ ", cardPic=" + cardPic + ", authState=" + authState + ", inviteCode=" + inviteCode + "]";
	}
         
}