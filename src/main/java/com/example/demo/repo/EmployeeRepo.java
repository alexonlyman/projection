package com.example.demo.repo;

import com.example.demo.model.Employee;
import com.example.demo.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeById(Integer id);

    @Query("SELECT CONCAT(e.firstname, ' ', e.lastname) AS fullName, e.position AS position, d.title AS departmentName " +
            "FROM Employee e JOIN e.department d WHERE e.id = :id")
    Optional<EmployeeProjection> findEmployeeProjectionById( Integer id);

}
