package com.amiltechgroup.springbootwebfluxproject.service;

import com.amiltechgroup.springbootwebfluxproject.dto.EmployeeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO);
    Mono<EmployeeDTO> getEmployeeById(String id);
    Flux<EmployeeDTO> getAllEmployee();
    Mono<EmployeeDTO> updateEmployeeById(EmployeeDTO employeeDTO,String id);
    Mono<Void> deleteEmployeeById(String id);


}
