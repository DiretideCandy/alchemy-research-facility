package ru.ct.alchemy.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.dto.EquipmentDTO;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    List<EquipmentDTO> findAll();

    Optional<EquipmentDTO> findById(long id);

    @Transactional
    EquipmentDTO save(EquipmentDTO equipment);

    @Transactional
    EquipmentDTO update(EquipmentDTO equipment);

    @Transactional
    void delete(long id);

}
