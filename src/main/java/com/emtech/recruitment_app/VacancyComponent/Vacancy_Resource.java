package com.emtech.recruitment_app.VacancyComponent;

import com.emtech.recruitment_app.VacancyComponent.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/vacancy")
public class Vacancy_Resource {

    @Autowired
    private Vacancy_Repository vacancy_repository;
    @Autowired
    private Vacancy_Service vacancy_service;

    @GetMapping("/all")
    public ResponseEntity<List<Vacancy>> getAllApplicants(){
        try {
            List<Vacancy> vacancyList = vacancy_service.findAllVacancies();
            return new ResponseEntity<>(vacancyList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable("id") Long id){
        try {
            Vacancy vacancy = vacancy_service.findVacancyById(id);
            return new ResponseEntity<>(vacancy,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addVacancy(@RequestBody Vacancy vacancy){
        try {
            Vacancy newApplicant = vacancy_service.addVacancy(vacancy);
            return new ResponseEntity<>(newApplicant,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * delete applicant
     * @param id
     * @param
     * @return
     */
    @PutMapping("/update/vacancy/{id}")
    public ResponseEntity<Vacancy> updateVacancyById(@PathVariable("id") Long id, @RequestBody Vacancy vacancy){
        try {
            return new ResponseEntity<>(vacancy_repository.save(vacancy), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @DeleteMapping("/delete/applicant/{id}")
    public ResponseEntity<Vacancy> deleteApplicant(@PathVariable("id") Long id){
        try{
            vacancy_repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
