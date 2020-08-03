package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Cacheable(cacheNames = "emp",key = "#id")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"员工");
        Employee employee = employeeMapper.getEmployeeId(id);
        return employee;
    }
    @CachePut(cacheNames = "emp",key = "#employee.id")
    public Employee update(Employee employee){
        System.out.println("update"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp"+id);
        //employeeMapper.deleteEmpById(id);
    }

    @Caching(
        cacheable = {
                @Cacheable(value = "emp",key = "#lastName")
        },
        put = {
                @CachePut(value = "emp",key = "#result.id")
        }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmployeeByLastName(lastName);
    }
}
