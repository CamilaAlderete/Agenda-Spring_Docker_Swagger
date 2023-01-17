package com.example.demo.controllers;

import com.example.demo.models.Tarea;
import com.example.demo.services.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @Operation(summary = "Obtiene el listado de todas las tareas de todas las agendas.")
    @GetMapping()
    public ArrayList<Tarea> getTareas(){
        return tareaService.obtenerTareas();
    }

    @Operation(summary = "Obtiene una tarea por su Id")
    @GetMapping(path = "/{id}")
    public Optional<Tarea> getTareaById(@PathVariable("id") Integer id){
        return tareaService.obtenerTareaById(id);
    }

    @Operation(summary = "Obtiene todas las tareas de una agenda con cierto Id.")
    @GetMapping(path = "/agenda/{id}")
    public ArrayList<Tarea> getTareasByAgenda(@PathVariable("id") Integer id){
        return tareaService.obtenerTareasByAgenda(id);
    }

    //http://localhost:8080/tarea/agenda/15/query?descripcion=pegar
    @Operation(summary = "Obtiene un listado de tareas de una agenda, donde el listado esta filtrado por descripción")
    @GetMapping(path = "/agenda/{id}/query")
    public ArrayList<Tarea> getTareaByAgendaYDescripcion(@PathVariable("id") Integer idAgenda, @RequestParam("descripcion") String descripcion){
        return tareaService.obtenerTareasByAgendaYDescripcion(idAgenda, descripcion);
    }

    @Operation(summary = "Permite el registro o la edición de una tarea. En caso de edición se necesita especificar el id de la tarea.")
    @PostMapping()
    public Tarea postTarea(@RequestBody Tarea tarea){
        return tareaService.guardarTarea(tarea);
    }

    @Operation(summary = "Elimina una tarea por su Id.")
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
