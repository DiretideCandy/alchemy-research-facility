package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "equipmentName", source = "equipment", qualifiedByName = "getEquipmentName")
@Mapping(target = "equipmentType", source = "equipment", qualifiedByName = "getEquipmentType")
@Mapping(target = "actionName", source = "action", qualifiedByName = "getActionName")
@Mapping(target = "reportText", source = "report", qualifiedByName = "getReportText")
@Mapping(target = "reportResult", source = "report", qualifiedByName = "getReportResult")
@Mapping(target = "materials", source = "materials")
public @interface ExperimentFieldsMappings { }
