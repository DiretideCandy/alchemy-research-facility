package ru.ct.alchemy.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.model.mappers.MaterialMapper;
import ru.ct.alchemy.repositories.MaterialRepository;
import ru.ct.alchemy.services.interfaces.MaterialService;

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
                .map(MaterialMapper.INSTANCE::toDTO)
                .toList();
    }

    public Optional<MaterialDTO> findById(long id) {
        return materialRepository.findById(id)
                .map(MaterialMapper.INSTANCE::toDTO);
    }

    @Transactional
    public MaterialDTO save(MaterialDTO materialDto) {
        materialRepository.save(MaterialMapper.INSTANCE.fromDTO(materialDto));
        return materialDto;
    }

    @Transactional
    public MaterialDTO update(MaterialDTO updatedMaterialDto) {
        materialRepository.save(MaterialMapper.INSTANCE.fromDTO(updatedMaterialDto));
        return updatedMaterialDto;
    }

    @Transactional
    public void delete(long id) {
        materialRepository.deleteById(id);
    }
}
