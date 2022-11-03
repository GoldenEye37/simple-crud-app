package com.boot.springboottutorial.service;

import com.boot.springboottutorial.Entity.Department;
import com.boot.springboottutorial.Exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {


    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartmentByID(Long id) throws DepartmentNotFoundException;

    void deleteDepartment(Long departmentID);

    Department updateDepartment(Long departmentID, Department department);

    Department findByName(String departmentName);
}
