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

    void removeMaterial(long id, int index);

    void addMaterial(long id, long materialId);

    void updateEquipment(long id, long equipmentId);

    void updateAction(long id, long actionId);

    void approve(long id);

    void start(long id);

    void finish(long id);

    void createReport(long id, String reportText, String reportResult);

    void cancel(long id);
}
