package com.beeva.tdd.interfaces;

import com.beeva.tdd.bo.EmployeeDataBO;

public interface IServiceEmployee {

	EmployeeDataBO getEmployeeAndProjects(String idEmployee) throws Exception;

}
