package ru.ct.alchemy.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Operation(summary = "Просмотреть всё оборудование", description = "Возвращает всё доступное на складе оборудование")
    @GetMapping("/")
    public ResponseEntity<List<Equipment>> getAllEquipment(){
        return new ResponseEntity<>(equipmentService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Просмотреть оборудование по id", description = "Возвращает оборудование по его id")
    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipment(@PathVariable("id") long id){
        return equipmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Создать оборудование", description = "Добавляет указанное оборудование на склад")
    @PostMapping("/create")
    public ResponseEntity<Equipment> create(@RequestBody @Valid Equipment equipment,
                                                          BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(equipment);

        equipmentService.save(equipment);
        return new ResponseEntity<>(equipment, HttpStatus.CREATED);
    }

    @Operation(summary = "Изменить оборудование", description = "Отредактировать информацию об оборудовании по его id")
    @PatchMapping("/{id}")
    public ResponseEntity<Equipment> update(@ModelAttribute("person") @Valid Equipment equipment,
                         BindingResult bindingResult,
                         @PathVariable("id") long id) {

        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(equipment);

        equipmentService.update(id, equipment);
        return ResponseEntity.ok(equipment);
    }

    @Operation(summary = "Удалить оборудование", description = "Удалить оборудование по его id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        equipmentService.delete(id);
    }
}
