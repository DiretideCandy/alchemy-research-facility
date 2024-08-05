package ru.ct.alchemy.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.model.mappers.ExperimentMapper;
import ru.ct.alchemy.repositories.ActionRepository;
import ru.ct.alchemy.repositories.EquipmentRepository;
import ru.ct.alchemy.repositories.ExperimentRepository;
import ru.ct.alchemy.repositories.MaterialRepository;
import ru.ct.alchemy.services.interfaces.ExperimentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

    private final ExperimentRepository experimentRepository;

    private final ExperimentMapper experimentMapper;
    private final MaterialRepository materialRepository;
    private final EquipmentRepository equipmentRepository;
    private final ActionRepository actionRepository;

    @Override
    public List<ExperimentGetAllRsDTO> findAll() {
        return experimentRepository.findAll()
                .stream()
                .map(experimentMapper::toGetAllRsDTO)
                .toList();
    }
    @Override
    @Transactional
    public ExperimentCreateRsDTO create(ExperimentCreateRqDTO experimentCreateRqDTO) {
        return experimentMapper.toCreateRsDTO(
                experimentRepository.save(
                        experimentMapper.fromCreateRqDTO(
                                experimentCreateRqDTO)));
    }

    @Override
    public Optional<ExperimentGetRsDTO> findById(long id) {
        return experimentRepository.findById(id)
                .map(experimentMapper::toGetRsDTO);
    }

    @Override
    @Transactional
    public void removeMaterial(long id, int index) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.FILLED_IN
            && experiment.getStatus() != ExperimentStatus.CREATED)
            return;

        List<Material> materials = experiment.getMaterials();
        if (index >= 0 && index < materials.size()) {

            materials.remove(index);
            if (materials.isEmpty() && experiment.getStatus() != ExperimentStatus.FILLED_IN)
                experiment.setStatus(ExperimentStatus.CREATED);

            experimentRepository.save(experiment);

        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    @Transactional
    public void addMaterial(long id, long materialId) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.FILLED_IN
                && experiment.getStatus() != ExperimentStatus.CREATED)
            return;

        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new EntityNotFoundException("Материал #"+id+" не найден"));

        experiment.getMaterials().add(material);
        if (experiment.getStatus() == ExperimentStatus.CREATED && experiment.filledIn())
            experiment.setStatus(ExperimentStatus.FILLED_IN);

        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void updateEquipment(long id, long equipmentId) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.FILLED_IN
                && experiment.getStatus() != ExperimentStatus.CREATED)
            return;

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Оборудование #"+equipmentId+" не найдено"));

        experiment.setEquipment(equipment);
        if (experiment.getStatus() == ExperimentStatus.CREATED && experiment.filledIn())
            experiment.setStatus(ExperimentStatus.FILLED_IN);

        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void updateAction(long id, long actionId) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.FILLED_IN
                && experiment.getStatus() != ExperimentStatus.CREATED)
            return;

        Action action = actionRepository.findById(actionId)
                .orElseThrow(() -> new EntityNotFoundException("Действие #"+actionId+" не найдено"));

        experiment.setAction(action);
        if (experiment.getStatus() == ExperimentStatus.CREATED && experiment.filledIn())
            experiment.setStatus(ExperimentStatus.FILLED_IN);

        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void approve(long id) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.FILLED_IN)
            return;

        experiment.setStatus(ExperimentStatus.APPROVED);
        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void start(long id) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.APPROVED)
            return;

        experiment.setStatus(ExperimentStatus.RUNNING);
        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void finish(long id) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.RUNNING)
            return;

        experiment.setStatus(ExperimentStatus.FINISHED);
        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void createReport(long id, String reportText, String reportResult) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        if (experiment.getStatus() != ExperimentStatus.FINISHED)
            return;

        experiment.setReport(
                Report.builder()
                        .text(reportText)
                        .result(reportResult)
                        .build()
        );

        experiment.setStatus(ExperimentStatus.REPORTED);
        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void cancel(long id) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        experiment.setStatus(ExperimentStatus.CANCELLED);
        experimentRepository.save(experiment);
    }
}
