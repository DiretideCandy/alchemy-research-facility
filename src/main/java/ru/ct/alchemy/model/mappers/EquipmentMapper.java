package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.dto.EquipmentDTO;
import ru.ct.alchemy.model.inventory.Equipment;

@Mapper
public interface EquipmentMapper {
    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    EquipmentDTO toDTO(Equipment equipment);
    Equipment fromDTO(EquipmentDTO equipmentDTO);
}
