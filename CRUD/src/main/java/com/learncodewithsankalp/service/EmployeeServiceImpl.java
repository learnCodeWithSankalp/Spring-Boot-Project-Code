package com.learncodewithsankalp.service;

import com.learncodewithsankalp.entity.Employee;
import com.learncodewithsankalp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public Employee findEmployeeById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else{
            throw new RuntimeException("Employee not found");
        }
        return theEmployee;
    }

    @Override
    public void deleteEmployee(Employee theEmployee) {
        employeeRepository.delete(theEmployee);
    }

}
