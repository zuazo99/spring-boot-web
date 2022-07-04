package com.bolsadeideas.springboot.app.springboot.web.app.controllers;


import com.bolsadeideas.springboot.app.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    // Estas clases van a tener metodos de accion, para manejar peticiones HTTP
    // Se encarga de manejar las peticiones del usuario
    // Mapear relacionar este index a una ruta URL
    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model){
        //3 formas distintas --> Model, ModelMap ,Map<> y ModelAndView
       // map.put("titulo", "Hola Spring FrameWork con Map!");
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Gaizka");
        usuario.setApellidos("Zuazo");
        usuario.setEmail("gzuazo63@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){

        //Arrays.asList()
//        List<Usuario> usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("Gaizka", "Zuazo", "gzuazo63@gmail.com"));
//        usuarios.add(new Usuario("Jorge", "Martinez", "jorge69@gmail.com"));
//        usuarios.add(new Usuario("Kepa", "Munitis", "kepa12@gmail.com"));
//        usuarios.add(new Usuario("Tornado", "Roe", "tornado@gmail.com"));

        model.addAttribute("titulo", textoListar);
        //model.addAttribute("usuarios", usuarios);

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Gaizka", "Zuazo", "gzuazo63@gmail.com"));
        usuarios.add(new Usuario("Jorge", "Martinez", "jorge69@gmail.com"));
        usuarios.add(new Usuario("Kepa", "Munitis", "kepa12@gmail.com"));
        usuarios.add(new Usuario("Tornado", "Roe", "tornado@gmail.com"));

        return usuarios;
    }

}
