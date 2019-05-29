package com.laptrinhjavaweb.dto;

import java.sql.Timestamp;


public class AbstractDTO {
	private Long id;
	
	private String createBy;
	
	private String modifieldBy;
	
	private Timestamp createDate;
	
	private Timestamp modifieldDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifieldBy() {
		return modifieldBy;
	}
	public void setModifieldBy(String modifieldBy) {
		this.modifieldBy = modifieldBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifieldDate() {
		return modifieldDate;
	}
	public void setModifieldDate(Timestamp modifieldDate) {
		this.modifieldDate = modifieldDate;
	}
}
