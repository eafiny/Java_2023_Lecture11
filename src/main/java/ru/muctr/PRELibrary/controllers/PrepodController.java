package ru.muctr.PRELibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.muctr.PRELibrary.errorHandling.InvalidDataException;
import ru.muctr.PRELibrary.errorHandling.ResourceNotFoundException;
import ru.muctr.PRELibrary.models.Prepod;
import ru.muctr.PRELibrary.services.PrepodService;

import java.util.stream.Collectors;

/**
 * @author Evgenia Skichko
 */
@RestController
public class PrepodController {
    PrepodService prepodService;

    @Autowired
    public PrepodController(PrepodService prepodService) {
        this.prepodService = prepodService;
    }

    @GetMapping("/prepods/{id}")
    public Prepod getPrepod(@PathVariable Integer id){
        return prepodService.findPrepodById(id).orElseThrow(() -> new ResourceNotFoundException("Преподаватель с id " + id + "не существует"));
    }

    @PostMapping("/prepods")
    @ResponseStatus(HttpStatus.CREATED)
    public Prepod createNewPrepod(@RequestBody @Validated Prepod prepod, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        return prepodService.save(prepod);
    }

    @DeleteMapping("/prepods/{id}")
    public void deletePrepod(@PathVariable Integer id){
        prepodService.deletePrepodById(id);
    }

    @GetMapping("/prepods/test")
    public Object getTestData(){
        return prepodService.getTestData();
    }

    @PutMapping("/{id}")
    public String updatePrepod(@PathVariable Integer id, @RequestParam int salary){
        prepodService.updatePrepod(id, salary);
        return "Обновлено успешно";
    }

    @PutMapping("/prepods")
    public Prepod updatePrepod2(@RequestBody Prepod prepod){
        return prepodService.save(prepod);
    }
}
