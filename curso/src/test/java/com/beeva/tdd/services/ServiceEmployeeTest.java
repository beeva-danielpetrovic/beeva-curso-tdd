package com.beeva.tdd.services;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.beeva.tdd.bo.EmployeeDataBO;
import com.beeva.tdd.bo.Project;
import com.beeva.tdd.implementations.ServiceEmployeeImpl;
import com.beeva.tdd.interfaces.IDaoEmployee;
import com.beeva.tdd.interfaces.IServiceEmployee;

@RunWith(value = MockitoJUnitRunner.class)
public class ServiceEmployeeTest {

	private String idEmployee = "11111";
	
	private IServiceEmployee serviceEmployee;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Mock
	private IDaoEmployee mockDaoEmployee;
	
	@Before
	public void setUp() throws Exception {
		
		serviceEmployee = new ServiceEmployeeImpl(mockDaoEmployee);
	}

	@Test
	public void whenCallServiceEmployeeWithIdCorrectThenReturnData() throws Exception {
		
		EmployeeDataBO dataStub = new EmployeeDataBO();
		dataStub.setEmail("");
		dataStub.setName("");
		List<Project> arrayProjects = new ArrayList<Project>();
		dataStub.setProjects(arrayProjects);
		
		when(mockDaoEmployee.getEmployeeData(anyString())).thenReturn(dataStub);
		
		serviceEmployee.getEmployeeAndProjects(idEmployee);
		
		verify(mockDaoEmployee,times(1)).getEmployeeData(idEmployee);
	}
	
	/**
	 * Cuando se espera una exception no sirven los verify ya que la ejecución termina antes del verify
	 * @throws Exception
	 */
	@Test
	public void whenCallServiceEmployeeWithEmployeeNotExistThenThrowException() throws Exception {
		
		when(mockDaoEmployee.getEmployeeData(anyString())).thenReturn(null);
		
		expectedException.expect(Exception.class);
		
		serviceEmployee.getEmployeeAndProjects(idEmployee);
		
		//verify(mockDaoEmployee,times(1)).getEmployeeData(idEmployee);
	}

}
