package com.campusVirtual.model;

import java.util.List;
import java.util.ArrayList;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

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

    
    @OneToMany(
        mappedBy = "curso",
        orphanRemoval = true,
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        fetch = FetchType.EAGER
        )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProfesorEnCurso> profesorEnCurso = new ArrayList<ProfesorEnCurso>();
    //private Ensenia ensenia;

   
    public void addProfesorEnCurso(ProfesorEnCurso profesorEnCurso) {
        if (!this.profesorEnCurso.contains(profesorEnCurso)) {
            this.profesorEnCurso.add(profesorEnCurso);
        }
    }
    /*public void removeProfesorEnCurso(ProfesorEnCurso profesorEnCurso) {
        if (this.profesorEnCurso.contains(profesorEnCurso)) {
            this.profesorEnCurso.remove(profesorEnCurso);
        }
    }*/


    @OneToMany(
            mappedBy = "curso",
            orphanRemoval = true,
            cascade ={CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
        )
        private List<AlumnoEnCurso> alumnoEnCurso = new ArrayList<AlumnoEnCurso>();
        
    
        public void addAlumnoEnCurso(AlumnoEnCurso alumnoEnCurso) {
            if (!this.alumnoEnCurso.contains(alumnoEnCurso)) {
                this.alumnoEnCurso.add(alumnoEnCurso);
            }
        }

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
    public List<AlumnoEnCurso> getAlumnoEnCurso() {
        return alumnoEnCurso;
    }

    
    @Override
    public String toString() {
        return "curso: "+this.nombre;
    }

    
    
}
