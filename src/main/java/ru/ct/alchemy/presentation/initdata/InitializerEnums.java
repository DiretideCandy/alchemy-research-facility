package ru.ct.alchemy.presentation.initdata;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.experiment.ExperimentStatusEntity;
import ru.ct.alchemy.model.inventory.EquipmentType;
import ru.ct.alchemy.model.inventory.EquipmentTypeEntity;
import ru.ct.alchemy.model.inventory.MaterialType;
import ru.ct.alchemy.model.inventory.MaterialTypeEntity;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class InitializerEnums {

    private EntityManager entityManager;

    @Transactional
    public void createAllStatuses(){
        Arrays.stream(ExperimentStatus.values())
                .map(ExperimentStatusEntity::createEntity)
                .forEach(entityManager::persist);
    }

    @Transactional
    public void createAllInventoryTypes(){
        Arrays.stream(EquipmentType.values())
                .map(EquipmentTypeEntity::createEntity)
                .forEach(entityManager::persist);

        Arrays.stream(MaterialType.values())
                .map(MaterialTypeEntity::createEntity)
                .forEach(entityManager::persist);
    }

}
