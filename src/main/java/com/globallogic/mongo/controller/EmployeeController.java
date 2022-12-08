package com.globallogic.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.mongo.collection.Address;
import com.globallogic.mongo.collection.Employee;
import com.globallogic.mongo.customexception.EmployeeCustomException;
import com.globallogic.mongo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) throws EmployeeCustomException
	{
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/getEmployeeById")
	public Employee getEmployee(@RequestParam("id") String id) throws EmployeeCustomException
	{
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/getEmployeeByLastName")
	public Employee getEmployeeByLastName(@RequestParam("lastName")String lastName) throws EmployeeCustomException
	{
		return service.getEmployeeByLastName(lastName);
		
	}
	
	@PutMapping("/updateEmployeeSalary")
	public Employee updateEmployeeSalary(@RequestParam("id")String id, @RequestParam("salary")Integer salary) throws EmployeeCustomException
	{
		return service.updateEmployeeById(id, salary);
	}
	
	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeByName(@RequestParam("id")String id)
	{
		return service.deleteEmployeeById(id);
	}
	
	@GetMapping("/employeesWithinSalaryRange")
	public List<Employee> getEmployeesWithinSalaryRange(@RequestParam("from")int from, @RequestParam("to")int to) throws EmployeeCustomException
	{
		return service.findEmployeesWithinSalaryRange(from, to);
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public Employee getEmployeeByName(@PathVariable("name")String name) throws EmployeeCustomException
	{
		return service.findEmployeeByName(name);
	}
	
	@PostMapping("/getEmployeeByAddress")
	public Employee getEmployeeByAddress(@RequestBody Address address) throws EmployeeCustomException
	{
		return service.getEmployeeByAddress(address);
	}
	
	@GetMapping("/employeesSortedBySalary")
	public List<Employee> getSortedEmployees() throws EmployeeCustomException
	{
		return service.getEmployeeInIncreasingOrderOfSalary();
	}

}
