package com.example.demo.services;

import com.example.demo.models.Agenda;
import com.example.demo.models.Tarea;
import com.example.demo.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public ArrayList<Tarea> obtenerTareas(){
        return (ArrayList<Tarea>) tareaRepository.findAll();
    }

    public ArrayList<Tarea> obtenerTareasByAgenda(Integer idAgenda){
        return tareaRepository.findTareasByIdAgenda(idAgenda);
    }

    public Tarea guardarTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    public ArrayList<Tarea> obtenerTareasByAgendaYDescripcion(Integer id, String str){
        return tareaRepository.findTareasByIdAgendaAndDescripcionContains(id, str);
    }

    public Optional<Tarea> obtenerTareaById(Integer id){
        return tareaRepository.findById(id);
    }


    public boolean eliminarTarea(Integer id){

        try{
            tareaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
