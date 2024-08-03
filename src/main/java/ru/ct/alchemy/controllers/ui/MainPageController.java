package ru.ct.alchemy.controllers.ui;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ct.alchemy.model.dto.EquipmentDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.services.interfaces.EquipmentService;
import ru.ct.alchemy.services.interfaces.ExperimentService;
import ru.ct.alchemy.services.interfaces.MaterialService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainPageController {

    private final ExperimentService experimentService;
    private final MaterialService materialService;
    private final EquipmentService equipmentService;

    @Operation(summary = "Главная страница (пока лучше не трогать, не оформлено)", description = "Пока лучше не трогать, не оформлено")
    @GetMapping("/")
    private String index() {
        return "index";
    }

    @GetMapping("/experiments")
    private String experiments(Model model) {
        List<ExperimentGetAllRsDTO> experiments = experimentService.findAll();
        model.addAttribute("experiments", experiments);
        return "experiments";
    }

    @GetMapping("/experiments/{id}")
    private String experimentById(Model model, @PathVariable long id) {
        Optional<ExperimentGetRsDTO> experiment = experimentService.findById(id);
        if (experiment.isEmpty())
            return "error/404";

        model.addAttribute("experiment", experiment.get());
        return "experimentInfo";
    }

    @GetMapping("/materials")
    private String materials(Model model) {
        List<MaterialDTO> materials = materialService.findAll();
        model.addAttribute("materials", materials);
        return "materials";
    }

    @GetMapping("/equipment")
    private String equipment(Model model) {
        List<EquipmentDTO> equipment = equipmentService.findAll();
        model.addAttribute("equipment", equipment);
        return "equipment";
    }
}
