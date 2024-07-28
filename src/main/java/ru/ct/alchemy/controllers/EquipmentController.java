package ru.ct.alchemy.controllers;

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
public class EquipmentController {

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

    @Operation(summary = "Создать оборудование", description = "Добавляет указанное оборудование на склад")
    @PostMapping("/create")
    public ResponseEntity<EquipmentDTO> create(@RequestBody @Valid EquipmentDTO equipment,
                                            BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(equipment);

        return new ResponseEntity<>(equipmentService.save(equipment), HttpStatus.CREATED);
    }

    @Operation(summary = "Изменить оборудование", description = "Отредактировать информацию об оборудовании")
    @PatchMapping("/{id}")
    public ResponseEntity<EquipmentDTO> update(@ModelAttribute("person") @Valid EquipmentDTO equipment,
                                            BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(equipment);

        return ResponseEntity.ok(equipmentService.update(equipment));
    }

    @Operation(summary = "Удалить оборудование", description = "Удалить оборудование по его id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        equipmentService.delete(id);
    }
}
