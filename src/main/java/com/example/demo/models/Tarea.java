package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tareas_generator")
    @SequenceGenerator(name = "tareas_generator", sequenceName = "tareas_id_seq", allocationSize = 1)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "id_agenda", nullable = false)
    private Integer idAgenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_agenda", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private Agenda agenda;

    public Tarea() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
