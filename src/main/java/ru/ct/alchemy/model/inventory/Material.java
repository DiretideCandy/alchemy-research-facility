package ru.ct.alchemy.model.inventory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materials", schema = "research")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Material implements InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String type;

    @Basic
    private String name;

    @Basic
    private int amount;

    public Material(){}

}
