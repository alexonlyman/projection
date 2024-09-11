package com.example.demo.projection;

public interface EmployeeProjection {
    String getFirstname();

    String getLastname();

    String getPosition();

    String getDepartmentTitle();

    default String getFullName() {
        return getFirstname() + " " + getLastname();
    }
}
