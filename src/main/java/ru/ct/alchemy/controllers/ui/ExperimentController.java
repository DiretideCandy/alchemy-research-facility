package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ct.alchemy.configuration.ExtraPropertiesHolder;
import ru.ct.alchemy.model.dto.experiments.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.experiments.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.experiments.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.experiments.ExperimentGetRsDTO;
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

    private final ExtraPropertiesHolder extraPropertiesHolder;

    @GetMapping
    private String showAll(Model model, @RequestParam(defaultValue = "createdAt,desc") String sort) {

        String[] sortParams = sort.split(",");
        Sort sortObj = Sort.by(Sort.Direction.fromString(sortParams[1]),
                sortParams[0].replace("status", "status.description")
        );

        List<ExperimentGetAllRsDTO> experiments = experimentService.findAllSorted(sortObj);
        model.addAttribute("experiments", experiments);
        model.addAttribute("sortBy", sortParams[0]);
        model.addAttribute("sortDir", sortParams[1]);
        return "experiments";
    }

    @GetMapping("/create")
    private String create(Model model) {
        ExperimentCreateRsDTO dto = experimentService.create(new ExperimentCreateRqDTO(
                new Date(),
                (String) (model.getAttribute("currentUser"))
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
        model.addAttribute("unknownString", extraPropertiesHolder.getUnknown());

        if (ExperimentStatus.CREATED.name().equals(experiment.getStatusName())
                || ExperimentStatus.FILLED_IN.name().equals(experiment.getStatusName())) {
            model.addAttribute("allMaterials", materialService.findAll());
            model.addAttribute("allEquipment", equipmentService.findAll());

            if (!extraPropertiesHolder.getUnknown().equals(experiment.getEquipmentType()))
                model.addAttribute("allActions", actionService.findByEquipmentType(experiment.getEquipmentType()));
        }

        //model.asMap().forEach((k, v) -> log.info("modeL: {} - {}", k, v));

        return "experiment-info";
    }

    @PostMapping("/{id}/editEquipment")
    private String editEquipment(@PathVariable long id, @RequestParam Map<String, String> formData) {
        if (formData.containsKey("newEquipmentId")) {
            long equipmentId = Long.parseLong(formData.get("newEquipmentId"));
            experimentService.updateEquipment(id, equipmentId);
        }
        return "redirect:/research/experiments/" + id;
    }

    @PostMapping("/{id}/editMaterials")
    private String editMaterials(@PathVariable long id, @RequestParam Map<String, String> formData) {

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
    private String editAction(@PathVariable long id, @RequestParam Map<String, String> formData) {
        if (formData.containsKey("newActionId")) {
            long actionId = Long.parseLong(formData.get("newActionId"));
            experimentService.updateAction(id, actionId);
        }
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/approve")
    private String approve(Model model, @PathVariable long id) {
        experimentService.approve(id, (String) (model.getAttribute("currentUser")));
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/start")
    private String start(@PathVariable long id) {
        experimentService.start(id);
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/finish")
    private String finish(@PathVariable long id) {
        experimentService.finish(id);
        return "redirect:/research/experiments/" + id;
    }

    @GetMapping("/{id}/cancel")
    private String cancel(Model model, @PathVariable long id) {
        experimentService.cancel(id);
        return "redirect:/research/experiments/" + id;
    }

    @ModelAttribute
    public void addUserNameToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("currentUser", authentication.getName());
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            model.addAttribute("roles", roles);
        }
    }
}
