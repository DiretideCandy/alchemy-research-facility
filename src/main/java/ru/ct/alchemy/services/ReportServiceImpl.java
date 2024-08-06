package ru.ct.alchemy.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ct.alchemy.model.mappers.ReportMapper;
import ru.ct.alchemy.model.dto.ReportDTO;
import ru.ct.alchemy.repositories.ReportRepository;
import ru.ct.alchemy.services.interfaces.ReportService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public Optional<ReportDTO> findById(Long id) {
        return reportRepository.findById(id)
                .map(ReportMapper.INSTANCE::toDTO);
    }
}
