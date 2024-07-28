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
    private final InitializerStatus initializerStatus;

    @EventListener(ApplicationReadyEvent.class)
    public void createAll(){
        initializerStatus.createAllStatuses();
        initializerStatusWorkflow.createAllStatusWorkflow();

        log.info("Данные загружены в БД");
    }
}
