package com.campusVirtual.model;

import java.util.Date;


import javax.persistence.*;

@Entity(name="CourseContent")
@Table(name = "course_content",
uniqueConstraints ={
    @UniqueConstraint(name="course_content_id_constraint",columnNames = "id")
})
public class CourseContent {
        
        //@SequenceGenerator(
        //    name = "generadoIdCourseContent",
        //    sequenceName = "COURSE_CONTENT_GENERADOR_ID",
        //    initialValue=1,
        //    allocationSize = 1
        //)
        //@GeneratedValue(
        //    generator = "generadoIdCourseContent",
        //    strategy = GenerationType.SEQUENCE)
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        
        @Temporal(TemporalType.TIMESTAMP)
        private Date utilDate;

        //@Column(name = "REGIST_DATE", updatable = false, nullable = false)
        //@Temporal(TemporalType.DATE)
        //private Calendar utilCalendar;


        @ManyToOne()
        @JoinColumn(
            name="course_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="content_course_id")
            
        )
        private Course course;

        public CourseContent(){}

        public void setCourse(Course course) {
            this.course = course;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public void setContent(String content) {
            this.content = content;
        }

        

        public Course getCourse() {
            return this.course;
        }

        public Long getId() {
            return this.id;
        }
        public String getContent() {
            return this.content;
        }

       
        



        public Date getUtilDate() {
            return utilDate;
        }
     
        public void setUtilDate(Date utilDate) {
            this.utilDate = utilDate;
        }
       
}
