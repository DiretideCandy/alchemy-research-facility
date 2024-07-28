package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;

@Mapper
public interface ExperimentMapper {

    ExperimentMapper INSTANCE = Mappers.getMapper(ExperimentMapper.class);

    Experiment fromCreateRqDTO(ExperimentCreateRqDTO experimentCreateRqDTO);

    @ExperimentMappings
    ExperimentCreateRsDTO toCreateRsDTO(Experiment experiment);

    @Named("getStatusName")
    default String getStatusName(ExperimentStatus status) {
        return status.name();
    }

    @Named("getStatusDescription")
    default String getStatusDescription(ExperimentStatus status) {
        return status.getDescription();
    }

}
