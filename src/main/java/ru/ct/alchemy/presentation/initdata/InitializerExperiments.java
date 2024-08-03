package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.repositories.EquipmentRepository;
import ru.ct.alchemy.repositories.ExperimentRepository;
import ru.ct.alchemy.repositories.MaterialRepository;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class InitializerExperiments {
    private final ExperimentRepository experimentRepository;
    private final EquipmentRepository equipmentRepository;
    private final MaterialRepository materialRepository;

    @Transactional
    public void createExperiments(){
        experimentRepository.save(
                Experiment.builder()
                        .createdAt(new Date())
                        .createdBy("Some Scientist")
                        .status(ExperimentStatus.FILLED_IN)
                        .equipment(equipmentRepository.findById(1L).orElse(null))
                        .materials(List.of(
                                materialRepository.findById(1L).orElse(null),
                                materialRepository.findById(2L).orElse(null)
                        ))
                        .build()
        );

        experimentRepository.save(
                Experiment.builder()
                        .createdAt(new Date())
                        .createdBy("Some Other Scientist")
                        .status(ExperimentStatus.FILLED_IN)
                        .equipment(equipmentRepository.findById(2L).orElse(null))
                        .materials(List.of(
                                materialRepository.findById(2L).orElse(null),
                                materialRepository.findById(1L).orElse(null)
                        ))
                        .build()
        );
    }
}
