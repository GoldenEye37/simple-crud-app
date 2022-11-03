package com.boot.springboottutorial.service.impl;

import com.boot.springboottutorial.Entity.Department;
import com.boot.springboottutorial.Exception.DepartmentNotFoundException;
import com.boot.springboottutorial.Repository.DepartmentRepository;
import com.boot.springboottutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByID(Long id) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(id);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department NOT Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {

        Department deptBD = departmentRepository.findById(departmentID).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            deptBD.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            deptBD.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            deptBD.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(deptBD);
    }

    @Override
    public Department findByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
