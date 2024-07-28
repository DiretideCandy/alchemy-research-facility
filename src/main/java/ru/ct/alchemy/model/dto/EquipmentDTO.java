package ru.ct.alchemy.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipmentDTO {
    private Long id;
    private String name;
    private String type;
    private Integer amount;
}
