package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "equipmentName", source = "equipment", qualifiedByName = "getEquipmentName")
@Mapping(target = "materials", source = "materials", qualifiedByName = "getMaterialDTO")
@Mapping(target = "reportId", source = "report", qualifiedByName = "getReportId")
public @interface ExperimentPresentationMappings { }
