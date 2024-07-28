package ru.ct.alchemy.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import ru.ct.alchemy.model.experiment.Experiment;

import java.util.List;

@Entity
@Table(name = "materials", schema = "research")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MaterialType type;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @ManyToMany(mappedBy = "materials")
    private List<Experiment> experiments;
}
