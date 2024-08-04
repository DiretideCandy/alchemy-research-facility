package ru.ct.alchemy.services.interfaces;

import ru.ct.alchemy.model.dto.ActionDTO;

import java.util.List;

public interface ActionService {
    List<ActionDTO> findByEquipmentType(String equipmentType);
}
