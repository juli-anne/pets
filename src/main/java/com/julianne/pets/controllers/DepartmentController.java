package com.julianne.pets.controllers;

import com.julianne.pets.entities.Department;
import com.julianne.pets.repositories.DepartmentRepository;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Getter
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        // extract into a service class

        return ResponseEntity.ok(departmentRepository.findById(id).get());
    }
}
