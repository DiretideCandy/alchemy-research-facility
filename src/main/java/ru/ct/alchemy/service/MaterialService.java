package ru.ct.alchemy.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.repository.MaterialRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @PostConstruct
    private void initTestValues(){
        materialRepository.save(Material.builder().type("Item").name("Язык лягушки").amount(10).build());
        materialRepository.save(Material.builder().type("Item").name("Контейнер с неопознанным содержимым").amount(5).build());
        materialRepository.save(Material.builder().type("Liquid").name("Колба с кровью дракона, 200 мл").amount(1).build());
    }


    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Optional<Material> findById(long id) {
        return materialRepository.findById(id);
    }

    @Transactional
    public void save(Material equipment) {
        materialRepository.save(equipment);
    }

    @Transactional
    public void update(long id, Material updatedMaterial) {
        updatedMaterial.setId(id);
        materialRepository.save(updatedMaterial);
    }

    @Transactional
    public void delete(long id) {
        materialRepository.deleteById(id);
    }
}
