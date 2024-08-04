package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ct.alchemy.configuration.ExperimentInfoPageProperties;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.services.interfaces.ActionService;
import ru.ct.alchemy.services.interfaces.EquipmentService;
import ru.ct.alchemy.services.interfaces.ExperimentService;
import ru.ct.alchemy.services.interfaces.MaterialService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/research/experiments")
@AllArgsConstructor
public class ExperimentController {

    private final ExperimentService experimentService;
    private final EquipmentService equipmentService;
    private final MaterialService materialService;
    private final ActionService actionService;
    private final ExperimentInfoPageProperties experimentInfoPageProperties;

    @GetMapping
    private String showAll(Model model) {
        List<ExperimentGetAllRsDTO> experiments = experimentService.findAll();
        model.addAttribute("experiments", experiments);
        return "experiments";
    }

    @GetMapping("/create")
    private String create() {
        ExperimentCreateRsDTO dto = experimentService.create(new ExperimentCreateRqDTO(
                new Date(),
                "Учёный 1"
        ));
        return "redirect:/research/experiments/" + dto.getId();
    }

    @GetMapping("/{id}")
    private String show(Model model, @PathVariable long id) {
        Optional<ExperimentGetRsDTO> serviceResponse = experimentService.findById(id);
        if (serviceResponse.isEmpty())
            return "error/404";


        ExperimentGetRsDTO experiment = serviceResponse.get();
        model.addAttribute("experiment", experiment);
        model.addAttribute("unknownString", experimentInfoPageProperties.getUnknown());

        if (ExperimentStatus.CREATED.name().equals(experiment.getStatusName())
                || ExperimentStatus.FILLED_IN.name().equals(experiment.getStatusName())) {
            model.addAttribute("allMaterials", materialService.findAll());
            model.addAttribute("allEquipment", equipmentService.findAll());

            if (!experimentInfoPageProperties.getUnknown().equals(experiment.getEquipmentType()))
                model.addAttribute("allActions", actionService.findByEquipmentType(experiment.getEquipmentType()));
        }

        return "experiment-info";
    }

    @PostMapping("/{id}/editEquipment")
    private String editEquipment(Model model, @PathVariable long id, @RequestParam Map<String, String> formData) {
        log.info("[editEquipment call] formData: ");
        formData.forEach((key, value) -> log.info("{} - {}", key, value));
        return "redirect:/research/experiments/" + id;
    }

    @PostMapping("/{id}/editMaterials")
    private String editMaterials(Model model, @PathVariable long id, @RequestParam Map<String, String> formData) {

        if (formData.containsKey("remove")) {
            int index = Integer.parseInt(formData.get("remove"));
            experimentService.removeMaterial(id, index);
        } else if (formData.containsKey("add")) {
            long materialId = Long.parseLong(formData.get("newMaterialId"));
            experimentService.addMaterial(id, materialId);
        }
        return "redirect:/research/experiments/" + id;
    }

    @PostMapping("/{id}/editAction")
    private String editAction(Model model, @PathVariable long id, @RequestParam Map<String, String> formData) {
        log.info("[editAction call] formData: ");
        formData.forEach((key, value) -> log.info("{} - {}", key, value));
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/approve")
    private String approve(Model model, @PathVariable long id) {
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/start")
    private String start(Model model, @PathVariable long id) {
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/finish")
    private String finish(Model model, @PathVariable long id) {
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/create-report")
    private String createReport(Model model, @PathVariable long id) {
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/cancel")
    private String cancel(Model model, @PathVariable long id) {
        return "redirect:/research/experiments/" + id;
    }
}
