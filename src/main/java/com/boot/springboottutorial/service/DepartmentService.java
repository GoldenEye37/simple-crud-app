package com.boot.springboottutorial.service;

import com.boot.springboottutorial.Entity.Department;

import java.util.List;

public interface DepartmentService {


    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartmentByID(Long id);

    void deleteDepartment(Long departmentID);

    Department updateDepartment(Long departmentID, Department department);
}
