package com.campusVirtual.repository;

  
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.campusVirtual.model.*;


@DataJpaTest
public class StudentInCourseRepositoryTest {
  
  @Autowired
  private UserDataRepository userDataRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private StudentInCourseRepository studentInCourseRepository;


  
  @BeforeEach
  void setUp(){
    //New User is created
    String username = "userOne";

    Userdata userdata = new Userdata(
          username,
            "password",
          "jamila",
          "daz",
          "jamila@gmail.com",
          "ROLE_STUDENT"
    );
    this.userDataRepository.save(userdata);

    //New student is created
    Student studentSet = new Student();
    studentSet.setUser(this.userDataRepository.findById(username).get());
    studentSet = this.studentRepository.save(studentSet);

    //New Course Is Created
    Course miCourse=this.courseRepository.save(new Course("English 2"));

    //New relation Professor in Course is created
    StudentInCourse pic = new StudentInCourse(studentSet,miCourse);
    this.studentInCourseRepository.save(pic);
  }


  @Test
  void deleteStudentInCourseByBothId(){
    Long idProfessor = (long)1;
    Long idCourse = (long)1;
    assertTrue(
    this.studentInCourseRepository.existsById(idCourse));
    this.studentInCourseRepository.deleteStudentInCourseByBothId(idProfessor,idCourse);
    
    assertFalse(
      this.studentInCourseRepository.existsById(idCourse));
  }
}


  

