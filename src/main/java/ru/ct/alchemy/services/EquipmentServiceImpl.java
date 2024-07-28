package ru.ct.alchemy.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.dto.EquipmentDTO;
import ru.ct.alchemy.model.mappers.EquipmentMapper;
import ru.ct.alchemy.repositories.EquipmentRepository;
import ru.ct.alchemy.services.interfaces.EquipmentService;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<EquipmentDTO> findAll() {
        return equipmentRepository.findAll()
                .stream()
                .map(EquipmentMapper.INSTANCE::toDTO)
                .toList();
    }

    public Optional<EquipmentDTO> findById(long id) {
        return equipmentRepository.findById(id).map(EquipmentMapper.INSTANCE::toDTO);
    }

    @Transactional
    public EquipmentDTO save(EquipmentDTO equipmentDto) {
        equipmentRepository.save(EquipmentMapper.INSTANCE.fromDTO(equipmentDto));
        return equipmentDto;
    }

    @Transactional
    public EquipmentDTO update(EquipmentDTO updatedEquipmentDto) {
        equipmentRepository.save(EquipmentMapper.INSTANCE.fromDTO(updatedEquipmentDto));
        return updatedEquipmentDto;
    }

    @Transactional
    public void delete(long id) {
        equipmentRepository.deleteById(id);
    }

}
