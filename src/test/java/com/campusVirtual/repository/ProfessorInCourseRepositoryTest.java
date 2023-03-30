package com.campusVirtual.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.campusVirtual.model.*;

@DataJpaTest
public class ProfessorInCourseRepositoryTest {
  
  @Autowired
  private UserDataRepository userDataRepository;

  @Autowired
  private ProfessorRepository professorRepository;

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private ProfessorInCourseRepository professorInCourseRepository;


  
  
  @BeforeEach
  void setUp(){
    //New User is created
    String username = "userOne";

    Userdata userdata = new Userdata(
          username,
            "password",
          "jamila",
          "daz",
          "jamila@gmail.com"
    );
    this.userDataRepository.save(userdata);

    //New professor is created
    Professor profesorSet = new Professor("English");
    profesorSet.setUser(this.userDataRepository.findById(username).get());
    profesorSet.setId((long)1);
    profesorSet = this.professorRepository.save(profesorSet);

    //New Course Is Created
    Course miCourse=this.courseRepository.save(new Course("English 2"));

    //New relation Professor in Course is created
    ProfessorInCourse pic = new ProfessorInCourse(profesorSet,miCourse);
    this.professorInCourseRepository.save(pic);
  }


  @Test
  void deleteProfessorInCourseByBothId(){
    Long idProfessor = (long)1;
    Long idCourse = (long)1;
    assertTrue(
    this.professorInCourseRepository.existsById(idCourse));
    this.professorInCourseRepository.deleteProfessorInCourseByBothId(idProfessor,idCourse);
    
    assertFalse(
      this.professorInCourseRepository.existsById(idCourse));
  }
}
