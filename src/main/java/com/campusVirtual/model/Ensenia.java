package com.campusVirtual.model;

import javax.persistence.*;
    

    @Entity(name="Ensenia")
    @Table(
        name="ensenia",
        uniqueConstraints = {
            @UniqueConstraint(
                    name="ensenia_id_constraint",
                    columnNames = "id")
        }
    )
    public class Ensenia {
        @Id
        @SequenceGenerator(
            name = "generadoIdEnsenia",
            sequenceName = "ENSENIA_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdEnsenia",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;
    


    @ManyToOne
    @JoinColumn(
            name = "profesor_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "profesor_ensenia_fk"
            )
    )
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(
            name = "curso_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "curso_ensenia_fk"
            )
    )
    private Curso curso;


    public Ensenia(Profesor profesor,Curso curso){
        this.profesor = profesor;
        this.curso = curso;
        }
        
            public void setProfesor(Profesor profesor){
                this.profesor = profesor;
            }

            public void setCurso(Curso curso){
                this.curso = curso;
            }
            
        }
