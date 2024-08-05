package ru.ct.alchemy.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaterialDTO {
    private Long id;
    private String name;
    private String type;
    private String typePrettyName;
    private Integer amount;
}
