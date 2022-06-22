package com.bolsadeideas.springboot.app.springboot.web.app.controllers;


import com.bolsadeideas.springboot.app.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {

    // Estas clases van a tener metodos de accion, para manejar peticiones HTTP
    // Se encarga de manejar las peticiones del usuario
    // Mapear relacionar este index a una ruta URL
    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model){
        //3 formas distintas --> Model, ModelMap ,Map<> y ModelAndView
       // map.put("titulo", "Hola Spring FrameWork con Map!");
        model.addAttribute("titulo", "Hola Spring FrameWork con Model!");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Gaizka");
        usuario.setApellidos("Zuazo");
        usuario.setEmail("gzuazo63@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarios = new ArrayList<>();

        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }

}
