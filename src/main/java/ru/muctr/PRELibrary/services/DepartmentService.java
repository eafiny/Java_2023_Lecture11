package ru.muctr.PRELibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.muctr.PRELibrary.models.Department;
import ru.muctr.PRELibrary.models.Prepod;
import ru.muctr.PRELibrary.repository.DepartmentRepository;
import ru.muctr.PRELibrary.repository.PrepodRepository;

import java.util.Optional;

/**
 * @author Evgenia Skichko
 */
@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Optional<Department> findDepartmentById(Integer id){
        return departmentRepository.findById(id);
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);
    }
}
