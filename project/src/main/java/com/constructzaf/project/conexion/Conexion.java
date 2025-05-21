package com.constructzaf.project.conexion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class Conexion {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mensaje", "Hola desde Spring Boot con Thymeleaf");
        return "index"; // Se refiere a index.html en la carpeta templates
    }
}