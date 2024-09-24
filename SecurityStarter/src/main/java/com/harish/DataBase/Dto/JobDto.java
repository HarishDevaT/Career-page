package com.harish.DataBase.Dto;


public class JobDto {

	private Integer id;
	private String title;
	
	
	public JobDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobDto(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
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
	
}
