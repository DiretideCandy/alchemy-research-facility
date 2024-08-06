package ru.ct.alchemy.services.interfaces;

import ru.ct.alchemy.model.dto.ReportDTO;

import java.util.Optional;

public interface ReportService {
    Optional<ReportDTO> findById(Long id);
}
