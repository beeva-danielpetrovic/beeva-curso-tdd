package com.beeva.tdd.implementations;

import com.beeva.tdd.bo.EmployeeDataBO;
import com.beeva.tdd.interfaces.IDaoEmployee;
import com.beeva.tdd.interfaces.IServiceEmployee;

public class ServiceEmployeeImpl implements IServiceEmployee {
	
	private IDaoEmployee daoEmployee;
	

	public ServiceEmployeeImpl(IDaoEmployee daoEmployee) {
		super();
		this.daoEmployee = daoEmployee;
	}


	@Override
	public EmployeeDataBO getEmployeeAndProjects(String idEmployee)
			throws Exception {
		
		EmployeeDataBO data = daoEmployee.getEmployeeData(idEmployee);
		
		if(data == null)
			throw new Exception();
		
		return data;
	}

}
