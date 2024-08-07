package ru.ct.alchemy.services.interfaces;

import org.springframework.data.domain.Sort;
import ru.ct.alchemy.model.dto.*;
import ru.ct.alchemy.model.dto.experiments.*;
import ru.ct.alchemy.model.experiment.ExperimentStatus;

import java.util.List;
import java.util.Optional;

public interface ExperimentService {

    List<ExperimentGetAllRsDTO> findAll();

    ExperimentCreateRsDTO create(ExperimentCreateRqDTO experimentCreateRqDTO);

    Optional<ExperimentGetRsDTO> findById(long id);
    List<ExperimentPresentationDTO> findByStatus(ExperimentStatus experimentStatus);

    void removeMaterial(long id, int index);

    void addMaterial(long id, long materialId);

    void updateEquipment(long id, long equipmentId);

    void updateAction(long id, long actionId);

    void approve(long id, String approvedBy);

    void start(long id);

    void finish(long id);

    void cancel(long id);

    void changeProgress(long id, int increment);

    void createReport(long id, ReportDTO reportDTO);

    List<ExperimentGetAllRsDTO> findAllSortedAndFiltered(Sort sortObj, DateFilterStringDTO dateFilterDTO);
}
