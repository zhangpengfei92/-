package com.jcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Agentzh {
    private String agentzh;

    private String name;

    private String password;

    private Integer sex;

    private String mac;

    private String phone;

    private String qq;

    private Date starttime;

    private Date endtime;

    private String mail;

    private String address;

    private Date createdAt;

    private Date modifiedAt;

    private BigDecimal softfee;

    private BigDecimal softfeemoney;

    private Integer status;

    private BigDecimal total;

    private BigDecimal used;

    private Long userid;

    private String parentagentzh;

    public String getAgentzh() {
        return agentzh;
    }

    public void setAgentzh(String agentzh) {
        this.agentzh = agentzh == null ? null : agentzh.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public BigDecimal getSoftfee() {
        return softfee;
    }

    public void setSoftfee(BigDecimal softfee) {
        this.softfee = softfee;
    }

    public BigDecimal getSoftfeemoney() {
        return softfeemoney;
    }

    public void setSoftfeemoney(BigDecimal softfeemoney) {
        this.softfeemoney = softfeemoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getParentagentzh() {
        return parentagentzh;
    }

    public void setParentagentzh(String parentagentzh) {
        this.parentagentzh = parentagentzh == null ? null : parentagentzh.trim();
    }
}