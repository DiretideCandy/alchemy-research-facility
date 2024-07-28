package ru.ct.alchemy.presentation.initdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.repositories.EquipmentRepository;

@Component
@AllArgsConstructor
public class InitializerEquipment {
    private final PresentationData presentationData;
    private final EquipmentRepository equipmentRepository;

    @Transactional
    public void createEquipment(){
        equipmentRepository.saveAll(presentationData.getEquipment());
    }
}