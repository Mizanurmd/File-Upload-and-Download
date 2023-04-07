package com.Spring.file.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@MappedSuperclass
@Data

public abstract class Base implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(updatable = false)
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createAt;
	private String updateBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;
	private Boolean isActive;
	
	@PrePersist
	public void setInsertDate() {
		this.createAt = new Date();
		this.isActive = true;
		
	}
	
	@PreUpdate
	public void setUpdateDate() {
		this.updateAt = new Date();
		
	}
	

}
