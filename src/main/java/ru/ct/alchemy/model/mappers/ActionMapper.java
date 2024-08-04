package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.dto.ActionDTO;

@Mapper
public interface ActionMapper {
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    ActionDTO toDTO(Action action);
}
