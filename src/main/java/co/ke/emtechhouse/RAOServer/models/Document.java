package co.ke.emtechhouse.RAOServer.models;

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
public class Document {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String filename = "Undefined Department";
    @Column(nullable = false, updatable = false, unique = true)
    private String filenameref  = "Undefined";
    private String group_by = "Not Configured";
    private String  user_id = "Not Configured";

    private Boolean is_approved = false;
    private Boolean is_deleted = false;
    //*****************Timestamps *********************
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updated_at;
    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deleted_at;

}
