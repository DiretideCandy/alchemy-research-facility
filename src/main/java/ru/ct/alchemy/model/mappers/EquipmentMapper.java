package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.dto.EquipmentDTO;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.model.inventory.EquipmentType;

@Mapper
public interface EquipmentMapper {
    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    @Mapping(target = "type", source = "type", qualifiedByName = "getEquipmentTypeName")
    @Mapping(target = "typePrettyName", source = "type", qualifiedByName = "getEquipmentTypePrettyName")
    EquipmentDTO toDTO(Equipment equipment);
    Equipment fromDTO(EquipmentDTO equipmentDTO);

    @Named("getEquipmentTypePrettyName")
    default String getEquipmentTypePrettyName(EquipmentType type){
        return type.getPrettyName();
    }

    @Named("getEquipmentTypeName")
    default String getEquipmentTypeName(EquipmentType type){
        return type.name();
    }

}
