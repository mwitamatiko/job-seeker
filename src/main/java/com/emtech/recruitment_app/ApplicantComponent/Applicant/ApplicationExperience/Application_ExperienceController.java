package com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience;


import com.emtech.recruitment_app.ApplicantComponent.Applicant.Applicant;
import com.emtech.recruitment_app.ApplicantComponent.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/experience")
public class Application_ExperienceController {

    @Autowired
    private Application_ExperienceService application_experienceService;
    @Autowired
    private Application_ExperienceRepository application_experienceRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Application_Experience>> getAllApplication_Experiences(){
        try {
            List<Application_Experience> applicantList = application_experienceService.findAllApplication_Experiences();
            return new ResponseEntity<>(applicantList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application_Experience> getApplication_ExperienceById(@PathVariable("id") Long id){
        try {
            Application_Experience applicant = application_experienceService.findApplication_ExperienceById(id);
            return new ResponseEntity<>(applicant,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addApplication_Experience(@RequestBody Application_Experience applicant){
        try {
            Application_Experience newApplication_Experience = application_experienceService.addApplication_Experience(applicant);
            return new ResponseEntity<>(newApplication_Experience,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateExperienceApplicant(@RequestBody Application_Experience application_experience, @PathVariable("id") Long id) {
//        try {
//            Application_Experience existExperienceApplicant = application_experienceService.updateExperienceById(id);
//            application_experienceService.addApplication_Experience(application_experience);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        try {
            Optional<Application_Experience> experienceData = application_experienceRepository.findExperienceInfoById(id);
            if(experienceData.isPresent()){
                Application_Experience experience1 = experienceData.get();
//                experience1.setId(application_experience.getId());
                experience1.setCompany_name(application_experience.getCompany_name());
                experience1.setWork_position(application_experience.getWork_position());
                experience1.setYears_of_experience(application_experience.getYears_of_experience());
                experience1.setReferee_email(application_experience.getReferee_email());
                experience1.setReferee_name(application_experience.getReferee_name());
                experience1.setReferee_phone(application_experience.getReferee_phone());

                return new ResponseEntity<>(application_experienceRepository.save(experience1),HttpStatus.OK);
            }else{
                return ResponseEntity
                        .badRequest()
                        .body("Error: Experience Not found");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Application_Experience> deleteApplication_Experience(@PathVariable("id") Long id){
        try{
            application_experienceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
