package com.boot.springboottutorial.controller;

import com.boot.springboottutorial.Entity.Department;
import com.boot.springboottutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping()
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentByID(@PathVariable("id") Long departmentID){
        return departmentService.getDepartmentByID(departmentID);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentID){
        departmentService.deleteDepartment(departmentID);
        return "Department Successfully deleted!";
    }

    @PutMapping("{id")
    public Department updateDepartment(@PathVariable("id") Long departmentID,
                                                    @RequestBody Department department){
        return departmentService.updateDepartment(departmentID, department);
    }

}
