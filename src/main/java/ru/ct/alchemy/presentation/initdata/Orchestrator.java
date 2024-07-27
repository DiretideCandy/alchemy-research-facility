package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Orchestrator {

    private final InitializerStatusWorkflow initializerStatusWorkflow;
    private final InitializerStatus initializerStatus;

    @EventListener(ApplicationReadyEvent.class)
    public void createAll(){
        initializerStatus.createAllStatus();
        initializerStatusWorkflow.createAllStatusWorkflow();
    }
}
