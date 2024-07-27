package ru.ct.alchemy.model.experiment;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experiment_status", schema = "research")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "name", unique = true)
    private String name;
}
