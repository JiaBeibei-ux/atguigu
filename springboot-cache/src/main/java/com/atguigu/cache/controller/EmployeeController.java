package com.atguigu.cache.controller;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
       return employeeService.getEmp(id);
    }
    @GetMapping("/emp")
    public Employee update(Employee employee){
       return employeeService.update(employee);
    }
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }
    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
