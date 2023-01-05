//https://stackoverflow.com/questions/67150443/spring-data-jpa-repository-deletebyid-method-not-working

package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="agendas")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendas_generator")
    @SequenceGenerator(name = "agendas_generator", sequenceName = "agendas_id_seq", allocationSize = 1)
    @Column(name="id", unique= true, nullable=false)
    private Integer id;

    @Column(name="descripcion", nullable = false)
    private String descripcion;


    /*
    - insertable y updatable en false ya que esta entidad no se encarga de crear y actualizar persona
    - JsonBackReference es para evitar loop. En persona se usa la etiqueta @JsonManagedReference
    - Obs.: si en FetchType se coloca EAGER, no se podra eliminar la agenda. Esto es a causa de que
      JPA busca la entidad por id, lo que provoca que las entidades asociadas sean cargadas de forma EAGER
      lo que provoca que siga existiendo la referencia y la eliminacion sea cancelada.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_persona", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private Persona persona;


    @Column(name="id_persona", nullable = false)
    private Integer idPersona;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "agenda", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tarea> tareas;

    public Agenda() {
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }


    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
