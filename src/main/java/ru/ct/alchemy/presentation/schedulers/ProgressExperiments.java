package ru.ct.alchemy.presentation.schedulers;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.services.interfaces.ExperimentService;

import java.util.Random;

@Component
@AllArgsConstructor
public class ProgressExperiments {

    private final ExperimentService experimentService;

    @Scheduled(cron = "*/15 * * * * *")
    private void incrementProgress(){
        Random rnd = new Random();

        experimentService.findByStatus(ExperimentStatus.RUNNING)
                .forEach(exp -> experimentService.changeProgress(
                        exp.getId(),
                        rnd.nextInt(15,30)
                ));

    }
}
