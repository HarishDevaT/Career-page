package com.harish.DataBase.Entities;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="users")
public class UserEntity {
	

	public UserEntity() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id ;
	
	private String userName ;
	
	private String password ;
	
	@Column(unique=true)
	private String email ;
	
	private Long phoneNumber ;
	
	@ManyToMany(mappedBy="favouritedUsers")
	private Set<JobEntity> favourites = new HashSet<>() ;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ApplicationEntity> jobsApplied = new HashSet<>() ;
	
    
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Long getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public Set<JobEntity> getFavourites() {
		return favourites;
	}




	public void setFavourites(Set<JobEntity> favourites) {
		this.favourites = favourites;
	}




	public Set<ApplicationEntity> getJobsApplied() {
		return jobsApplied;
	}




	public void setJobsApplied(Set<ApplicationEntity> jobsApplied) {
		this.jobsApplied = jobsApplied;
	}




	public UserEntity(Integer id, String userName, String password, String email, Long phoneNumber,
			Set<JobEntity> favourites, Set<ApplicationEntity> jobsApplied) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.favourites = favourites;
		this.jobsApplied = jobsApplied;
	}

     
}
