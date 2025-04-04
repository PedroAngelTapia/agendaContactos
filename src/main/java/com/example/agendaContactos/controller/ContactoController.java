package com.example.agendaContactos.controller;

import com.example.agendaContactos.model.Contacto;
import com.example.agendaContactos.repository.ContactoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//1.6 Implementa la funcionalidad para editar un contacto existente
//1.7 Implementa la funcionalidad para eliminar un contacto
//1.10 Implementa redirecciones y mensajes de confirmación tras la creación, edición o eliminación de un contacto
// Controlador encargado de manejar las peticiones web
@Controller
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    // Muestra la lista de contactos y el formulario de creación
    @GetMapping("/")
    public String listarContactos(Model model) {
        model.addAttribute("contactos", contactoRepository.findAll()); // Lista
        model.addAttribute("contacto", new Contacto()); // Formulario
        return "index";
    }
    // 1.4 Implementa un controlador que permita gestionar el formulario de creación de contactos y la lista de contactos
    // Guarda un nuevo contacto con validación de datos
    @PostMapping("/guardar")
    public String guardarContacto(@Valid @ModelAttribute Contacto contacto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("contactos", contactoRepository.findAll());
            return "index"; // Muestra errores en la misma vista
        }
        contactoRepository.save(contacto);
        return "redirect:/?success=Contacto+guardado";
    }

    // Carga el formulario de edición con los datos del contacto
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Contacto contacto = contactoRepository.findById(id).orElseThrow();
        model.addAttribute("contacto", contacto);
        return "editar";
    }

    // Actualiza un contacto existente con validación
    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @Valid Contacto contacto, BindingResult result) {
        if (result.hasErrors()) return "editar";
        contacto.setId(id); // Importante para que no cree uno nuevo
        contactoRepository.save(contacto);
        return "redirect:/?success=Contacto+actualizado";
    }

    // Elimina un contacto por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        contactoRepository.deleteById(id);
        return "redirect:/?success=Contacto+eliminado";
    }
}
/* Métodos:

@GetMapping("/"): lista contactos y muestra formulario

@PostMapping("/guardar"): guarda nuevo contacto

@GetMapping("/editar/{id}"): carga formulario de edición

@PostMapping("/actualizar/{id}"): guarda cambios

@GetMapping("/eliminar/{id}"): elimina contacto*/
