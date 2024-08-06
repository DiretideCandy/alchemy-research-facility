package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.dto.ActionDTO;
import ru.ct.alchemy.model.inventory.EquipmentType;

@Mapper
public interface ActionMapper {
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    @Mapping(target = "equipmentType", source = "equipmentType", qualifiedByName = "getEquipmentType")
    ActionDTO toDTO(Action action);

    @Named("getEquipmentType")
    default String getEquipmentType(EquipmentType equipmentType){
        return equipmentType.name();
    }
}
