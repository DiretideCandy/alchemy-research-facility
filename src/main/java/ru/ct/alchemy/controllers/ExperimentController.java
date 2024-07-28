package ru.ct.alchemy.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.services.interfaces.ExperimentService;

@RestController
@RequestMapping("/experiments")
@AllArgsConstructor
public class ExperimentController {

    private final ExperimentService experimentService;

    @Operation(summary = "Создать новый эксперимент", description = "Создаёт новый эксперимент для дальнейшего заполнения его параметров")
    @PostMapping("/create")
    public ResponseEntity<ExperimentCreateRsDTO> createExperiment(
            @RequestBody @Valid ExperimentCreateRqDTO experimentCreateRqDTO) {
        return new ResponseEntity<>(experimentService.create(experimentCreateRqDTO), HttpStatus.OK);
    }
}
