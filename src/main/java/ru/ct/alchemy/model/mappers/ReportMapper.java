package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.dto.ReportDTO;
import ru.ct.alchemy.model.experiment.Experiment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Mapper
public interface ReportMapper {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);
    DateFormat df = new SimpleDateFormat("d MMMM yyyy", Locale.forLanguageTag("ru"));

    @Mapping(target = "experimentCreatedBy", source = "experiment", qualifiedByName = "getCreatedBy")
    @Mapping(target = "experimentApprovedBy", source = "experiment", qualifiedByName = "getApprovedBy")
    @Mapping(target = "experimentLastUpdatedBy", source = "experiment", qualifiedByName = "getLastUpdatedBy")
    @Mapping(target = "experimentId", source = "experiment", qualifiedByName = "getExperimentId")
    ReportDTO toDTO(Report report);

    @Named("getCreatedBy")
    default String getCreatedBy(Experiment experiment){
        return experiment.getCreatedBy();
    }

    @Named("getApprovedBy")
    default String getApprovedBy(Experiment experiment){
        return experiment.getApprovedBy();
    }

    @Named("getLastUpdatedBy")
    default String getLastUpdatedBy(Experiment experiment){
        return df.format(experiment.getLastUpdatedAt());
    }

    @Named("getExperimentId")
    default Long getExperimentId(Experiment experiment){
        return experiment.getId();
    }
}
