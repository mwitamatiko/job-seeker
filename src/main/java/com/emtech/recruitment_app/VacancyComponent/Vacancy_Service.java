package com.emtech.recruitment_app.VacancyComponent;

import com.emtech.recruitment_app.ApplicantComponent.Applicant.Applicant;
import com.emtech.recruitment_app.ApplicantComponent.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vacancy_Service {

    @Autowired
    private Vacancy_Repository vacancy_repository;

    /**
     * create new applicant
     * @param vacancy
     * @return
     */
    public Vacancy addVacancy(Vacancy vacancy){
        try{
            return vacancy_repository.save(vacancy);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find all applicants in a list
     * @return
     */
    public List<Vacancy> findAllVacancies(){
        try {
            return vacancy_repository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find applicant using given id
     * @param id
     * @return
     */
    public Vacancy findVacancyById(Long id){
        try {
            return vacancy_repository.findById(id)
                    .orElseThrow(()->new NotFoundException("Vacancy "+id+" not found"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * update applicant
     * @param
     * @return
     */
    public Vacancy updateVacancy(Vacancy vacancy){
        try {
            return vacancy_repository.save(vacancy);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    /**
     * use this
     * @param id
     * @return
     */
    public Vacancy updateVacancyById(Long id){
        try {
            return vacancy_repository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * delete an applicant using a given id
     * @param id
     */
    public void delete(Long id){
        try{
            vacancy_repository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
