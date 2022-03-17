package com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationAcademics;

import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience.Application_Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Applicant_EducationRepository extends JpaRepository<Applicant_Education, Long> {
    Optional<Applicant_Education> findEducationInfoById(Long id);
}
