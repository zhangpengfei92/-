package com.jcl.pojo;

public class Weblink {
    private Integer wid;

    private String wname;

    private String wurl;

    private Integer status;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname == null ? null : wname.trim();
    }

    public String getWurl() {
        return wurl;
    }

    public void setWurl(String wurl) {
        this.wurl = wurl == null ? null : wurl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}