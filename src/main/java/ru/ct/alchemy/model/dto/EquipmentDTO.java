package ru.ct.alchemy.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.ct.alchemy.model.inventory.Equipment;

@Getter
@Setter
@Builder
public class EquipmentDTO {
    private Long id;
    private String name;
    private String type;
    private Integer amount;

    public Equipment toEquipment(){
        return Equipment.builder()
                .id(id)
                .name(name)
                .type(type)
                .amount(amount)
                .build();
    }

    public static EquipmentDTO fromEquipment(Equipment equipment){
        return EquipmentDTO.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .type(equipment.getType())
                .amount(equipment.getAmount())
                .build();
    }
}
