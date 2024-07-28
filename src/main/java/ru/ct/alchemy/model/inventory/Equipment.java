package ru.ct.alchemy.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import ru.ct.alchemy.model.experiment.Experiment;

import java.util.List;

@Entity
@Table(name = "equipment", schema = "research")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @OneToMany(mappedBy = "equipment")
    private List<Experiment> experiments;

}
