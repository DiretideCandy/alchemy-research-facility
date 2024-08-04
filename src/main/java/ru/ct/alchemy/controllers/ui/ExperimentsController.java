package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ct.alchemy.configuration.ExperimentInfoPageProperties;
import ru.ct.alchemy.model.dto.ExperimentCreateRqDTO;
import ru.ct.alchemy.model.dto.ExperimentCreateRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetAllRsDTO;
import ru.ct.alchemy.model.dto.ExperimentGetRsDTO;
import ru.ct.alchemy.services.interfaces.ExperimentService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/research/experiments")
@AllArgsConstructor
public class ExperimentsController {

    private final ExperimentService experimentService;
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
        Optional<ExperimentGetRsDTO> experiment = experimentService.findById(id);
        if (experiment.isEmpty())
            return "error/404";

        model.addAttribute("experiment", experiment.get());
        model.addAttribute("unknownString", experimentInfoPageProperties.getUnknown());
        return "experiment-info";
    }

    @GetMapping("/{id}/edit")
    private void tempEdit(Model model, @PathVariable long id){
    }

    @GetMapping("/{id}/approve")
    private void approve(Model model, @PathVariable long id){
    }

    @GetMapping("/{id}/start")
    private void start(Model model, @PathVariable long id){
    }

    @GetMapping("/{id}/finish")
    private void finish(Model model, @PathVariable long id){
    }

    @GetMapping("/{id}/create-report")
    private void createReport(Model model, @PathVariable long id){
    }

    @GetMapping("/{id}/cancel")
    private void cancel(Model model, @PathVariable long id){
    }
}
