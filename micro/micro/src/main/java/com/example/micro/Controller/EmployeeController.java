package com.example.micro.Controller;

import com.example.micro.Entity.Employee;
import com.example.micro.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @PostMapping("/addemployee")
    public Employee addEmployee(@RequestBody  Employee employee){
        return service.addEmployee(employee);


    }
    @GetMapping("/employee")
    public List<Employee> getallEmployees(){
      return  service.getallEmployees();
    }
}
