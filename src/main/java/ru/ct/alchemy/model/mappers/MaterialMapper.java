package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.model.inventory.Material;

@Mapper
public interface MaterialMapper {
    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);

    MaterialDTO toDTO(Material material);
    Material fromDTO(MaterialDTO materialDTO);
}
