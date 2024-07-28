package ru.ct.alchemy.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.mappers.ExperimentMapper;
import ru.ct.alchemy.repositories.ExperimentRepository;
import ru.ct.alchemy.services.interfaces.ExperimentService;

@Service
@AllArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

    private final ExperimentRepository experimentRepository;

    @Override
    public ExperimentCreateRsDTO create(ExperimentCreateRqDTO experimentCreateRqDTO) {
        return ExperimentMapper.INSTANCE.toCreateRsDTO(
                experimentRepository.save(
                        ExperimentMapper.INSTANCE.fromCreateRqDTO(
                                experimentCreateRqDTO)));
    }
}
