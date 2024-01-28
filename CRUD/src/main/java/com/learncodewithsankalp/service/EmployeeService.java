package com.learncodewithsankalp.service;

import com.learncodewithsankalp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService  {
    List<Employee> findAllEmployee();

    void save(Employee theEmployee);


    Employee findEmployeeById(int theId);

    void deleteEmployee(Employee theEmployee);
}
