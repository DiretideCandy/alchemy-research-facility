package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.experiment.ExperimentStatusWorkflow;
import ru.ct.alchemy.model.experiment.ExperimentWorkflowPK;
import ru.ct.alchemy.repository.ExperimentStatusWorkflowRepository;

import java.util.Map;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class InitializerStatusWorkflow {

    private final ExperimentStatusWorkflowRepository experimentStatusWorkflowRepository;
    private final InitializerStatus initializerStatus;
    private final Data data;

    public void createAllStatusWorkflow() {
        // предполагаем, что initializerStatus уже выполнил свою работу //

        // получаем из initializerStatus созданные статусы, превращаем список в map (ключ - name)
        Map<String, ExperimentStatus> statusMap = initializerStatus.getCreatedStatusList()
                .stream()
                .collect(Collectors.toMap(ExperimentStatus::getName, status -> status));

        // заполняем процессы
        data.getWorkflow().stream()
                .map(triple -> ExperimentStatusWorkflow.builder()
                        .id(new ExperimentWorkflowPK(
                                statusMap.get(triple.first()),
                                statusMap.get(triple.second())
                        ))
                        .comment(triple.third())
                        .build())
                .forEach(experimentStatusWorkflowRepository::save);

    }
}
