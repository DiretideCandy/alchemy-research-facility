package ru.ct.alchemy.presentation.initdata.initializers;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.experiment.ExperimentStatusWorkflow;
import ru.ct.alchemy.model.experiment.ExperimentStatusWorkflowPK;
import ru.ct.alchemy.presentation.initdata.Initializer;
import ru.ct.alchemy.presentation.initdata.PresentationData;
import ru.ct.alchemy.repositories.ExperimentStatusWorkflowRepository;


@Component
@AllArgsConstructor
@Order(2)
public class InitializerStatusWorkflow implements Initializer {

    private final ExperimentStatusWorkflowRepository experimentStatusWorkflowRepository;
    private final PresentationData presentationData;

    @Override
    @Transactional
    public void create() {
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
