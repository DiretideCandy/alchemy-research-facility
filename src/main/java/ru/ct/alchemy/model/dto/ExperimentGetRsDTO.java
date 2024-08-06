package ru.ct.alchemy.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ExperimentGetRsDTO {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private String createdBy;
    private String approvedBy;
    private String statusName;
    private String statusDescription;
    private String equipmentName;
    private String equipmentType;
    private String equipmentTypePrettyName;
    private List<MaterialDTO> materials;
    private String actionName;
    private String reportText;
    private String reportResult;
    private Integer progress;
}
