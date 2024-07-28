package ru.ct.alchemy.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.model.mappers.ExperimentMapper;
import ru.ct.alchemy.repositories.ExperimentRepository;
import ru.ct.alchemy.services.interfaces.ExperimentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

    private final ExperimentRepository experimentRepository;

    @Override
    public List<ExperimentGetAllRsDTO> findAll() {
        return experimentRepository.findAll()
                .stream()
                .map(ExperimentMapper.INSTANCE::toGetAllRsDTO)
                .toList();
    }
    @Override
    public ExperimentCreateRsDTO create(ExperimentCreateRqDTO experimentCreateRqDTO) {
        return ExperimentMapper.INSTANCE.toCreateRsDTO(
                experimentRepository.save(
                        ExperimentMapper.INSTANCE.fromCreateRqDTO(
                                experimentCreateRqDTO)));
    }

    @Override
    public Optional<ExperimentGetRsDTO> findById(long id) {
        return experimentRepository.findById(id)
                .map(ExperimentMapper.INSTANCE::toGetRsDTO);
    }
  //return materialRepository.findById(id)
    //                .map(MaterialMapper.INSTANCE::toDTO);
}
