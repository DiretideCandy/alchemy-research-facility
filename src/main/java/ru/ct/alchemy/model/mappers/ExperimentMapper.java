package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ct.alchemy.configuration.ExperimentInfoPageProperties;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Equipment;

@Mapper(componentModel = "spring")
public abstract class ExperimentMapper {

    @Autowired
    protected ExperimentInfoPageProperties experimentInfoPageProperties;

    public abstract Experiment fromCreateRqDTO(ExperimentCreateRqDTO experimentCreateRqDTO);

    public abstract ExperimentCreateRsDTO toCreateRsDTO(Experiment experiment);

    @ExperimentMappingsForStatus
    public abstract ExperimentGetAllRsDTO toGetAllRsDTO(Experiment experiment);

    @ExperimentMappingsForStatus
    @ExperimentFieldsMappings
    public abstract ExperimentGetRsDTO toGetRsDTO(Experiment experiment);

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
                ? experimentInfoPageProperties.getUnknown()
                : equipment.getName();
    }

    @Named("getEquipmentType")
    protected String getEquipmentType(Equipment equipment) {
        return equipment == null
                ? experimentInfoPageProperties.getUnknown()
                : equipment.getType().getName();
    }

    @Named("getActionName")
    protected String getActionName(Action action) {
        return action == null
                ? experimentInfoPageProperties.getUnknown()
                : action.getName();
    }

    @Named("getReportText")
    protected String getReportText(Report report) {
        return report == null
                ? experimentInfoPageProperties.getUnknown()
                : report.getText();
    }

    @Named("getReportResult")
    protected String getReportResult(Report report) {
        return report == null
                ? experimentInfoPageProperties.getUnknown()
                : report.getResult();
    }

}
