package ru.ct.alchemy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.ct.alchemy.model.user.Manager;
import ru.ct.alchemy.model.user.Scientist;

@Entity
@Table(name = "experiments", schema = "research")
@Getter
@Setter
public class Experiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "report")
    private Report report;

    @ManyToOne // пока что только один учёный проводит эксперимент
    @JoinColumn(name = "executed_by")
    private Scientist executedBy;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Manager approvedBy;

    private int status;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date startedAt;

}
