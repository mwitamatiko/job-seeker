package com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationAcademics;

import com.emtech.recruitment_app.ApplicantComponent.Applicant.Applicant;
import com.emtech.recruitment_app.ApplicantComponent.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Applicant_EducationService {

    @Autowired
    private Applicant_EducationRepository applicant_educationRepository;

    /**
     * create new applicant_education
     * @param applicant_education
     * @return
     */
    public Applicant_Education addApplicant_Education(Applicant_Education applicant_education){
        try{
            return applicant_educationRepository.save(applicant_education);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find all applicant_educations in a list
     * @return
     */
    public List<Applicant_Education> findAllApplicant_Educations(){
        try {
            return applicant_educationRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find applicant_education using given id
     * @param id
     * @return
     */
    public Applicant_Education findApplicant_EducationById(Long id){
        try {
            return applicant_educationRepository.findById(id)
                    .orElseThrow(()->new NotFoundException("Applicant_Education "+id+" not found"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * update applicant_education
     * @param applicant_education
     * @return
     */
    public Applicant_Education updateApplicant_Education(Applicant_Education applicant_education){
        try {
            return applicant_educationRepository.save(applicant_education);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public Applicant_Education updateEducationById(Long id){
//        try {
//            return applicant_educationRepository.findEducationInfoById(id).orElseThrow(()-> new NotFoundException("Education "+id+" not found") );
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

    public Applicant_Education updateEducationById(Long id){
        try {
            return applicant_educationRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * delete an applicant_education using a given id
     * @param id
     */
    public void delete(Long id){
        try{
            applicant_educationRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
