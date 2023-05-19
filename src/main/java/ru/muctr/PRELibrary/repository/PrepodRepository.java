package ru.muctr.PRELibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.muctr.PRELibrary.models.Prepod;

import java.util.List;
import java.util.Optional;

/**
 * @author Evgenia Skichko
 */
@Repository
public interface PrepodRepository extends JpaRepository<Prepod, Integer> {
    List<Prepod> findAllBySalaryLessThan(int salary);
    List<Prepod> findAllBySalaryBetween(int minSalary, int maxSalary);
    List<Prepod> findAllBySalaryGreaterThanAndNameStartsWith(int minSalary, String startString);
}
