package com.harish.DataBase.Entities;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="application")
public class ApplicationEntity {

	@EmbeddedId
	private ApplicationId id = new ApplicationId() ;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;
	
	@ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    private JobEntity job ;
	
	private String level ;
	
	private String status ;
	
	private LocalDate appliedDate ;
	
	private LocalDate lastUpdateOn ;

	public ApplicationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationEntity(UserEntity user, JobEntity job, String level, String status,
			LocalDate appliedDate, LocalDate lastUpdateOn) {
		super();
		this.id = new ApplicationId(user.getId(),job.getId());
		this.user = user;
		this.job = job;
		this.level = level;
		this.status = status;
		this.appliedDate = appliedDate;
		this.lastUpdateOn = lastUpdateOn;
	}

	public ApplicationId getId() {
		return id;
	}

	public void setId(ApplicationId id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public JobEntity getJob() {
		return job;
	}

	public void setJob(JobEntity job) {
		this.job = job;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public LocalDate getLastUpdateOn() {
		return lastUpdateOn;
	}

	public void setLastUpdateOn(LocalDate lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}
	
	
}
