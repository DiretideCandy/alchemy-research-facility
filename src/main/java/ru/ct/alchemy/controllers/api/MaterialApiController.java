package ru.ct.alchemy.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.services.MaterialServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
@AllArgsConstructor
public class MaterialApiController {

    private final MaterialServiceImpl materialService;

    @Operation(summary = "Просмотреть все материалы", description = "Возвращает все доступные на складе материалы")
    @GetMapping("/")
    public ResponseEntity<List<MaterialDTO>> getAllMaterials(){
        return new ResponseEntity<>(materialService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Просмотреть материал по id", description = "Возвращает материал по его id")
    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> getMaterials(@PathVariable("id") long id){
        return materialService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
