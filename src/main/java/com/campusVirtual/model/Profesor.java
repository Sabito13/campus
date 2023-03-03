package com.campusVirtual.model;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity(name="Profesor")
@Table(
    name="profesor",
    uniqueConstraints = {
        @UniqueConstraint(name="profesor_id_constraint",columnNames = "id")
    }
)
public class Profesor {

        @Id
        @SequenceGenerator(
            name = "generadoIdProfesor",
            sequenceName = "PROFESOR_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdProfesor",
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



        @Column(
            name="especialidad",
            updatable =true,
            nullable = false,
            unique = false
        )
        private String especialidad;


        @OneToMany(
            mappedBy = "profesor",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
            )
        private List<ProfesorEnCurso> profesorEnCurso = new ArrayList<ProfesorEnCurso>();
        
    
        public void addProfesorEnCurso(ProfesorEnCurso profesorEnCurso) {
            if (!this.profesorEnCurso.contains(profesorEnCurso)) {
                this.profesorEnCurso.add(profesorEnCurso);
            }
        }


    
        public Profesor(){}
        public Profesor(String nombre,String especialidad){
            this.nombre = nombre;
            this.especialidad=especialidad;
        }
    
        public Long getId() {
            return this.id;
        }
    
        public String getNombre() {
            return this.nombre;
        }
        
        public String getEspecialidad() {
            return this.especialidad;
        }
        
        public void setId(Long id) {
            this.id = id;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        @Override
        public String toString() {
    
        return "profesor: "+this.nombre+", especialidad: "+this.especialidad;
        }



        public List<ProfesorEnCurso> getProfesorEnCurso() {
            return this.profesorEnCurso;
        }



    
    }
