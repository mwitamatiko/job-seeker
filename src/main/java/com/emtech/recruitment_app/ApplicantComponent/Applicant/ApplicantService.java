package com.emtech.recruitment_app.ApplicantComponent.Applicant;

import com.emtech.recruitment_app.ApplicantComponent.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    /**
     * create new applicant
     * @param applicant
     * @return
     */
    public Applicant addApplicant(Applicant applicant){
        try{
            return applicantRepository.save(applicant);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find all applicants in a list
     * @return
     */
    public List<Applicant> findAllApplicants(){
       try {
           return applicantRepository.findAll();
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
    public Applicant findApplicantById(Long id){
        try {
            return applicantRepository.findById(id)
                    .orElseThrow(()->new NotFoundException("Applicant "+id+" not found"));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public Applicant updateApplicant(Long id, Applicant applicant) {
//
//        try{
//            if (applicantRepository.findById(id).isPresent()){
//                Applicant existingApplicant = applicantRepository.findById(id).get();
//
//                existingApplicant.setFirst_name(applicant.getFirst_name());
//                existingApplicant.setLast_name(applicant.getLast_name());
//                existingApplicant.setMiddle_name(applicant.getMiddle_name());
//                existingApplicant.setGender(applicant.getGender());
//                existingApplicant.setReligion(applicant.getReligion());
//                existingApplicant.setNational_id(applicant.getNational_id());
//                existingApplicant.setNationality(applicant.getNationality());
//                existingApplicant.setHome_county(applicant.getHome_county());
//                existingApplicant.setSub_county(applicant.getSub_county());
//                existingApplicant.setCurrent_county(applicant.getCurrent_county());
//                existingApplicant.setCurrent_country(applicant.getCurrent_country());
//                existingApplicant.setCurrent_sub_county(applicant.getCurrent_sub_county());
//                existingApplicant.setPostal_code(applicant.getPostal_code());
//                existingApplicant.setPostal_address(applicant.getPostal_address());
//                existingApplicant.setCity(applicant.getCity());
//                existingApplicant.setPersonal_phone(applicant.getPersonal_phone());
//                existingApplicant.setHome_telephone(applicant.getHome_telephone());
//                existingApplicant.setOther_telephone(applicant.getOther_telephone());
//                existingApplicant.setEmail_address(applicant.getEmail_address());
//                existingApplicant.setLinkedin(applicant.getLinkedin());
//                existingApplicant.setGithub(applicant.getGithub());
//                existingApplicant.setHighest_level_of_education(applicant.getHighest_level_of_education());
//                existingApplicant.setCourse_programme(applicant.getCourse_programme());
//                existingApplicant.setEnrollment_status(applicant.getEnrollment_status());
//
//
//                Applicant updatedApplicant = applicantRepository.save(existingApplicant);
//
//                return new Applicant();
//            }else{
//                return null;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
    /**
     * update applicant
     * @param applicant
     * @return
     */
    public Applicant updateApplicant(Applicant applicant){
        try {
            return applicantRepository.save(applicant);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public Applicant updateApplicantById(Long id){
//        try {
//            return applicantRepository.findPersonFileInfoById(id).orElseThrow(()-> new NotFoundException("Applicant "+id+" not found") );
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
    public Applicant updateApplicantById(Long id){
        try {
            return applicantRepository.findById(id).get();
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
            applicantRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
