package com.globallogic.mongo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.mongo.collection.Address;
import com.globallogic.mongo.collection.Employee;
import com.globallogic.mongo.customexception.EmployeeCustomException;
import com.globallogic.mongo.dao.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public Employee saveEmployee(Employee employee) throws EmployeeCustomException {
		employeeRepo.save(employee);
		Employee verification=employeeRepo.findEmployeeByName(employee.getName());
		if(verification==null)
		{
			throw new EmployeeCustomException("The employee could not be added successfully to mongodb "+employee.toString());
			
		}
		return verification;
	}
	
	public Employee getEmployeeById(String id) throws EmployeeCustomException
	{
		Employee foundEmployee=employeeRepo.findById(id).get();
		if(foundEmployee==null)
		{
			throw new EmployeeCustomException("The employee was not found for the given id: "+id);
		}
		return foundEmployee;
	}
	
	public Employee getEmployeeByLastName(String lastName) throws EmployeeCustomException
	{
		Employee foundEmployee=employeeRepo.findEmployeeByLastName(lastName);
		if(foundEmployee==null)
		{
			throw new EmployeeCustomException("The employee was not found for the given lastName: "+lastName);
		}
		return foundEmployee;
	}
	
	public Employee updateEmployeeById(String id, Integer salary) throws EmployeeCustomException
	{
		
		Employee foundEmployee=employeeRepo.findById(id).get();
		if(foundEmployee==null)
		{
			throw new EmployeeCustomException("The employee was not found for the given id: "+id);
		}
		foundEmployee.setSalary(salary);
		employeeRepo.save(foundEmployee);
		return employeeRepo.findById(id).get();
	}
	
	public String deleteEmployeeById(String id)
	{
		Optional<Employee>foundEmployee=employeeRepo.findById(id);
		if(foundEmployee.isEmpty())
		{
			return "The Employee with the id "+id+" does not exist";
		}
		else
		{
			employeeRepo.deleteById(id);
			return "Employee with the id "+id+" deleted successfully!";
		}
	}
	
	public List<Employee> findEmployeesWithinSalaryRange(int from, int to) throws EmployeeCustomException
	{
		List<Employee> employees=employeeRepo.findBySalaryBetween(from, to);
		if(employees.isEmpty())
		{
			throw new EmployeeCustomException("The List of employees was not found within the salary range :"+from+" "+to);
		}
		return employees;
	}

	public Employee findEmployeeByName(String name) throws EmployeeCustomException {
		// TODO Auto-generated method stub
		Employee foundEmployee=employeeRepo.findEmployeeByName(name);
		if(foundEmployee==null)
		{
			throw new EmployeeCustomException("The employee with the name "+name+" does not exist");
		}
		return foundEmployee;
	}
	
	public Employee getEmployeeByAddress(Address address) throws EmployeeCustomException
	{
		Employee foundEmployee=employeeRepo.findEmployeeByAddress(address);
		if(foundEmployee==null)
		{
			throw new EmployeeCustomException("The employee with the address was not found");
		}
		return foundEmployee;
	}
	
	public List<Employee> getEmployeeInIncreasingOrderOfSalary() throws EmployeeCustomException
	{
		List<Employee> employees=employeeRepo.findAll();
		if(employees.isEmpty())
		{
			throw new EmployeeCustomException("There are no employees in database.");
		}
		List<Employee>employeeSorted=employees.stream().sorted((e1,e2)->(e1.getSalary().compareTo(e2.getSalary()))).collect(Collectors.toList());
		return employeeSorted;
	}
}
