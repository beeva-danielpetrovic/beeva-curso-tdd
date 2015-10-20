package com.beeva.tdd.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.beeva.tdd.bo.EmployeeDataBO;
import com.beeva.tdd.bo.Project;
import com.beeva.tdd.interfaces.IServiceEmployee;

@RunWith(value = MockitoJUnitRunner.class)
public class BeevaControllerTest {

	private static IServiceEmployee mockServiceEmployee;
	private static MockMvc mockMvc;
	private static BeevaController beevaController;
	private String employeeId = "11111";
	private String employeeIdKO = "1";

	@BeforeClass
	public static void setUp() throws Exception {

		mockServiceEmployee = mock(IServiceEmployee.class);
		beevaController = new BeevaController(mockServiceEmployee);
		mockMvc = MockMvcBuilders.standaloneSetup(beevaController).build();
	}
	
	@After
	public void tearDown(){
		reset(mockServiceEmployee);
	}

	@Test
	public void whenEmployeeExistAndHasProjectThenStatusOK() throws Exception {

		mockMvc.perform(get("/employees/" + employeeId + "/projects"))
				.andExpect(status().isOk());
	}

	@Test
	public void whenEmployeeExistAndHasProjectThenReturnJsonDataAndStatusOK()
			throws Exception {

		EmployeeDataBO stubEmployeeData = new EmployeeDataBO();
		List<Project> arrayProjects = new ArrayList<Project>();
		arrayProjects.add(new Project("00001", "Pci-Box"));
		stubEmployeeData.setName("Daniel");
		stubEmployeeData.setEmail("daniel.petrovic@beeva.com");
		stubEmployeeData.setProjects(arrayProjects);
		when(mockServiceEmployee.getEmployeeAndProjects(anyString()))
				.thenReturn(stubEmployeeData);

		mockMvc.perform(get("/employees/" + employeeId + "/projects"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", is("Daniel")))
				.andExpect(jsonPath("$.email", is("daniel.petrovic@beeva.com")))
				.andExpect(jsonPath("$.projects[0].id", is("00001")))
				.andExpect(jsonPath("$.projects[0].name", is("Pci-Box")));

		verify(mockServiceEmployee, times(1))
				.getEmployeeAndProjects(employeeId);

	}

	@Test
	public void whenEmployeeNotExistThenStatusIs404() throws Exception {

		when(mockServiceEmployee.getEmployeeAndProjects(anyString()))
				.thenThrow(new Exception());

		mockMvc.perform(get("/employees/" + employeeId + "/projects"))
				.andExpect(status().isNotFound());

		verify(mockServiceEmployee, times(1))
				.getEmployeeAndProjects(employeeId);
	}

	@Test
	public void whenEmployeeIdIsWrongThenErrorResponseAndStatusIs400() throws Exception {


		mockMvc.perform(get("/employees/" + employeeIdKO + "/projects"))
				.andExpect(status().isBadRequest());

		verify(mockServiceEmployee, times(0))
				.getEmployeeAndProjects(employeeId);

	}
	
	/**
	 * Este test realmente no hace diseño nuevo, sino que este diseño esta ya implementado
	 * @throws Exception
	 */
	@Ignore
	@Test
	public void whenEmployeeExistAndNotHasProjectThenReturnJsonDataWithoutProjectsAndStatusOK()
			throws Exception {

		EmployeeDataBO stubEmployeeData = new EmployeeDataBO();
		stubEmployeeData.setName("Daniel");
		stubEmployeeData.setEmail("daniel.petrovic@beeva.com");
		when(mockServiceEmployee.getEmployeeAndProjects(anyString()))
				.thenReturn(stubEmployeeData);

		mockMvc.perform(get("/employees/" + employeeId + "/projects"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", is("Daniel")))
				.andExpect(jsonPath("$.email", is("daniel.petrovic@beeva.com")))
				.andExpect(jsonPath("$.projects", is(nullValue())));

		verify(mockServiceEmployee, times(1))
				.getEmployeeAndProjects(employeeId);

	}

}
