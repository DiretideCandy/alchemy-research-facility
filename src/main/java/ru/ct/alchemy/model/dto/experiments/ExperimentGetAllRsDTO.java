package ru.ct.alchemy.model.dto.experiments;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ExperimentGetAllRsDTO {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private String createdBy;
    private String statusName;
    private String statusDescription;
    private Integer progress;
}
