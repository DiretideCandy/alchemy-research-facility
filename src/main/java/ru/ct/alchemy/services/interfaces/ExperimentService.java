package ru.ct.alchemy.services.interfaces;

import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;

public interface ExperimentService {
    ExperimentCreateRsDTO create(ExperimentCreateRqDTO experimentCreateRqDTO);
}
