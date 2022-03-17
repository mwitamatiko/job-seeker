package com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience;

import com.emtech.recruitment_app.ApplicantComponent.Applicant.Applicant;
import com.emtech.recruitment_app.ApplicantComponent.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Application_ExperienceService {

    @Autowired
    private Application_ExperienceRepository application_experienceRepository;

    /**
     * create new application_experience
     * @param application_experience
     * @return
     */
    public Application_Experience addApplication_Experience(Application_Experience application_experience){
        try{
            return application_experienceRepository.save(application_experience);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find all application_experiences in a list
     * @return
     */
    public List<Application_Experience> findAllApplication_Experiences(){
        try {
            return application_experienceRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find application_experience using given id
     * @param id
     * @return
     */
    public Application_Experience findApplication_ExperienceById(Long id){
        try {
            return application_experienceRepository.findById(id)
                    .orElseThrow(()->new NotFoundException("Application_Experience "+id+" not found"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * update application_experience
     * @param application_experience
     * @return
     */
    public Application_Experience updateApplication_Experience(Application_Experience application_experience){
        try {
            return application_experienceRepository.save(application_experience);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public Application_Experience updateApplication_ExperienceById(Long id,Application_Experience application_experience){
//        try {
//            return application_experienceRespository.sa
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public Application_Experience updateExperienceById(Long id){
//        try {
//            return application_experienceRepository.findExperienceInfoById(id).orElseThrow(()-> new NotFoundException("Experience "+id+" not found") );
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

    /**
     * use this
     * @param id
     * @return
     */
    public Application_Experience updateExperienceById(Long id){
        try {
            return application_experienceRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * delete an application_experience using a given id
     * @param id
     */
    public void delete(Long id){
        try{
            application_experienceRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
