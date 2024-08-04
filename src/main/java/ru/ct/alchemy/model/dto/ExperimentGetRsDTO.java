package ru.ct.alchemy.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ExperimentGetRsDTO {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private String createdBy;
    private String statusName;
    private String statusDescription;
    private String equipmentName;
    private String equipmentType;
    private String equipmentTypeName;
    private List<MaterialInExperimentDTO> materials;
    private String actionName;
    private String reportText;
    private String reportResult;
}
