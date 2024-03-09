package com.lcwsankalp.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lcwsankalp.redis.model.Employee;
import com.lcwsankalp.redis.service.EmployeeSevice;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeSevice employeeSevice;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee Employee){
		boolean saveEmployeeFlag= employeeSevice.saveEmployee(Employee);
		if(saveEmployeeFlag) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> empList;
		empList= employeeSevice.getAllEmployee();
		if(empList != null) {
			return ResponseEntity.ok(empList);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> FindEmployeeByIdEmployee(@PathVariable("id") Long id){
		Employee emp;
		emp= employeeSevice.getEmployeeById(id);
		if(emp != null) {
			return ResponseEntity.ok(emp);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeByIdEmployee(@PathVariable("id") Long id){
		
		boolean deleteEmployeeFlag= employeeSevice.deleteEmpployeeById(id);
		if(deleteEmployeeFlag) {
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<HttpStatus> updateEmployeeByIdEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
		
		boolean updateEmployeeFlag= employeeSevice.updateEmployee(id, employee);
		if(updateEmployeeFlag) {
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
