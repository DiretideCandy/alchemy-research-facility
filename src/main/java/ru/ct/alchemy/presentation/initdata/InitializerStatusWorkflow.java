package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.experiment.ExperimentStatusWorkflow;
import ru.ct.alchemy.model.experiment.ExperimentStatusWorkflowPK;
import ru.ct.alchemy.repositories.ExperimentStatusWorkflowRepository;


@Component
@AllArgsConstructor
public class InitializerStatusWorkflow {

    private final ExperimentStatusWorkflowRepository experimentStatusWorkflowRepository;
    private final PresentationData presentationData;

    @Transactional
    public void createAllStatusWorkflow() {
        // предполагаем, что initializerStatus уже выполнил свою работу //

        // заполняем процессы
        presentationData.getWorkflow().stream()
                .map(triple -> ExperimentStatusWorkflow.builder()
                        .id(new ExperimentStatusWorkflowPK(
                                triple.first(),
                                triple.second()))
                        .comment(triple.third())
                        .build())
                .forEach(experimentStatusWorkflowRepository::save);

    }
}
