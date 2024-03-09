package com.lcwsankalp.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.lcwsankalp.redis.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	RedisTemplate redisTemplate;
	
	private static String KEY = "EMPLOYEE";

	@Override
	public boolean saveEmployee(Employee employee) {
		try {
			redisTemplate.opsForHash().put(KEY, employee.getId().toString(), employee);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList;
		employeeList = redisTemplate.opsForHash().values(KEY);
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee;
		employee =(Employee) redisTemplate.opsForHash().get(KEY, id.toString());
		return employee;
	}

	@Override
	public boolean deleteEmpployeeById(Long id) {
		try {
			redisTemplate.opsForHash().delete(KEY, id.toString());
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateEmployee(Long id, Employee employee) {
		try {
			redisTemplate.opsForHash().put(KEY, id, employee);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
