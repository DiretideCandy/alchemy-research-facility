package ru.ct.alchemy.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.repository.EquipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @PostConstruct
    private void initTestValues(){
//        equipmentRepository.save(Equipment.builder().type("Wand").name("Волшебная палочка, дуб, волос из хвоста единорога").amount(25).build());
//        equipmentRepository.save(Equipment.builder().type("Cauldron").name("Котёл походный").amount(2).build());
//        equipmentRepository.save(Equipment.builder().type("Cauldron").name("Котёл чугунный, большой").amount(10).build());
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> findById(long id) {
        return equipmentRepository.findById(id);
    }

    @Transactional
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Transactional
    public void update(long id, Equipment updatedEquipment) {
        updatedEquipment.setId(id);
        equipmentRepository.save(updatedEquipment);
    }

    @Transactional
    public void delete(long id) {
        equipmentRepository.deleteById(id);
    }

}
