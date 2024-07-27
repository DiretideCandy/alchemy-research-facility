package ru.ct.alchemy.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.ct.alchemy.model.inventory.Material;

@Getter
@Setter
@Builder
public class MaterialDTO {
    private Long id;
    private String name;
    private String type;
    private Integer amount;

    public Material toMaterial(){
        return Material.builder()
                .id(id)
                .name(name)
                .type(type)
                .amount(amount)
                .build();
    }

    public static MaterialDTO fromMaterial(Material equipment){
        return MaterialDTO.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .type(equipment.getType())
                .amount(equipment.getAmount())
                .build();
    }
}
