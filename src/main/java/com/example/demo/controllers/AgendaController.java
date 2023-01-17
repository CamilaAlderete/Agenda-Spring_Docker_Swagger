package com.example.demo.controllers;
import com.example.demo.models.Agenda;

import com.example.demo.services.AgendaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/agenda")
public class AgendaController
{
    @Autowired
    AgendaService agendaService;

    @Operation(summary = "Obtiene el listado de agendas")
    @GetMapping()
    public ArrayList<Agenda> getAgendas(){
        return agendaService.obtenerAgendas();
    }



    /*sirve como post y put, para put el body de request debe tener el id de la agenda que sera modificada

        POST http://localhost:8080/agenda

        para crear agenda:
            {
                "descripcion": "agenda 2023",
                "idPersona": 1
            }

        para editar agenda:
            {
                "id": 26
                "descripcion": "agenda 2023",
                "idPersona": 1
            }

    */
    @Operation(summary = "Permite el registro o la edición de una agenda. En caso de edición debe de especificarse el Id.")
    @PostMapping()
    public Agenda postAgenda(@RequestBody Agenda agenda){
        return agendaService.guardarAgenda(agenda);
    }

    @Operation(summary = "Obtiene una agenda por su Id.")
    @GetMapping(path = "{id}")
    public Optional<Agenda> getAgendaById(@PathVariable("id") Integer id){
        return agendaService.obtenerAgendaPorId(id);
    }

    @Operation(summary = "Obtiene el listado de agendas filtradas por descripción.")
    @GetMapping(path = "/query")
    public ArrayList<Agenda> getAgendaByDescripcion(@RequestParam("descripcion") String descripcion){
        return agendaService.obtenerAgendasPorDescripcion(descripcion);
    }

    @Operation(summary = "Elimina una agenda por su Id.")
    @DeleteMapping(path = "/{id}")
    public String deleteAgenda(@PathVariable("id") Integer id){
        boolean ok = agendaService.eliminarAgenda(id);
        if(ok){
            return "Se elimino agenda con id " + id;
        }else{
            return "No se pudo eliminar agenda con id " + id;
        }
    }
}
