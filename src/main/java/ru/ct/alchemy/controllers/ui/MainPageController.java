package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
@AllArgsConstructor
public class MainPageController {


    @GetMapping("/")
    private String home(Model model) {
        return "redirect:/research";
    }

    @GetMapping("/research")
    private String index(Model model) {
        return "index";
    }

    @GetMapping("/logout")
    private String logout(Model model, String error, String logout) {
        return "logout";
    }

    @GetMapping("/login")
    private String login(Model model, String error, String logout) {
        if (error != null) model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null) model.addAttribute("message", "You have been logged out successfully.");

        return "login";
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
