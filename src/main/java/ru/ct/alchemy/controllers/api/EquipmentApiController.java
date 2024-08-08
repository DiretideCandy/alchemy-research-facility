package ru.ct.alchemy.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ct.alchemy.model.dto.EquipmentDTO;
import ru.ct.alchemy.services.EquipmentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@AllArgsConstructor
public class EquipmentApiController {

    private final EquipmentServiceImpl equipmentService;

    @Operation(summary = "Просмотреть всё оборудование", description = "Возвращает всё доступное на складе оборудование")
    @GetMapping("/")
    public ResponseEntity<List<EquipmentDTO>> getAllEquipment(){
        return new ResponseEntity<>(equipmentService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Просмотреть оборудование по id", description = "Возвращает оборудование по его id")
    @GetMapping("/{id}")
    public ResponseEntity<EquipmentDTO> getEquipment(@PathVariable("id") long id){
        return equipmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
