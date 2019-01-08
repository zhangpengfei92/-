package com.jcl.pojo;

import java.util.Date;

public class Document {
    private Integer did;

    private String docname;

    private String title;

    private Date doctime;

    private String author;

    private Integer docstate;

    private String docurl;

    private String doccontext;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname == null ? null : docname.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getDoctime() {
        return doctime;
    }

    public void setDoctime(Date doctime) {
        this.doctime = doctime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getDocstate() {
        return docstate;
    }

    public void setDocstate(Integer docstate) {
        this.docstate = docstate;
    }

    public String getDocurl() {
        return docurl;
    }

    public void setDocurl(String docurl) {
        this.docurl = docurl == null ? null : docurl.trim();
    }

    public String getDoccontext() {
        return doccontext;
    }

    public void setDoccontext(String doccontext) {
        this.doccontext = doccontext == null ? null : doccontext.trim();
    }
}