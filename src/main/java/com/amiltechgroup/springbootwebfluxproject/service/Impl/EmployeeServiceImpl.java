package com.amiltechgroup.springbootwebfluxproject.service.Impl;

import com.amiltechgroup.springbootwebfluxproject.dto.EmployeeDTO;
import com.amiltechgroup.springbootwebfluxproject.entity.Employee;
import com.amiltechgroup.springbootwebfluxproject.mapper.EmployeeMapper;
import com.amiltechgroup.springbootwebfluxproject.repository.EmployeeRepository;
import com.amiltechgroup.springbootwebfluxproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Mono<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        Mono<EmployeeDTO> map = savedEmployee.map(e -> EmployeeMapper.mapToEmployeeDTO(e));
        return map;
    }

    @Override
    public Mono<EmployeeDTO> getEmployeeById(String id) {
        Mono<Employee> byId = employeeRepository.findById(id);
        Mono<EmployeeDTO> map = byId.map((employee -> EmployeeMapper.mapToEmployeeDTO(employee)));
        return map;
    }

    @Override
    public Flux<EmployeeDTO> getAllEmployee() {
        Flux<Employee> all = employeeRepository.findAll();
        Flux<EmployeeDTO> map = all
                .map(employee -> EmployeeMapper.mapToEmployeeDTO(employee))
                .switchIfEmpty(Flux.empty());
        return map;
    }

    @Override
    public Mono<EmployeeDTO> updateEmployeeById(EmployeeDTO employeeDTO, String  id) {
        Mono<Employee> byId = employeeRepository.findById(id);
        Mono<Employee> employeeMono = byId.flatMap((employee) -> {
            employee.setEmail(employeeDTO.getEmail());
            employee.setFirstName(employeeDTO.getEmail());
            employee.setLastName(employeeDTO.getEmail());

            return employeeRepository.save(employee);

        });
        Mono<EmployeeDTO> map = employeeMono.map(employee -> EmployeeMapper.mapToEmployeeDTO(employee));
        return map;
    }

    @Override
    public Mono<Void> deleteEmployeeById(String id) {
        Mono<Void> voidMono = employeeRepository.deleteById(id);
        return voidMono;
    }
}
