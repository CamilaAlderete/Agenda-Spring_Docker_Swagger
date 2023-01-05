package com.example.demo.controllers;

import com.example.demo.models.Persona;
import com.example.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping()
    public ArrayList<Persona> getPersonas(){
        return personaService.obtenerPersonas();
    }

    //sirve como post y put, para put el body de request debe tener el id de la persona que sera modificada
    @PostMapping()
    public Persona postPersona(@RequestBody Persona persona){
        return personaService.guardarPersona(persona);
    }

    @GetMapping(path = "/{id}")
    public Optional<Persona> getPersonaById(@PathVariable("id") Integer id){
        return personaService.obtenerPorId(id);
    }

    //http://localhost:8080/persona/query?nombre=camila
    @GetMapping("/query")
    public ArrayList<Persona> getPersonasByNombre(@RequestParam("nombre") String nombre){
        return personaService.obtenerPorNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePersonaById(@PathVariable("id") Integer id){
       boolean ok = personaService.eliminarPersona(id);
       if(ok){
           return "Se elimino a la persona con id "+ id;
       }else{
           return "No se elimino a la persona con id "+ id;

       }
    }
}
