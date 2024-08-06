package ru.ct.alchemy.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ct.alchemy.model.dto.experiments.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.experiments.ExperimentGetRsDTO;
import ru.ct.alchemy.services.interfaces.ExperimentService;

import java.util.List;

@RestController
@RequestMapping("/api/experiments")
@AllArgsConstructor
public class ExperimentApiController {

    private final ExperimentService experimentService;

    @Operation(summary = "Просмотреть все эксперименты", description = "Возвращает все эксперименты")
    @GetMapping("/")
    public ResponseEntity<List<ExperimentGetAllRsDTO>> getExperiments() {
        return new ResponseEntity<>(experimentService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Просмотреть эксперимент по id", description = "Возвращает подробную информацию об экспериментеExperimentCreateRsDTO по его id")
    @GetMapping("/{id}")
    public ResponseEntity<ExperimentGetRsDTO> getExperiment(@PathVariable("id") long id) {
        return experimentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
