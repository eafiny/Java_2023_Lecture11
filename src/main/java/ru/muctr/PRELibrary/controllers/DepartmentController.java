package ru.muctr.PRELibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.muctr.PRELibrary.models.Department;
import ru.muctr.PRELibrary.models.Prepod;
import ru.muctr.PRELibrary.services.DepartmentService;
import ru.muctr.PRELibrary.services.PrepodService;

/**
 * @author Evgenia Skichko
 */
@RestController
public class DepartmentController {
    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable Integer id){
        System.out.println("Пришел запрос");
        return departmentService.findDepartmentById(id).get();
    }

    @PostMapping("/departments")
    public String createNewPrepod(@RequestBody Department department) {
        departmentService.save(department);
        return "Department added";
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartmentById(id);
    }
}
