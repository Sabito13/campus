package com.campusVirtual.model;

import javax.persistence.*;

@Entity(name="AlumnoEnCurso")
@Table(
    name="alumnoencurso",
    uniqueConstraints = {
        @UniqueConstraint(
            name="alumnoencuros_id_constraint",columnNames = "id"
        )
    }
)
public class AlumnoEnCurso {
    @Id
        @SequenceGenerator(
            name = "generadoIdAlumnoEnCurso",
            sequenceName = "ALUMNOENCURSO_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdAlumnoEnCurso",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;


        @ManyToOne()
        @JoinColumn(
            name="alumno_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="alumno_curso_id")
            
        )
        private Alumno alumno;


        @ManyToOne()
        @JoinColumn(
            name="curso_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="curso_alumno_id")
            
        )
        private Curso curso;


        public AlumnoEnCurso(){}

        public void setAlumno(Alumno alumno) {
            this.alumno = alumno;
        }
        public void setCurso(Curso curso) {
            this.curso = curso;
        }

        public Alumno getAlumno() {
            return alumno;
        }

        public Curso getCurso() {
            return curso;
        }

        @Override
        public String toString() {
            return ""+this.alumno+""+this.curso;
        }


    
}
