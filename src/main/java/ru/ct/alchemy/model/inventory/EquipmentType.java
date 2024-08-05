package ru.ct.alchemy.model.inventory;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EquipmentType {
    WAND("Волшебная палочка"),
    CAULDRON("Котёл"),
    HAMMER("Молот"),
    ;

    private final String prettyName;
}
