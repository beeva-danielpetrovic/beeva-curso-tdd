package com.beeva.tdd.interfaces;

import com.beeva.tdd.bo.EmployeeDataBO;

public interface IDaoEmployee {

	EmployeeDataBO getEmployeeData(String id);

}
