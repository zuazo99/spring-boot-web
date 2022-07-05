package com.bolsadeideas.springboot.app.springboot.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // La idea es que esta clase contenga un metodo que rediriga al IndexController
    @GetMapping("/")
    public String home(){
        // metodo para redirigir
//        return "redirect:/app/index";
        return "forward:/app/index"; // sin reiniciar el request, sin recargar la pagina y rutas propias del proyecto
    }
}
