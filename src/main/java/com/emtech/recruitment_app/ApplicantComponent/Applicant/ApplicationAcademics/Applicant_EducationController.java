package com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationAcademics;


import com.emtech.recruitment_app.ApplicantComponent.Applicant.Applicant;
import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience.Application_Experience;
import com.emtech.recruitment_app.ApplicantComponent.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/education")
public class Applicant_EducationController {

    @Autowired
    private Applicant_EducationRepository applicant_educationRepository;
    @Autowired
    private Applicant_EducationService applicant_educationService;

    @GetMapping("/all")
    public ResponseEntity<List<Applicant_Education>> getAllApplicant_Educations(){
        try {
            List<Applicant_Education> applicantList = applicant_educationService.findAllApplicant_Educations();
            return new ResponseEntity<>(applicantList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant_Education> getApplicant_EducationById(@PathVariable("id") Long id){
        try {
            Applicant_Education applicant = applicant_educationService.findApplicant_EducationById(id);
            return new ResponseEntity<>(applicant,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addApplicant_Education(@RequestBody Applicant_Education applicant_education){
        try {
            Applicant_Education newApplicant_Education = applicant_educationService.addApplicant_Education(applicant_education);
            return new ResponseEntity<>(newApplicant_Education,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<?> updateEducationApplicant(@RequestBody Applicant_Education applicant_education, @PathVariable("id") Long id) {
//        try {
//            Applicant_Education existEducation = applicant_educationService.updateEducationById(id);
//            applicant_educationService.addApplicant_Education(applicant_education);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        try {
            Optional<Applicant_Education> educationData = applicant_educationRepository.findEducationInfoById(id);
            if(educationData.isPresent()){
                Applicant_Education education1 = educationData.get();
//                education1.setId(applicant_education.getId());
                education1.setInstitution_level(applicant_education.getInstitution_level());
                education1.setInstitution_name(applicant_education.getInstitution_name());
                education1.setCertification(applicant_education.getCertification());
                education1.setGpa(applicant_education.getGpa());
                education1.setEnrolled_year(applicant_education.getEnrolled_year());
                education1.setGraduated_year(applicant_education.getGraduated_year());

                return new ResponseEntity<>(applicant_educationRepository.save(education1),HttpStatus.OK);
            }else{
                return ResponseEntity
                        .badRequest()
                        .body("Error: Education Not found");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
//    public ResponseEntity<Applicant_Education> updateEducationApplicant(@RequestBody Applicant_Education applicant_education){
//        try {
//            Applicant_Education new_Applicant = applicant_educationService.updateApplicant_Education(applicant_education);
//            return new ResponseEntity<>(new_Applicant, HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public ResponseEntity<Applicant_Education> updateEducationById(@PathVariable("id") Long id){
//
//        try {
//            Applicant_Education applicant_education = applicant_educationService.updateEducationById(id);
//            return new ResponseEntity<>(applicant_education,HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Applicant_Education> deleteApplicant_Education(@PathVariable("id") Long id){
        try{
            applicant_educationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
