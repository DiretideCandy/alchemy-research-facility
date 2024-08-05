package ru.ct.alchemy.presentation.initdata.initializers;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.presentation.initdata.Initializer;
import ru.ct.alchemy.presentation.initdata.PresentationData;
import ru.ct.alchemy.repositories.EquipmentRepository;

@Component
@AllArgsConstructor
@Order(4)
public class InitializerEquipment implements Initializer {
    private final PresentationData presentationData;
    private final EquipmentRepository equipmentRepository;

    @Override
    @Transactional
    public void create(){
        equipmentRepository.saveAll(presentationData.getEquipment());
    }
}