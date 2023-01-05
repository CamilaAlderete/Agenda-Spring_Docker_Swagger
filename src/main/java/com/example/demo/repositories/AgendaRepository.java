package com.example.demo.repositories;

import com.example.demo.models.Agenda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Integer> {

    public abstract ArrayList<Agenda> findByDescripcionContains(String str);

}
