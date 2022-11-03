package com.boot.springboottutorial.controller;

import com.boot.springboottutorial.Entity.Department;
import com.boot.springboottutorial.service.DepartmentService;
import com.sun.source.doctree.DeprecatedTree;
import org.apache.juli.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            (Logger) LoggerFactory.getLogger(DepartmentController.class);

/*
     **************** Create department ******************
 */
    @PostMapping()
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

/*
 **************** Get all departments ******************
 */
    @GetMapping()
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

/*
    **************** get department by ID ******************
 */
    @GetMapping("/{id}")
    public Department getDepartmentByID(@PathVariable("id") Long departmentID){
        return departmentService.getDepartmentByID(departmentID);
    }

/*
 **************** Delete department ******************
 */

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentID){
        departmentService.deleteDepartment(departmentID);
        return "Department Successfully deleted!";
    }

/*
 **************** Update department ******************
 */

    @PutMapping("{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID,
                                                    @RequestBody Department department){
        return departmentService.updateDepartment(departmentID, department);
    }

/*
   **************** find by department Name ******************
 */

    @GetMapping("/name/{name}")
    public Department findByName(@PathVariable("name") String departmentName){
        return departmentService.findByName(departmentName);
    }




}
