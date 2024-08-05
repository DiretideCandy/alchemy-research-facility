package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.repositories.ActionRepository;

@Component
@AllArgsConstructor
public class InitializerActions {

    private final PresentationData presentationData;
    private final ActionRepository actionRepository;

    @Transactional
    public void createActions(){
        actionRepository.saveAll(presentationData.getActions());
    }
}
