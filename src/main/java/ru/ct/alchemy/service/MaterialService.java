package ru.ct.alchemy.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.dto.MaterialDTO;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    List<MaterialDTO> findAll();

    Optional<MaterialDTO> findById(long id);

    @Transactional
    MaterialDTO save(MaterialDTO material);

    @Transactional
    MaterialDTO update(MaterialDTO material);

    @Transactional
    void delete(long id);
}
