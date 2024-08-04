package ru.ct.alchemy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExperimentCreateRqDTO {
    private Date createdAt;
    private String createdBy;
}
