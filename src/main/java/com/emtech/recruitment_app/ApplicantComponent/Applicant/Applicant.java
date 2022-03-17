package com.emtech.recruitment_app.ApplicantComponent.Applicant;

import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationAcademics.Applicant_Education;
import com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience.Application_Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String first_name;
    private String last_name;
    private String middle_name;
    private String gender;
    private String religion;
    private String national_id;
    private String nationality;
    private String home_county;
    private String sub_county;
    private String current_county;
    private String current_country;
    private String current_sub_county;
    private String postal_code;
    private String postal_address;
    private String city;
    private String personal_phone;
    private String home_telephone;
    private String other_telephone;
    private String email_address;
    private String linkedin;
    private String github;
    private String highest_level_of_education;
    private String course_programme;
    private String enrollment_status;

//
//    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    public List<Applicant_Education> applicant_educationList = new ArrayList<>();
//    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    public List<Application_Experience> application_experienceList = new ArrayList<>();

    //   GL Subheads
    @OneToMany(targetEntity = Applicant_Education.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private List<Applicant_Education> applicant_educations;

    @OneToMany(targetEntity = Application_Experience.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private List<Application_Experience> applicant_experiences;

//    @OneToMany(targetEntity = Application_Experience.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
//    private List<My_Application> my_applications;


    //*****************Operational Flag *********************
    private Boolean is_verified = false;
    private Boolean is_canceled = false;
    private Boolean is_deleted = false;

    //*****************Audit *********************
    private String created_by;
    private String verified_by;
    private String approved_by;
    private String deleted_by;
    private String canceled_by;

    //*****************Timestamps *********************
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updated_at;
    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deleted_at;
}
