package ru.ct.alchemy.controllers.ui;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ct.alchemy.model.dto.ReportDTO;
import ru.ct.alchemy.services.interfaces.ReportService;

import java.util.Optional;

@Controller
@RequestMapping("/research/reports")
@AllArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/{id}")
    private String show(Model model, @PathVariable long id) {
        Optional<ReportDTO> serviceResponse = reportService.findById(id);
        if (serviceResponse.isEmpty())
            return "error/404";

        model.addAttribute("report", serviceResponse.get());
        return "report";
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
