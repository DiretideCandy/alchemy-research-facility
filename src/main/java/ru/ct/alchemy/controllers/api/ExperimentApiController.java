package ru.ct.alchemy.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.services.interfaces.ExperimentService;

import java.util.List;

@RestController
@RequestMapping("/api/experiments")
@AllArgsConstructor
public class ExperimentApiController {

    private final ExperimentService experimentService;

    @Operation(summary = "Просмотреть все эксперименты", description = "Возвращает все эксперименты")
    @GetMapping("/")
    public ResponseEntity<List<ExperimentGetAllRsDTO>> getExperiments(){
        return new ResponseEntity<>(experimentService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Просмотреть эксперимент по id", description = "Возвращает подробную информацию об экспериментеExperimentCreateRsDTO по его id")
    @GetMapping("/{id}")
    public ResponseEntity<ExperimentGetRsDTO> getExperiment(@PathVariable("id") long id){
        return experimentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Создать новый эксперимент", description = "Создаёт новый эксперимент для дальнейшего заполнения его параметров")
    @PostMapping("/create")
    public ResponseEntity<ExperimentCreateRsDTO> createExperiment(
            @RequestBody @Valid ExperimentCreateRqDTO experimentCreateRqDTO) {
        return new ResponseEntity<>(experimentService.create(experimentCreateRqDTO), HttpStatus.OK);
    }
}
