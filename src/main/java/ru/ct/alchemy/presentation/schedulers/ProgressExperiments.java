package ru.ct.alchemy.presentation.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProgressExperiments {

    @Scheduled(fixedRate = 15000L) // TODO: переделать в cron
    private void run(){
        //System.out.println("ProgressExperiments.run()");
    }
}