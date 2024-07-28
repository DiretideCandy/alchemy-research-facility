package ru.ct.alchemy.model.inventory;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaterialType {
    POTION("Зелье"),
    FLORA("Растительность"),
    FAUNA("Живность"),
    METAL("Металл"),

    ;

    private final String name;
}
