package ru.ct.alchemy.presentation.initdata;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.experiment.ExperimentStatusEntity;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class InitializerStatus {

    private EntityManager entityManager;

    @Transactional
    public void createAllStatuses(){
        Arrays.stream(ExperimentStatus.values())
                .map(ExperimentStatusEntity::createEntity)
                .forEach(entityManager::persist);
    }

}
