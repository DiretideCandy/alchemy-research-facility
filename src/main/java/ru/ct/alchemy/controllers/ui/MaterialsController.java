package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ct.alchemy.model.dto.MaterialDTO;
import ru.ct.alchemy.services.interfaces.MaterialService;

import java.util.List;

@Controller
@RequestMapping("/research/materials")
@AllArgsConstructor
public class MaterialsController {

    private final MaterialService materialService;

    @GetMapping
    private String materials(Model model) {
        List<MaterialDTO> materials = materialService.findAll();
        model.addAttribute("materials", materials);
        return "materials";
    }
}
