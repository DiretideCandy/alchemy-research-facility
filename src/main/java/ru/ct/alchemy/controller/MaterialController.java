package ru.ct.alchemy.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @Operation(summary = "Просмотреть все материалы", description = "Возвращает все доступные на складе материалы")
    @GetMapping("/")
    public ResponseEntity<List<Material>> getAllEquipment(){
        return new ResponseEntity<>(materialService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Просмотреть материал по id", description = "Возвращает материал по его id")
    @GetMapping("/{id}")
    public ResponseEntity<Material> getEquipment(@PathVariable("id") long id){
        return materialService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Создать материал", description = "Добавляет указанный материал на склад")
    @PostMapping("/create")
    public ResponseEntity<Material> create(@RequestBody @Valid Material material,
                                            BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(material);

        materialService.save(material);
        return new ResponseEntity<>(material, HttpStatus.CREATED);
    }

    @Operation(summary = "Изменить материал", description = "Отредактировать информацию о материале по его id")
    @PatchMapping("/{id}")
    public ResponseEntity<Material> update(@ModelAttribute("person") @Valid Material material,
                                            BindingResult bindingResult,
                                            @PathVariable("id") long id) {

        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(material);

        materialService.update(id, material);
        return ResponseEntity.ok(material);
    }

    @Operation(summary = "Удалить материал", description = "Удалить материал по его id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        materialService.delete(id);
    }
}
