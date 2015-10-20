package com.beeva.tdd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.beeva.tdd.bo.EmployeeDataBO;
import com.beeva.tdd.bo.Project;
import com.beeva.tdd.exceptions.BeevaBadRequestException;
import com.beeva.tdd.interfaces.IServiceEmployee;
import com.beeva.tdd.request.EmployeeRequest;

@RestController
public class BeevaController {

	private IServiceEmployee serviceEmployee;

	@Autowired
	public BeevaController(IServiceEmployee serviceEmployee) {

		this.serviceEmployee = serviceEmployee;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{employeeId}/projects", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public EmployeeDataBO getEmployeeAndProjects(
			@PathVariable String employeeId, @Valid EmployeeRequest request,
			BindingResult bindingResult) throws Exception {

		if(bindingResult.hasErrors())
			throw new BeevaBadRequestException();

		EmployeeDataBO employeeData = serviceEmployee
				.getEmployeeAndProjects(employeeId);

		return employeeData;

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public void employeeNotExist() {

	}

	@ExceptionHandler(BeevaBadRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public void employeeIdIsWrong() {

	}

}
