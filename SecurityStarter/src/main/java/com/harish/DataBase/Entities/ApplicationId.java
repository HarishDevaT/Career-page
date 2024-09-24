package com.harish.DataBase.Entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ApplicationId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId ;
	
	private Integer jobId ;
	
	

	public ApplicationId() {
		super();
	}



	public ApplicationId(Integer userId, Integer jobId) {
		this.userId = userId;
		this.jobId = jobId;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public Integer getJobId() {
		return jobId;
	}



	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	
	
	
	
}
