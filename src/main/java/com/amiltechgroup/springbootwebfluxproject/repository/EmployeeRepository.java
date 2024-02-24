package com.amiltechgroup.springbootwebfluxproject.repository;

import com.amiltechgroup.springbootwebfluxproject.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {
}
