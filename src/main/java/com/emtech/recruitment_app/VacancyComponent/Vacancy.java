package com.emtech.recruitment_app.VacancyComponent;

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
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String vacancy;
    private String department;
    private String level;
    private String requirements;
    private LocalDateTime closing_date;


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
