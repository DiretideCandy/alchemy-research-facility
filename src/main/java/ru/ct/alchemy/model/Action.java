package ru.ct.alchemy.model;


import jakarta.persistence.*;
import lombok.*;
import ru.ct.alchemy.model.inventory.EquipmentType;

@Entity
@Table(name = "actions", schema = "research")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "equipment_type")
    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;

    @Column(name = "name")
    private String name;

}
