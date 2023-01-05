//https://www.baeldung.com/spring-data-jpa-query
package com.example.demo.services;
import com.example.demo.models.Agenda;
import com.example.demo.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

    public ArrayList<Agenda> obtenerAgendas(){
        return (ArrayList<Agenda>) agendaRepository.findAll();
    }

    //se usa para crear y editar
    public Agenda guardarAgenda(Agenda agenda){
        return agendaRepository.save(agenda);
    }

    public ArrayList<Agenda> obtenerAgendasPorDescripcion(String str){
        return agendaRepository.findByDescripcionContains(str);
    }

    public boolean eliminarAgenda(Integer id){

        try{
            agendaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public Optional<Agenda> obtenerAgendaPorId(Integer id){
        return agendaRepository.findById(id);
    }



}
