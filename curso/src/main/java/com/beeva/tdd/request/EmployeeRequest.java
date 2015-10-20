package com.beeva.tdd.request;

import javax.validation.constraints.Size;

public class EmployeeRequest {
	
	@Size(min = 5, max = 5)
	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
