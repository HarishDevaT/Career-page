package com.harish.DataBase.Entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Jobs")
public class JobEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id ;
	private String title ;
	private String description ;
	private String location;
	private String Type ;
	private String requirments ;
	@ManyToMany
	@JoinTable (
	        name = "favourites",
	        joinColumns = @JoinColumn(name = "job_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	private Set<UserEntity> favouritedUsers = new HashSet<>();
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ApplicationEntity> appliedUsers = new HashSet<>();
	
	
	
	public JobEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobEntity(Integer id, String title, String description, String location, String type, String requirments,
			Set<UserEntity> favouritedUsers, Set<ApplicationEntity> appliedUsers) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		Type = type;
		this.requirments = requirments;
		this.favouritedUsers = favouritedUsers;
		this.appliedUsers = appliedUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getRequirments() {
		return requirments;
	}

	public void setRequirments(String requirments) {
		this.requirments = requirments;
	}

	public Set<UserEntity> getFavouritedUsers() {
		return favouritedUsers;
	}

	public void setFavouritedUsers(Set<UserEntity> favouritedUsers) {
		this.favouritedUsers = favouritedUsers;
	}

	public Set<ApplicationEntity> getAppliedUsers() {
		return appliedUsers;
	}

	public void setAppliedUsers(Set<ApplicationEntity> appliedUsers) {
		this.appliedUsers = appliedUsers;
	}

	
		
}
