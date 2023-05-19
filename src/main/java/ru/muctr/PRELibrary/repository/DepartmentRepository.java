package ru.muctr.PRELibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.muctr.PRELibrary.models.Department;
import ru.muctr.PRELibrary.models.Prepod;

/**
 * @author Evgenia Skichko
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
