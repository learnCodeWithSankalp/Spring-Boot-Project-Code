package com.lcwsankalp.mogointegration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwsankalp.mogointegration.entity.Employee;

public interface EmpRepository extends MongoRepository<Employee, Integer> {

}
