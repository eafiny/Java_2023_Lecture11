package ru.muctr.PRELibrary.services;

import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.muctr.PRELibrary.models.Prepod;
import ru.muctr.PRELibrary.repository.InMemoryPrepodRepository;
import ru.muctr.PRELibrary.repository.PrepodRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Evgenia Skichko
 */
@Service
public class PrepodService {
    PrepodRepository prepodRepository;

    @Autowired
    public PrepodService(PrepodRepository prepodRepository) {
        this.prepodRepository = prepodRepository;
    }

    public Optional<Prepod> findPrepodById(Integer id){
        return prepodRepository.findById(id);
    }

    public Prepod save(Prepod prepod) {
        return prepodRepository.save(prepod);
    }

    public void deletePrepodById(Integer id) {
        prepodRepository.deleteById(id);
    }

    public Object getTestData() {
       return prepodRepository.findAll(PageRequest.of(1, 3)).getContent();
//        return prepodRepository.findAllBySalaryBetween(100000, 200000);
//        return prepodRepository.findAll(Sort.by(Sort.Direction.DESC, "salary"));
    }

    @Transactional
    public void updatePrepod(int id, int newSalary){
        //beginTransaction
        Prepod prepod = prepodRepository.findById(id).get();
        prepod.setSalary(newSalary);
        //commit
    }
}
