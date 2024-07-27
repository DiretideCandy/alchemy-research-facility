package ru.ct.alchemy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.dto.EquipmentDTO;
import ru.ct.alchemy.repository.EquipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService{

    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<EquipmentDTO> findAll() {
        return equipmentRepository.findAll()
                .stream()
                .map(EquipmentDTO::fromEquipment)
                .toList();
    }

    public Optional<EquipmentDTO> findById(long id) {
        return equipmentRepository.findById(id).map(EquipmentDTO::fromEquipment);
    }

    @Transactional
    public EquipmentDTO save(EquipmentDTO equipmentDto) {
        equipmentRepository.save(equipmentDto.toEquipment());
        return equipmentDto;
    }

    @Transactional
    public EquipmentDTO update(EquipmentDTO updatedEquipmentDto) {
        equipmentRepository.save(updatedEquipmentDto.toEquipment());
        return updatedEquipmentDto;
    }

    @Transactional
    public void delete(long id) {
        equipmentRepository.deleteById(id);
    }

}
