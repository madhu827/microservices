package com.example.micro.Service;

import com.example.micro.Entity.Employee;
import com.example.micro.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;


    public Employee addEmployee(Employee employee) {

      return   repository.save(employee);
    }

    public List<Employee> getallEmployees() {
        return repository.findAll();
    }
}
