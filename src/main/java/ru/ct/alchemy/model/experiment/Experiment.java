package ru.ct.alchemy.model.experiment;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ct.alchemy.model.Report;

import java.util.Date;

@Entity
@Table(name = "experiments", schema = "research")
@Getter
@Setter
@ToString
public class Experiment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "report")
    private Report report;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ExperimentStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @PrePersist
    @PreUpdate
    private void everyUpdate(){
        lastUpdatedAt = new Date();
        if (status == null)
            status = ExperimentStatus.CREATED;
    }
}
