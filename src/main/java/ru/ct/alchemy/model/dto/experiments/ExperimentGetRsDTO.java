package ru.ct.alchemy.model.dto.experiments;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ct.alchemy.model.dto.MaterialDTO;

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
    private Integer progress;
    private Long reportId;
}
