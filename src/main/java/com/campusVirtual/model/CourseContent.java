package com.campusVirtual.model;

import javax.persistence.*;

@Entity(name="CourseContent")
@Table(name = "coursecontent",
uniqueConstraints ={
    @UniqueConstraint(name="course_content_id_constraint",columnNames = "id")
})
public class CourseContent {
        @Id
        @SequenceGenerator(
            name = "generadoIdCourseContent",
            sequenceName = "COURSE_CONTENT_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdCourseContent",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;

        @Column(
            name = "content",
            updatable = true,
            nullable = false,
            unique = false
        )
        private String content;


        @ManyToOne()
        @JoinColumn(
            name="course_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="content_course_id")
            
        )
        private Course course;
}
