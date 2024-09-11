package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.projection.EmployeeProjection;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public void createEmployee(Employee employee) {
        Employee emp = new Employee();
        emp.setFirstname(employee.getFirstname());
        emp.setLastname(employee.getLastname());
        emp.setSalary(employee.getSalary());
        emp.setPosition(employee.getPosition());
        emp.setDepartment(employee.getDepartment());
        employeeRepo.save(emp);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);

    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee emp = new Employee();
        employee.setFirstname(employee.getFirstname());
        employee.setLastname(employee.getLastname());
        employee.setSalary(employee.getSalary());
        employee.setPosition(employee.getPosition());
        employee.setDepartment(employee.getDepartment());
        employeeRepo.save(emp);
    }

    public EmployeeProjection showProjection(Integer id) {
        Optional<EmployeeProjection> employeeProjectionById = employeeRepo.findEmployeeProjectionById(id);
        return employeeProjectionById.orElse(null);
    }
}
