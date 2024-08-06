package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "equipmentType", source = "equipment", qualifiedByName = "getEquipmentType")
@Mapping(target = "equipmentTypePrettyName", source = "equipment", qualifiedByName = "getEquipmentTypePrettyName")
@Mapping(target = "actionName", source = "action", qualifiedByName = "getActionName")
@Mapping(target = "approvedBy", source = "approvedBy", qualifiedByName = "getNullableString")
public @interface ExperimentFieldsMappings { }
