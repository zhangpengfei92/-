package com.jcl.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DocContent {
	private Integer id;

	private Integer columnid;

	private String title;

	private String summary;

	private String photopath;
	@DateTimeFormat(pattern = "yy-MM-dd HH:mm")
	private Date publishtime;

	@DateTimeFormat(pattern = "yy-MM-dd HH:mm")
	private Date endtime;

	private String istop;

	private String content;

	private String author;

	private DocColumn docColumn;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public DocColumn getDocColumn() {
		return docColumn;
	}

	public void setDocColumn(DocColumn docColumn) {
		this.docColumn = docColumn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getColumnid() {
		return columnid;
	}

	public void setColumnid(Integer columnid) {
		this.columnid = columnid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}