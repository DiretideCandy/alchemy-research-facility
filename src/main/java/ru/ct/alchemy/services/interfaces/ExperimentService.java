package ru.ct.alchemy.services.interfaces;

import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;

import java.util.List;
import java.util.Optional;

public interface ExperimentService {

    List<ExperimentGetAllRsDTO> findAll();

    ExperimentCreateRsDTO create(ExperimentCreateRqDTO experimentCreateRqDTO);

    Optional<ExperimentGetRsDTO> findById(long id);
}
