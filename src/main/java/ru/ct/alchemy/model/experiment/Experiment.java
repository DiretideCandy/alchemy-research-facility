package ru.ct.alchemy.model.experiment;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.model.inventory.Material;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "experiments", schema = "research")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ExperimentStatus status;

    @Column(name = "progress")
    private Integer progress;

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

    @Column(name = "approved_by")
    private String approvedBy;

    @ManyToOne
    @JoinColumn(name = "equipment")
    private Equipment equipment;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private Report report;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "experiment_material_map",
            schema = "research",
            joinColumns = @JoinColumn(name = "experiment_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id"))
    private List<Material> materials;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

    @PrePersist
    @PreUpdate
    private void everyUpdate() {
        lastUpdatedAt = new Date();

        // Инициализация обязательных полей:
        if (status == null) status = ExperimentStatus.CREATED;
        if (progress == null) progress = 0;
    }

    public boolean filledIn() {
        return (equipment != null
                && materials != null
                && !materials.isEmpty()
                && action != null);
    }
}
