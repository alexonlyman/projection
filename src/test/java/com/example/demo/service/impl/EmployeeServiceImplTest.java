package com.example.demo.service.impl;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.projection.EmployeeProjection;
import com.example.demo.repo.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    EmployeeRepo employeeRepo;

    @InjectMocks
    EmployeeServiceImpl service;


    private Employee employee;
    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department();
        department.setId(1);
        department.setTitle("IT");
        department.setEmployee(employee);

        employee = new Employee();
        employee.setFirstname("John");
        employee.setLastname("Doe");
        employee.setSalary(50000);
        employee.setPosition("Developer");
        employee.setDepartment(department);
    }

    @Test
    void testCreateEmployee() {
        service.createEmployee(employee);
        verify(employeeRepo, times(1)).save(employee);
    }

    @Test
    void testGetEmployeeById() {
        when(employeeRepo.findEmployeeById(1)).thenReturn(Optional.of(employee));
        Employee result = service.getEmployeeById(1);
        assertEquals(employee, result);
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        when(employeeRepo.findEmployeeById(1)).thenReturn(Optional.empty());
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> service.getEmployeeById(1));
        assertEquals("not found", thrown.getMessage());
    }
    @Test
    void testGetAllEmployees() {
        List<Employee> employees = List.of(employee);
        when(employeeRepo.findAll()).thenReturn(employees);
        List<Employee> result = service.getAllEmployees();
        assertEquals(employees, result);
    }

    @Test
    void testDeleteEmployee() {
        service.deleteEmployee(1);
        verify(employeeRepo, times(1)).deleteById(1);
    }

    @Test
    void testShowProjection() {
        EmployeeProjection projection = mock(EmployeeProjection.class);
        when(employeeRepo.findEmployeeProjectionById(1)).thenReturn(Optional.of(projection));
        EmployeeProjection result = service.showProjection(1);
        assertEquals(projection, result);
    }

    @Test
    void testShowProjectionNotFound() {
        when(employeeRepo.findEmployeeProjectionById(1)).thenReturn(Optional.empty());
        EmployeeProjection result = service.showProjection(1);
        assertNull(result);
    }

}