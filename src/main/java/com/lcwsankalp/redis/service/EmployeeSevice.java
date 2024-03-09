package com.lcwsankalp.redis.service;

import java.util.List;

import com.lcwsankalp.redis.model.Employee;

public interface EmployeeSevice {
	boolean saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Long id);
	boolean deleteEmpployeeById(Long id);
	boolean updateEmployee(Long id,Employee employee);

}
