package ru.ct.alchemy.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExperimentGetRsDTO {
    private String id;
    private Date createdAt;
    private String lastUpdatedAt;
    private String createdBy;
    private String statusName;
    private String statusDescription;
}
