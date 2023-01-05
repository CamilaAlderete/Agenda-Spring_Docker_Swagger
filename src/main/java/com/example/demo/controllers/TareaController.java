package com.example.demo.controllers;

import com.example.demo.models.Tarea;
import com.example.demo.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @GetMapping()
    public ArrayList<Tarea> getTareas(){
        return tareaService.obtenerTareas();
    }

    @GetMapping(path = "/{id}")
    public Optional<Tarea> getTareaById(@PathVariable("id") Integer id){
        return tareaService.obtenerTareaById(id);
    }

    @GetMapping(path = "/agenda/{id}")
    public ArrayList<Tarea> getTareasByAgenda(@PathVariable("id") Integer id){
        return tareaService.obtenerTareasByAgenda(id);
    }

    //http://localhost:8080/tarea/agenda/15/query?descripcion=pegar
    @GetMapping(path = "/agenda/{id}/query")
    public ArrayList<Tarea> getTareaByAgendaYDescripcion(@PathVariable("id") Integer idAgenda, @RequestParam("descripcion") String descripcion){
        return tareaService.obtenerTareasByAgendaYDescripcion(idAgenda, descripcion);
    }

    @PostMapping()
    public Tarea postTarea(@RequestBody Tarea tarea){
        return tareaService.guardarTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public String deleteTarea(@PathVariable("id") Integer id){
        boolean ok = tareaService.eliminarTarea(id);
        if(ok){
            return "Se ha eliminado la tarea con id "+ id;
        }else{
            return "No se ha podido eliminar la tarea con id " + id;
        }
    }


}
