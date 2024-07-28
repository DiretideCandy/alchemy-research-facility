package ru.ct.alchemy.model.experiment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "experiment_status", schema = "research")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentStatusEntity {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public static ExperimentStatusEntity createEntity(ExperimentStatus experimentStatus){
        return new ExperimentStatusEntity(
                experimentStatus.name(),
                experimentStatus.getDescription()
        );
    }
}
