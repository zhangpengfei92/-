package com.jcl.pojo;

import java.util.Date;

//用于保存渠道-方案一对多关系的实体类
public class RiskTemplateMenu {
    private Integer id;

    private String title;//方案类型 ： 1- 手续费方案  ,2- 保证金方案  , 3- 风控方案

    private Date modifytime;

    private Long userid;//方案id

    private String agentzh;//渠道账户
    
    //关联风控模板表
    private RiskTemplate riskTemplate;
    
    public RiskTemplate getRiskTemplate() {
		return riskTemplate;
	}

	public void setRiskTemplate(RiskTemplate riskTemplate) {
		this.riskTemplate = riskTemplate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
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
}