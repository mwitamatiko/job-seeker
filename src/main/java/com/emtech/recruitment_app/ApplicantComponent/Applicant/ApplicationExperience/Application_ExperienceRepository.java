package com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Application_ExperienceRepository extends JpaRepository<Application_Experience,Long> {
    Optional<Application_Experience> findExperienceInfoById(Long id);
}
