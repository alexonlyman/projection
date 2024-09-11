package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.projection.EmployeeProjection;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer id);

    void updateEmployee(Employee employee);

    EmployeeProjection showProjection(Integer id);

}
