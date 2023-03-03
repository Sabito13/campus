package com.campusVirtual.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity(name="Alumno")
@Table(
    name="alumno",
    uniqueConstraints = {
        @UniqueConstraint(name="alumno_id_constraint",columnNames = "id")
    }
)
public class Alumno {

    @Id
        @SequenceGenerator(
            name = "generadoIdAlumno",
            sequenceName = "ALUMNO_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdAlumno",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;

        @Column(
            name="nombre",
            updatable = true,
            nullable = false,
            unique = false
        )
        private String nombre;


        @OneToMany(
            mappedBy = "alumno",
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






        public Alumno(){}
        public Alumno(String nombre){
            this.nombre=nombre;
        }
        
        public void setId(Long id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Long getId() {
            return this.id;
        }

        public String getNombre() {
            return this.nombre;
        }

        public List<AlumnoEnCurso> getAlumnoEnCurso() {
            return this.alumnoEnCurso;
        }

        @Override
        public String toString() {
            return " Alumno: "+this.nombre;
        }
}
