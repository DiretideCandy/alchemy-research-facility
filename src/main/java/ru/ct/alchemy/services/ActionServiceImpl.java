package ru.ct.alchemy.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ct.alchemy.model.dto.ActionDTO;
import ru.ct.alchemy.model.inventory.EquipmentType;
import ru.ct.alchemy.model.mappers.ActionMapper;
import ru.ct.alchemy.repositories.ActionRepository;
import ru.ct.alchemy.services.interfaces.ActionService;

import java.util.List;

@Service
@AllArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;
    private final ActionMapper actionMapper;

    public List<ActionDTO> findByEquipmentType(String equipmentTypeString) {
        EquipmentType equipmentType = EquipmentType.valueOf(equipmentTypeString);
        return actionRepository.findActionByEquipmentType(equipmentType)
                .stream()
                .map(actionMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public List<ActionDTO> findAll() {
        return actionRepository.findAll()
                .stream()
                .map(actionMapper.INSTANCE::toDTO)
                .toList();
    }
}
