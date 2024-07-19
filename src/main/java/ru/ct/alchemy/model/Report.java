package ru.ct.alchemy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reports", schema = "research")
@Getter
@Setter
public class Report {
    @Id
    @OneToOne
    @JoinColumn(name = "experiment_id")
    private Experiment id;

    @Column(columnDefinition="text")
    private String text;
}
