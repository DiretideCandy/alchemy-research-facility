package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ct.alchemy.configuration.ExtraPropertiesHolder;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.model.dto.experiments.*;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.model.inventory.Material;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExperimentMapper {

    @Autowired
    protected ExtraPropertiesHolder extraPropertiesHolder;

    public abstract Experiment fromCreateRqDTO(ExperimentCreateRqDTO experimentCreateRqDTO);

    public abstract ExperimentCreateRsDTO toCreateRsDTO(Experiment experiment);

    @ExperimentMappingsForStatus
    public abstract ExperimentGetAllRsDTO toGetAllRsDTO(Experiment experiment);

    @ExperimentMappingsForStatus
    @ExperimentFieldsMappings
    @ExperimentPresentationMappings
    public abstract ExperimentGetRsDTO toGetRsDTO(Experiment experiment);

    @ExperimentPresentationMappings
    public abstract ExperimentPresentationDTO toPresentationDTO(Experiment experiment);

    @Named("getStatusName")
    protected String getStatusName(ExperimentStatus status) {
        return status.name();
    }

    @Named("getStatusDescription")
    protected String getStatusDescription(ExperimentStatus status) {
        return status.getDescription();
    }

    @Named("getEquipmentName")
    protected String getEquipmentName(Equipment equipment) {
        return equipment == null
                ? extraPropertiesHolder.getUnknown()
                : equipment.getName();
    }

    @Named("getEquipmentType")
    protected String getEquipmentType(Equipment equipment) {
        return equipment == null
                ? extraPropertiesHolder.getUnknown()
                : equipment.getType().name();
    }

    @Named("getEquipmentTypePrettyName")
    protected String getEquipmentTypePrettyName(Equipment equipment) {
        return equipment == null
                ? extraPropertiesHolder.getUnknown()
                : equipment.getType().getPrettyName();
    }

    @Named("getActionName")
    protected String getActionName(Action action) {
        return action == null
                ? extraPropertiesHolder.getUnknown()
                : action.getName();
    }

    @Named("getReportId")
    protected Long getReportId(Report report) {
        return report == null
                ? -1
                : report.getId();
    }

    @Named("getNullableString")
    protected String getNullableString(String string) {
        return string == null
                ? extraPropertiesHolder.getUnknown()
                : string;
    }

    @Named("getMaterialDTO")
    protected List<MaterialDTO> getMaterialDTO(List<Material> materials) {
        return materials.stream()
                .map(MaterialMapper.INSTANCE::toDTO)
                .toList();
    }
}
