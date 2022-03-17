package com.emtech.recruitment_app.VacancyComponent;

import com.emtech.recruitment_app.ApplicantComponent.Applicant.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Vacancy_Repository extends JpaRepository<Vacancy,Long> {

    Optional<Vacancy> findApplicantById(Long id);
    
}
