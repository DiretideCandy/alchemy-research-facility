package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.repository.ExperimentStatusRepository;

import java.util.List;

@Component
@AllArgsConstructor
public class InitializerStatus {


    @Getter
    private List<ExperimentStatus> createdStatusList;

    private final ExperimentStatusRepository experimentStatusRepository;
    private final Data data;

    public void createAllStatus(){
        createdStatusList = data.getStatusList().stream()
                .map(pair -> ExperimentStatus.builder().name(pair.first()).description(pair.second()).build())
                .map(experimentStatusRepository::save)
                .toList();
    }

}
