package com.lcwsankalp.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwsankalp.redis.model.Employee;
import com.lcwsankalp.redis.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeSevice {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public boolean deleteEmpployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmpployeeById(id);
	}

	@Override
	public boolean updateEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(id, employee);
	}

}
