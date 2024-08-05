package ru.ct.alchemy.controllers.ui;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@AllArgsConstructor
public class MainPageController {


    @Operation(summary = "Главная страница (пока лучше не трогать, не оформлено)", description = "Пока лучше не трогать, не оформлено")
    @GetMapping("/")
    private String home() {
        return "redirect:/research";
    }

    @GetMapping("/research")
    private String index() {
        return "index";
    }

    @ModelAttribute("currentUser")
    private String addUserNameToModel() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return "Аноним";
    }
}
