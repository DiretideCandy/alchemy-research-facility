package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.model.inventory.MaterialType;

@Mapper
public interface MaterialMapper {
    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);

    @Mapping(target = "type", source = "type", qualifiedByName = "getMaterialTypeName")
    @Mapping(target = "typePrettyName", source = "type", qualifiedByName = "getMaterialTypePrettyName")
    MaterialDTO toDTO(Material material);
    Material fromDTO(MaterialDTO materialDTO);

    @Named("getMaterialTypePrettyName")
    default String getMaterialTypePrettyName(MaterialType type){
        return type.getPrettyName();
    }

    @Named("getMaterialTypeName")
    default String getMaterialTypeName(MaterialType type){
        return type.name();
    }
}
