package ru.ct.alchemy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.repository.MaterialRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<MaterialDTO> findAll() {
        return materialRepository.findAll()
                .stream()
                .map(MaterialDTO::fromMaterial)
                .toList();
    }

    public Optional<MaterialDTO> findById(long id) {
        return materialRepository.findById(id)
                .map(MaterialDTO::fromMaterial);
    }

    @Transactional
    public MaterialDTO save(MaterialDTO materialDto) {
        materialRepository.save(materialDto.toMaterial());
        return materialDto;
    }

    @Transactional
    public MaterialDTO update(MaterialDTO updatedMaterialDto) {
        materialRepository.save(updatedMaterialDto.toMaterial());
        return updatedMaterialDto;
    }

    @Transactional
    public void delete(long id) {
        materialRepository.deleteById(id);
    }
}
