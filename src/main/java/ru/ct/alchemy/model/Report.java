package ru.ct.alchemy.model;

import jakarta.persistence.*;
import lombok.*;
import ru.ct.alchemy.model.experiment.Experiment;

@Entity
@Table(name = "reports", schema = "research")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @OneToOne
    @JoinColumn(name = "experiment_id")
    private Experiment id;

    @Column(name="text")
    private String text;

    @Column(name = "result")
    private String result;
}
