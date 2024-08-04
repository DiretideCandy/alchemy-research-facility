package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Equipment;

@Mapper
public interface ExperimentMapper {

    ExperimentMapper INSTANCE = Mappers.getMapper(ExperimentMapper.class);

    Experiment fromCreateRqDTO(ExperimentCreateRqDTO experimentCreateRqDTO);

    @ExperimentMappingsForStatus
    ExperimentCreateRsDTO toCreateRsDTO(Experiment experiment);

    @ExperimentMappingsForStatus
    ExperimentGetAllRsDTO toGetAllRsDTO(Experiment experiment);

    @ExperimentMappingsForStatus
    @ExperimentFieldsMappings
    ExperimentGetRsDTO toGetRsDTO(Experiment experiment);

    @Named("getStatusName")
    default String getStatusName(ExperimentStatus status) {
        return status.name();
    }

    @Named("getStatusDescription")
    default String getStatusDescription(ExperimentStatus status) {
        return status.getDescription();
    }

    @Named("getEquipmentName")
    default String getEquipmentName(Equipment equipment) {
        return equipment == null ? "Оборудование не выбрано" : equipment.getName();
    }

    @Named("getEquipmentType")
    default String getEquipmentType(Equipment equipment) {
        return equipment == null ? "Оборудование не выбрано" : equipment.getType().getName();
    }

    @Named("getActionName")
    default String getActionName(Action action) {
        return action == null ? "Действие не выбрано" : action.getName();
    }

    @Named("getReportText")
    default String getReportText(Report report) {
        return report == null ? "Отчёт не сформирован" : report.getText();
    }

    @Named("getReportResult")
    default String getReportResult(Report report) {
        return report == null ? "Отчёт не сформирован" : report.getResult();
    }

}
