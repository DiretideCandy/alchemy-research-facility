package ru.ct.alchemy.model.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipment_type", schema = "research")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentTypeEntity {
    @Id
    @Column(name = "name")
    private String name;

    public static EquipmentTypeEntity createEntity(EquipmentType equipmentType) {
        return new EquipmentTypeEntity(
                equipmentType.name()
        );
    }
}
