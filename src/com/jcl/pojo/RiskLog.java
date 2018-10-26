package com.jcl.pojo;

import java.util.Date;

public class RiskLog {
    private Integer id;

    private String warnno;

    private String userno;

    private String userType;

    private String declarationAccount;

    private String warnType;

    private String warnDetail;

    private Date warnTime;

    private Long userid;

    private String agentzh;

    private String warnDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarnno() {
        return warnno;
    }

    public void setWarnno(String warnno) {
        this.warnno = warnno == null ? null : warnno.trim();
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno == null ? null : userno.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getDeclarationAccount() {
        return declarationAccount;
    }

    public void setDeclarationAccount(String declarationAccount) {
        this.declarationAccount = declarationAccount == null ? null : declarationAccount.trim();
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    public String getWarnDetail() {
        return warnDetail;
    }

    public void setWarnDetail(String warnDetail) {
        this.warnDetail = warnDetail == null ? null : warnDetail.trim();
    }

    public Date getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
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

    public String getWarnDesc() {
        return warnDesc;
    }

    public void setWarnDesc(String warnDesc) {
        this.warnDesc = warnDesc == null ? null : warnDesc.trim();
    }
}