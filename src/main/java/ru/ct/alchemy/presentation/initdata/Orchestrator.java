package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class Orchestrator {

    private final List<Initializer> initializersOrderedList;

    @EventListener(ApplicationReadyEvent.class)
    public void createAll(){
        log.info("Началась инициализация тестовых данных в БД ... ");

        initializersOrderedList.forEach(i -> {
            log.info("Инициализация {}", i.getClass().getSuperclass().getSimpleName());
            i.create();
        });

        log.info("Инициализация тестовых данных в БД завершена!");
    }
}
