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
@Table(name = "material_type", schema = "research")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialTypeEntity {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "pretty_name")
    private String prettyName;

    public static MaterialTypeEntity createEntity(MaterialType materialType) {
        return new MaterialTypeEntity(
                materialType.name(),
                materialType.getPrettyName()
        );
    }
}
