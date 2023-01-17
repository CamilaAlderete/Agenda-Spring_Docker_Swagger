package com.example.demo.repositories;

import com.example.demo.models.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    public abstract ArrayList<Persona> findByNombreContains(String nombre);
}
