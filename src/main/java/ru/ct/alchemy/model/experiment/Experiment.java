package ru.ct.alchemy.model.experiment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ct.alchemy.model.Report;

@Entity
@Table(name = "experiments", schema = "research")
@Getter
@Setter
@ToString
public class Experiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "report")
    private Report report;

    @ManyToOne
    @JoinColumn(name = "status")
    private ExperimentStatus status;

}
