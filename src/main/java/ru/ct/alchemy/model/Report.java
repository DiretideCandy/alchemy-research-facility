package ru.ct.alchemy.model;

import jakarta.persistence.*;
import lombok.*;
import ru.ct.alchemy.model.experiment.Experiment;

@Entity
@Table(name = "reports", schema = "research")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "experiment_id", referencedColumnName = "id")
    private Experiment experiment;

    @Column(name="text", columnDefinition = "text")
    private String text;

    @Column(name = "result")
    private String result;
}
