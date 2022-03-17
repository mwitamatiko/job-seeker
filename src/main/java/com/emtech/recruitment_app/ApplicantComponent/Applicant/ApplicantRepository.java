package com.emtech.recruitment_app.ApplicantComponent.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    Optional<Applicant> findApplicantById(Long id);


}
