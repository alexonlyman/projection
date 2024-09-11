package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.projection.EmployeeProjection;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
        service.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Employee employeeById = service.getEmployeeById(id);
        return ResponseEntity.ok().body(employeeById);

    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        service.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/projection/{id}")
    public ResponseEntity<EmployeeProjection> showProjection(@PathVariable Integer id) {
        EmployeeProjection shown = service.showProjection(id);
        return ResponseEntity.ok(shown);
    }


}
