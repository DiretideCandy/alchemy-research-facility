package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

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
        return "security/logout";
    }

    @GetMapping("/login")
    private String login(Model model, String error, String logout) {
        if (error != null) model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null) model.addAttribute("message", "You have been logged out successfully.");

        return "security/login";
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
