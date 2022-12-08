package com.globallogic.mongo.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="employees")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
	
	
	@Id
	private String id;
	
	private String name;
	private String lastName;
	private Integer salary;
	private Integer phone;
	
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Employee(String name, String lastName, Integer salary, Integer phone) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
		this.phone = phone;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", lastName=" + lastName + ", salary=" + salary + ", phone=" + phone + "]";
	}
	
	
	public Employee(String id, String name, String lastName, Integer salary, Integer phone, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
		this.phone = phone;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
