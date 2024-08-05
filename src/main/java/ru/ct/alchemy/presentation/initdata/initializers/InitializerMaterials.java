package ru.ct.alchemy.presentation.initdata.initializers;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.presentation.initdata.Initializer;
import ru.ct.alchemy.presentation.initdata.PresentationData;
import ru.ct.alchemy.repositories.MaterialRepository;

@Component
@AllArgsConstructor
@Order(3)
public class InitializerMaterials implements Initializer {

    private final PresentationData presentationData;
    private final MaterialRepository materialRepository;

    @Override
    @Transactional
    public void create(){
        materialRepository.saveAll(presentationData.getMaterials());
    }
}
