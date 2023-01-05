package com.example.demo.repositories;

import com.example.demo.models.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Integer> {

    public abstract ArrayList<Tarea> findTareasByIdAgenda(Integer id);

    public abstract ArrayList<Tarea> findTareasByDescripcionContains(String str);

    public abstract ArrayList<Tarea> findTareasByIdAgendaAndDescripcionContains(Integer id, String descripcion);

}
