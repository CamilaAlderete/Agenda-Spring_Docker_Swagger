//https://www.baeldung.com/spring-autowire
package com.example.demo.services;
import com.example.demo.models.Persona;
import com.example.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonaService {

    /*
     - Con Autowired se elimina la necesidad de getters y setters
     - Al colocarlo sobre el atributo PersonaRepository este es inyectado en PersonaService al crearse
     */
    @Autowired
    PersonaRepository personaRepository;

    public ArrayList<Persona> obtenerPersonas(){
        return (ArrayList<Persona>) personaRepository.findAll();
    }

    public Persona guardarPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Optional<Persona> obtenerPorId(Integer id){
        return personaRepository.findById(id);
    }

    public ArrayList<Persona> obtenerPorNombre(String nombre){
        return personaRepository.findByNombreContains(nombre);
    }

    public boolean eliminarPersona(Integer id){
        try{
            personaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
