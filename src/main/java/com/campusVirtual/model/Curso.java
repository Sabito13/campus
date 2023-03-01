package com.campusVirtual.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="Curso")
@Table(
    name="curso",
    uniqueConstraints = {
        @UniqueConstraint(name="cliente_id_constraint",columnNames = "id")
    }
)
public class Curso {
    @Id
    @SequenceGenerator(
        name = "generadoIdCurso",
        sequenceName = "CURSO_GENERADOR_ID",
        initialValue=1,
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "generadoIdCurso",
        strategy = GenerationType.SEQUENCE)
    @Column(
        name = "id",
        updatable = false,
        nullable = false,
        unique = true
    )
    private Long id;

    @Column(
        name = "nombre",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String nombre;


    public Curso(){}
    public Curso(String nombre){
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
