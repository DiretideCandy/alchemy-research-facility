package ru.ct.alchemy.model.dto.experiments;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ct.alchemy.model.dto.MaterialDTO;

import java.util.List;

@Getter
@Setter
@ToString
public class ExperimentPresentationDTO {
    private Long id;
    private String equipmentName;
    private List<MaterialDTO> materials;
    private Long reportId;
}
