package com.harish.DataBase.Dto;

import java.util.Set;

import com.harish.DataBase.Entities.JobEntity;

public class UserDto {

	private Integer id ;
	private String userName ;
	private String password ;
	private String email ;
	private Long phoneNumber ;
	private Set<JobEntity> favourites ;
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
	public UserDto(Integer id, String userName, String password, String email, Long phoneNumber,
			Set<JobEntity> favourites) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.favourites = favourites;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
