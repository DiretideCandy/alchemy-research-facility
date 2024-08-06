package ru.ct.alchemy.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.dto.*;
import ru.ct.alchemy.model.dto.experiments.*;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.model.mappers.ExperimentMapper;
import ru.ct.alchemy.repositories.*;
import ru.ct.alchemy.services.interfaces.ExperimentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

    private final ExperimentMapper experimentMapper;
    private final ExperimentRepository experimentRepository;

    private final MaterialRepository materialRepository;
    private final EquipmentRepository equipmentRepository;
    private final ActionRepository actionRepository;
    private final ReportRepository reportRepository;

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public Optional<ExperimentGetRsDTO> findById(long id) {
        return experimentRepository.findById(id)
                .map(experimentMapper::toGetRsDTO);
    }

    @Override
    public List<ExperimentPresentationDTO> findByStatus(ExperimentStatus experimentStatus) {
        return experimentRepository.findByStatus(experimentStatus)
                .stream()
                .map(experimentMapper::toPresentationDTO)
                .toList();
    }

    @Override
    @Transactional
    public void removeMaterial(long id, int index) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        throwIfNotEditable(experiment);

        List<Material> materials = experiment.getMaterials();
        if (index >= 0 && index < materials.size()) {

            materials.remove(index);
            if (materials.isEmpty() && experiment.getStatus() == ExperimentStatus.FILLED_IN)
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

        throwIfNotEditable(experiment);

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

        throwIfNotEditable(experiment);

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Оборудование #"+equipmentId+" не найдено"));

        experiment.setEquipment(equipment);
        experiment.setAction(null);
        if (experiment.getStatus() == ExperimentStatus.FILLED_IN)
            experiment.setStatus(ExperimentStatus.CREATED);

        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void updateAction(long id, long actionId) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден"));

        throwIfNotEditable(experiment);

        Action action = actionRepository.findById(actionId)
                .orElseThrow(() -> new EntityNotFoundException("Действие #"+actionId+" не найдено"));

        experiment.setAction(action);
        if (experiment.getStatus() == ExperimentStatus.CREATED && experiment.filledIn())
            experiment.setStatus(ExperimentStatus.FILLED_IN);

        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void approve(long id, String approvedBy) {
        Experiment experiment = experimentRepository.findByIdAndStatus(id, ExperimentStatus.FILLED_IN)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден " +
                        "или не в статусе " + ExperimentStatus.FILLED_IN.getDescription()));

        experiment.setStatus(ExperimentStatus.APPROVED);
        experiment.setApprovedBy(approvedBy);
        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void start(long id) {
        Experiment experiment = experimentRepository.findByIdAndStatus(id, ExperimentStatus.APPROVED)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден " +
                        "или не в статусе " + ExperimentStatus.APPROVED.getDescription()));

        experiment.setStatus(ExperimentStatus.RUNNING);
        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void finish(long id) {
        Experiment experiment = experimentRepository.findByIdAndStatus(id, ExperimentStatus.RUNNING)
                .orElseThrow(() -> new EntityNotFoundException("Эксперимент #"+id+" не найден " +
                        "или не в статусе " + ExperimentStatus.RUNNING.getDescription()));

        experiment.setStatus(ExperimentStatus.FINISHED);
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

    @Override
    @Transactional
    public void changeProgress(long id, int increment){
        Experiment experiment = experimentRepository.findByIdAndStatus(id, ExperimentStatus.RUNNING)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Эксперимент #"+id+" не найден " +
                                "или не в статусе " + ExperimentStatus.RUNNING.getDescription()
                ));
        int newProgress = Math.max(Math.min(100, experiment.getProgress() + increment), 0);
        experiment.setProgress(newProgress);
        if (newProgress == 100)
            experiment.setStatus(ExperimentStatus.FINISHED);

        experimentRepository.save(experiment);
    }

    @Override
    @Transactional
    public void createReport(long id, ReportDTO reportDTO) {
        Experiment experiment = experimentRepository.findByIdAndStatus(id, ExperimentStatus.FINISHED)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Эксперимент #"+id+" не найден " +
                                "или не в статусе " + ExperimentStatus.FINISHED.getDescription()));

        Report report = reportRepository.save(Report.builder()
                .experiment(experiment)
                .text(reportDTO.getText())
                .result(reportDTO.getResult())
                .build());

        experiment.setStatus(ExperimentStatus.REPORTED);
        experimentRepository.save(experiment);
    }


    private void throwIfNotEditable(Experiment experiment) throws EntityNotFoundException {
        if (experiment.getStatus() != ExperimentStatus.FILLED_IN
                && experiment.getStatus() != ExperimentStatus.CREATED)
            throw new EntityNotFoundException("Эксперимент #"+experiment.getId()+" не в статусе "
                    +ExperimentStatus.FILLED_IN.getDescription()
                    + " или " + ExperimentStatus.CREATED.getDescription());
    }
}
