package ru.ct.alchemy.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.model.mappers.ExperimentMapper;
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

        List<Material> materials = experiment.getMaterials();
        if (index >= 0 && index < materials.size()) {
            materials.remove(index);
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

        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new EntityNotFoundException("Материал #"+id+" не найден"));

        experiment.getMaterials().add(material);
        experimentRepository.save(experiment);
    }
}
