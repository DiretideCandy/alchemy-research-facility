package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ct.alchemy.model.dto.EquipmentDTO;
import ru.ct.alchemy.services.interfaces.EquipmentService;

import java.util.List;

@Controller
@RequestMapping("/research/equipment")
@AllArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    private String equipment(Model model) {
        List<EquipmentDTO> equipment = equipmentService.findAll();
        model.addAttribute("equipment", equipment);
        return "equipment";
    }

    @ModelAttribute("currentUser")
    private String addUserNameToModel() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return null;
    }
}
