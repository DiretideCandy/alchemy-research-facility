package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Orchestrator {

    private final InitializerStatusWorkflow initializerStatusWorkflow;
    private final InitializerEnums initializerEnums;
    private final InitializerMaterials initializerMaterials;
    private final InitializerEquipment initializerEquipment;
    private final InitializerActions initializerActions;
    private final InitializerExperiments initializerExperiments;

    @EventListener(ApplicationReadyEvent.class)
    public void createAll(){
        log.info("Началась инициализация тестовых данных в БД ... ");

        initializerEnums.createAllStatuses();
        initializerEnums.createAllInventoryTypes();

        initializerStatusWorkflow.createAllStatusWorkflow();
        initializerMaterials.createMaterials();
        initializerEquipment.createEquipment();
        initializerActions.createActions();


        initializerExperiments.createExperiments();

        log.info("Инициализация тестовых данных в БД завершена!");
    }
}
