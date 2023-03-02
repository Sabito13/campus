package com.campusVirtual.model;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
        //@OnDelete(action = OnDeleteAction.CASCADE)
        private List<Ensenia> ensenia = new ArrayList<Ensenia>();
        //private Ensenia ensenia;
    
        public void addEnsenia(Ensenia ensenia) {
            if (!this.ensenia.contains(ensenia)) {
                this.ensenia.add(ensenia);
                //empleado.setSucursal(this);
            }
        }


    
        public Profesor(){}
        public Profesor(String nombre,String especialidad){
            this.nombre = nombre;
            this.especialidad=especialidad;
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
