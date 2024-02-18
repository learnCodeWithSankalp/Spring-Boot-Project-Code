package com.lcwsankalp.mogointegration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwsankalp.mogointegration.entity.Employee;
import com.lcwsankalp.mogointegration.repository.EmpRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmpRepository empRepo;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee emp) {
		empRepo.save(emp);
		return "Employee Saved with Id: "+ emp.getId();
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployee(){
		List<Employee> empList = empRepo.findAll();
		return empList;
	}
	
	@GetMapping("/getEmpById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id){
		Optional<Employee> employee = empRepo.findById(id);
		return employee;
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empRepo.deleteById(id);
		return "Employee Deleted with Id:"+id;
	}
}
