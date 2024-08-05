package ru.ct.alchemy.presentation.initdata.initializers;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.experiment.ExperimentStatusEntity;
import ru.ct.alchemy.model.inventory.EquipmentType;
import ru.ct.alchemy.model.inventory.EquipmentTypeEntity;
import ru.ct.alchemy.model.inventory.MaterialType;
import ru.ct.alchemy.model.inventory.MaterialTypeEntity;
import ru.ct.alchemy.presentation.initdata.Initializer;

import java.util.Arrays;

@Component
@AllArgsConstructor
@Order(1)
public class InitializerEnums implements Initializer {

    private EntityManager entityManager;

    @Override
    @Transactional
    public void create() {
        // ExperimentStatus
        Arrays.stream(ExperimentStatus.values())
                .map(ExperimentStatusEntity::createEntity)
                .forEach(entityManager::persist);

        //EquipmentType
        Arrays.stream(EquipmentType.values())
                .map(EquipmentTypeEntity::createEntity)
                .forEach(entityManager::persist);

        //MaterialType
        Arrays.stream(MaterialType.values())
                .map(MaterialTypeEntity::createEntity)
                .forEach(entityManager::persist);

    }


}
