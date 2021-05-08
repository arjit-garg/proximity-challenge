package com.proximity.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="webinar_table")
public class Webinar {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String webinarTitle;
	private String docType;
	@Lob
	private byte[] content;
	private long size;
	private long uploadTime;
	
	/*
	 * private Subject subject; private Course course; private Tag tag;
	 */
	
	public Webinar() {
		
	}
	
	
public Webinar(String webinarTitle) {
	super();
	this.webinarTitle = webinarTitle;
	}
	
	
	public Webinar(String webinarTitle, String docType, byte[] content, long size, long uploadTime) {
		super();
		this.webinarTitle = webinarTitle;
		this.docType = docType;
		this.content = content;
		this.size = size;
		this.uploadTime = uploadTime;
		
		
	}



	public String getDocType() {
		return docType;
	}



	public void setDocType(String docType) {
		this.docType = docType;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWebinarTitle() {
		return webinarTitle;
	}
	public void setWebinarTitle(String webinarTitle) {
		this.webinarTitle = webinarTitle;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(long uploadTime) {
		this.uploadTime = uploadTime;
	}

	
}
