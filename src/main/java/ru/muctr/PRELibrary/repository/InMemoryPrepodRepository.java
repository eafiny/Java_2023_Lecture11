package ru.muctr.PRELibrary.repository;

import org.springframework.stereotype.Repository;
import ru.muctr.PRELibrary.models.Prepod;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Evgenia Skichko
 */

@Repository
public class InMemoryPrepodRepository {
    List<Prepod> prepods;

    public Optional<Prepod> findOneById(int id) {
        for (Prepod prepod : prepods) {
            if (prepod.getId() == id) {
                return Optional.of(prepod);
            }
        }
        return Optional.empty();
    }

//    @PostConstruct
//    public void init(){
//        prepods = new ArrayList<>(Arrays.asList(
//                new Prepod(1, "John", 50000),
//                new Prepod (2, "Peter", 100000)
//        ));
//    }

    public void save(Prepod prepod) {
        prepods.add(prepod);
    }
}
