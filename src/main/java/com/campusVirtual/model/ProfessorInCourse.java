package com.campusVirtual.model;

import javax.persistence.*;
    

    @Entity(name="ProfessorInCourse")
    @Table(
        name="professor_in_course",
        uniqueConstraints = {
            @UniqueConstraint(
                    name="professorInCourse_id_constraint",
                    columnNames = "id")
        }
    )
    public class ProfessorInCourse {
      
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;
    


    @ManyToOne
    @JoinColumn(
            name = "professor_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "professor_course_fk"
            )
    )
    private Professor professor;

    @ManyToOne
    @JoinColumn(
            name = "course_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "course_professor_fk"
            )
    )
    private Course course;

        public ProfessorInCourse(){        }
        public ProfessorInCourse(Professor professor,Course course){
        this.professor = professor;
        this.course = course;
        }
        
        public Long getId() {
          return id;
        }
        
        public Professor getProfessor() {
          return professor;
        }

        public Course getCourse() {
          return course;
        }

        public void setId(Long id) {
          this.id = id;
        }

        public void setCourse(Course course) {
          this.course = course;
        }

        public void setProfessor(Professor professor) {
          this.professor = professor;
        }
}
