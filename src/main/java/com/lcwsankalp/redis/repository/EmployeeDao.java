package com.lcwsankalp.redis.repository;

import java.util.List;

import com.lcwsankalp.redis.model.Employee;

public interface EmployeeDao {
	
	boolean saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Long id);
	boolean deleteEmpployeeById(Long id);
	boolean updateEmployee(Long id,Employee employee);

}
