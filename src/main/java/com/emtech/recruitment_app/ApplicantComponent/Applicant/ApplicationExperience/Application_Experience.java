package com.emtech.recruitment_app.ApplicantComponent.Applicant.ApplicationExperience;

import com.emtech.recruitment_app.ApplicantComponent.Applicant.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Application_Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long applicant_id;
    private String company_name;
    private String work_position;
    private String years_of_experience;
    private String referee_email;
    private String referee_name;
    private String referee_phone;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private Applicant applicant;


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
