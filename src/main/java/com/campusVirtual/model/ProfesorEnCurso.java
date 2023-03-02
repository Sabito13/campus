package com.campusVirtual.model;

import javax.persistence.*;
    

    @Entity(name="ProfesorEnCurso")
    @Table(
        name="profesorencurso",
        uniqueConstraints = {
            @UniqueConstraint(
                    name="profesorencurso_id_constraint",
                    columnNames = "id")
        }
    )
    public class ProfesorEnCurso {
        @Id
        @SequenceGenerator(
            name = "generadoIdProfesorEnCurso",
            sequenceName = "PROFESORENCURSO_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdProfesorEnCurso",
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
                    name = "profesor_curso_fk"
            )
    )
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(
            name = "curso_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "curso_profesor_fk"
            )
    )
    private Curso curso;

        public ProfesorEnCurso(){        }
    public ProfesorEnCurso(Profesor profesor,Curso curso){
        this.profesor = profesor;
        this.curso = curso;
        }
        
            public void setProfesor(Profesor profesor){
                this.profesor = profesor;
            }

            public void setCurso(Curso curso){
                this.curso = curso;
            }
            public Curso getCurso() {
                return curso;
            }

            public Profesor getProfesor() {
                return profesor;
            }



            public void setId(Long id) {
                this.id = id;
            }

            public Long getId() {
                return this.id;
            }

            @Override
            public String toString() {
                return ""+this.profesor+""+this.curso;
            }
        }
