package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personas_generator")
    @SequenceGenerator(name = "personas_generator", sequenceName = "personas_id_seq", allocationSize = 1)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    @Column(name="cedula", nullable = false)
    private Integer cedula;


    /*
    - una persona muchas agendas
        - en mappepBy se debe colocar el nombre del campo (en agenda) que conecta persona con agenda
        - aqui el fetch por defecto es del tipo Lazy en caso de no especificarse
        - FetchMode.SELECT evita elementos duplicados en la lista agendas... o en vez de list usar set
        - cascade es para indicar que al eliminarse la persona, todas sus agendas seran eliminadas
        - JsonManagedReference evita loop
        */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Agenda> agendas;

    public Persona() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }
}
