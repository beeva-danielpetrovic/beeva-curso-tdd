package com.beeva.tdd.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDataBO {
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "email")
	private String email;
	
	@JsonProperty(value = "projects")
	private List<Project> projects;

	public void setName(String name) {
		
		this.name = name;
		
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public void setProjects(List<Project> arrayProjects) {
		
		this.projects = arrayProjects;
		
	}

}
