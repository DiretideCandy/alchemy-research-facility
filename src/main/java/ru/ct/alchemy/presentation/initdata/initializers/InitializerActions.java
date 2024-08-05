package ru.ct.alchemy.presentation.initdata.initializers;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.presentation.initdata.Initializer;
import ru.ct.alchemy.presentation.initdata.PresentationData;
import ru.ct.alchemy.repositories.ActionRepository;

@Component
@AllArgsConstructor
@Order(5)
public class InitializerActions implements Initializer {

    private final PresentationData presentationData;
    private final ActionRepository actionRepository;

    @Override
    @Transactional
    public void create(){
        actionRepository.saveAll(presentationData.getActions());
    }
}
