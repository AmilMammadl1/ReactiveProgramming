package com.amiltechgroup.springbootwebfluxproject.controller;

import com.amiltechgroup.springbootwebfluxproject.dto.EmployeeDTO;
import com.amiltechgroup.springbootwebfluxproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public Mono<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        Mono<EmployeeDTO> employeeDTOMono = employeeService.saveEmployee(employeeDTO);
        return employeeDTOMono;
    }
    @GetMapping("/id/{id}")
    public Mono<EmployeeDTO> getEmployeeById(@PathVariable String id){
        Mono<EmployeeDTO> employeeDTOMono = employeeService.getEmployeeById(id);
        return employeeDTOMono;
    }
    @GetMapping("/all")
    public Flux<EmployeeDTO> getAllEmployee(){
        Flux<EmployeeDTO> employeeDTOMono = employeeService.getAllEmployee();
        return employeeDTOMono;
    }
    @PutMapping("/update/{id}")
    public Mono<EmployeeDTO> updateEmployeeById(@PathVariable String id,@RequestBody EmployeeDTO employeeDTO){
        Mono<EmployeeDTO> employeeDTOMono = employeeService.updateEmployeeById(employeeDTO,id);
        return employeeDTOMono;
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> updateEmployeeById(@PathVariable String id){
        Mono<Void> employeeDTOMono = employeeService.deleteEmployeeById(id);
        return employeeDTOMono;
    }
}
