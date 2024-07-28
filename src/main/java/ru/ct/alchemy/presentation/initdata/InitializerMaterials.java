package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.repositories.MaterialRepository;

@Component
@AllArgsConstructor
public class InitializerMaterials {

    private final PresentationData presentationData;
    private final MaterialRepository materialRepository;

    @Transactional
    public void createMaterials(){
        materialRepository.saveAll(presentationData.getMaterials());
    }
}
