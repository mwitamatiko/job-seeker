package com.emtech.recruitment_app.ApplicantComponent.Applicant;


import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationAcademics.Applicant_Education;
import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationAcademics.Applicant_EducationRepository;
import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience.Application_Experience;
import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience.Application_ExperienceRepository;
import com.emtech.recruitment_app.ApplicantComponent.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/api/v1/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private Applicant_EducationRepository applicant_educationRepository;
    @Autowired
    private Application_ExperienceRepository application_experienceRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Applicant>> getAllApplicants(){
        try {
            List<Applicant> applicantList = applicantService.findAllApplicants();
            return new ResponseEntity<>(applicantList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable("id") Long id){
        try {
            Applicant applicant = applicantService.findApplicantById(id);
            return new ResponseEntity<>(applicant,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addApplicant(@RequestBody Applicant applicant){
        try {
            Applicant newApplicant = applicantService.addApplicant(applicant);
            return new ResponseEntity<>(newApplicant,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * delete applicant
     * @param id
     * @param applicant
     * @return
     */
    @PutMapping("/update/applicant/{id}")
    public ResponseEntity<Applicant> updateApplicantById(@PathVariable("id") Long id, @RequestBody Applicant applicant){
        try {
            return new ResponseEntity<>(applicantRepository.save(applicant), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//    @PutMapping("/update/education/{id}")
//    public ResponseEntity<Applicant_Education> updateEducationById(@PathVariable("id") long id, @RequestBody Applicant_Education education){
//        try {
//            return new ResponseEntity<>(applicant_educationRepository.save(education), HttpStatus.OK);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    @PutMapping("/update/experience/{id}")
//    public ResponseEntity<Application_Experience> updateExperienceById(@PathVariable("id") long id, @RequestBody Application_Experience experience){
//        try {
//            return new ResponseEntity<>(application_experienceRepository.save(experience), HttpStatus.OK);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> update(@RequestBody Applicant applicant, @PathVariable("id") Long id) {
////        try {
////            Applicant existApplicant = applicantService.updateApplicantById(id);
////            applicantService.addApplicant(applicant);
////            return new ResponseEntity<>(HttpStatus.OK);
////        } catch (NotFoundException e) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
//       try {
//           Optional<Applicant> applicantData = applicantRepository.findApplicantById(id);
//           if(applicantData.isPresent()){
//               Applicant applicant1 = applicantData.get();
////               applicant1.setId(applicant.getId());
//               applicant1.setFirst_name(applicant.getFirst_name());
//               applicant1.setLast_name(applicant.getLast_name());
//               applicant1.setMiddle_name(applicant.getMiddle_name());
//               applicant1.setGender(applicant.getGender());
//               applicant1.setReligion(applicant.getReligion());
//               applicant1.setNational_id(applicant.getNational_id());
//               applicant1.setNationality(applicant.getNationality());
//               applicant1.setHome_county(applicant.getHome_county());
//               applicant1.setSub_county(applicant.getSub_county());
//               applicant1.setCurrent_county(applicant.getCurrent_county());
//               applicant1.setCurrent_country(applicant.getCurrent_country());
//               applicant1.setCurrent_sub_county(applicant.getCurrent_sub_county());
//               applicant1.setPostal_code(applicant.getPostal_code());
//               applicant1.setPostal_address(applicant.getPostal_address());
//               applicant1.setCity(applicant.getCity());
//               applicant1.setPersonal_phone(applicant.getPersonal_phone());
//               applicant1.setHome_telephone(applicant.getHome_telephone());
//               applicant1.setOther_telephone(applicant.getOther_telephone());
//               applicant1.setEmail_address(applicant.getEmail_address());
//               applicant1.setLinkedin(applicant.getLinkedin());
//               applicant1.setGithub(applicant.getGithub());
//               applicant1.setHighest_level_of_education(applicant.getHighest_level_of_education());
//               applicant1.setCourse_programme(applicant.getCourse_programme());
//               applicant1.setEnrollment_status(applicant.getEnrollment_status());
//               return new ResponseEntity<>(applicantRepository.save(applicant1),HttpStatus.OK);
//           }else{
//               return ResponseEntity
//                       .badRequest()
//                       .body("Error: Applicant Not found");
//           }
//       }catch (Exception e){
//           e.printStackTrace();
//           return null;
//       }
//
//    }


    @DeleteMapping("/delete/applicant/{id}")
    public ResponseEntity<Applicant> deleteApplicant(@PathVariable("id") Long id){
        try{
            applicantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/delete/education/{id}")
    public ResponseEntity<Applicant_Education> deleteEducation(@PathVariable("id") Long id){
        try {
            applicant_educationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
           e.printStackTrace();
            return null;
        }
    }
    @DeleteMapping("/delete/experience/{id}")
    public ResponseEntity<Application_Experience> deleteExperience(@PathVariable("id") Long id){
        try {
            application_experienceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
