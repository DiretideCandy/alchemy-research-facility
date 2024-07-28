package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "statusName", source = "status", qualifiedByName = "getStatusName")
@Mapping(target = "statusDescription", source = "status", qualifiedByName = "getStatusDescription")
public @interface ExperimentMappingsForStatus { }
