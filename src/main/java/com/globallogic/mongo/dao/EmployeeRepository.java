package com.globallogic.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.globallogic.mongo.collection.*;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
	
	@Query("{lastName:'?0'}")
	public Employee findEmployeeByLastName(String lastName);
		
	@Query("{name:'?0'}")
	public Employee findEmployeeByName(String name);
	
	public List<Employee> findBySalaryBetween(int from, int to);
	
	public Employee findEmployeeByAddress(Address address);

}
