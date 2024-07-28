package ru.ct.alchemy.controllers.ui;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @Operation(summary = "Главная страница (пока лучше не трогать, не оформлено)", description = "Пока лучше не трогать, не оформлено")
    @GetMapping("/")
    private String index(){
        return "index";
    }
}
