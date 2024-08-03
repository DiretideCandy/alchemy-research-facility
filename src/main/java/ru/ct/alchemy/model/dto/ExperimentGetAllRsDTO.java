package ru.ct.alchemy.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExperimentGetAllRsDTO {
    private Long id;
    private Date createdAt;
    private String createdBy;
    private String statusName;
    private String statusDescription;
}