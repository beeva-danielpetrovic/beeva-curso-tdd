package com.beeva.tdd.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
	
	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "name")
	private String name;

	public Project(String idProject, String name) {
		
		this.id = idProject;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
