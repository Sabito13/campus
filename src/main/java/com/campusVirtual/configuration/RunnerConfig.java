package com.campusVirtual.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.model.Course;
import com.campusVirtual.security.userPasswordFilter.UserDetailServiceImplementacion;
import com.campusVirtual.service.ICourseContentService;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IProfessorInCourseService;
import com.campusVirtual.service.IStudentInCourseService;

@Component
public class RunnerConfig implements CommandLineRunner {

  @Autowired
  private UserDetailServiceImplementacion userDataService;

  @Autowired
  private ICourseService courseService;

  @Autowired
  private ICourseContentService courseContentService;


  @Autowired
  private IProfessorInCourseService professorInCourseService;


  @Autowired
  private IStudentInCourseService studentInCourseService;

  @Override
  public void run(String... args) throws Exception {
   
    System.out.println("CommandLineRunner starter");
    this.setUsers();
    this.setCourses();
    this.setProfessorInCourse();
    this.setStudentInCourse();
    this.setContentInCourse();
   
  };



  private void setUsers(){
    // String username, String password, String name, String lastName, String mail,
    
    UserRegisterDto admin = new UserRegisterDto("admin", "password", "ad", "lasto", "lasto@mail.com", "ROLE_ADMIN");
    this.userDataService.saveUser(admin);

    UserRegisterDto student1 = new UserRegisterDto("student1", "password", "ad", "lasto", "lasto1@mail.com",
        "ROLE_STUDENT");
    this.userDataService.saveUser(student1);

    UserRegisterDto student2 = new UserRegisterDto("student2", "password", "ad", "lasto", "lasto2@mail.com",
        "ROLE_STUDENT");
    this.userDataService.saveUser(student2);

    UserRegisterDto student3 = new UserRegisterDto("student3", "password", "ad", "lasto", "lasto3@mail.com",
        "ROLE_STUDENT");
    this.userDataService.saveUser(student3);

    UserRegisterDto professor1 = new UserRegisterDto("professor1", "password", "ad", "lasto", "lasto4@mail.com",
        "ROLE_PROFESSOR");
    this.userDataService.saveUser(professor1);

    UserRegisterDto professor2 = new UserRegisterDto("professor2", "password", "ad", "lasto", "lasto5@mail.com",
        "ROLE_PROFESSOR");
    this.userDataService.saveUser(professor2);

    UserRegisterDto professor3 = new UserRegisterDto("professor3", "password", "ad", "lasto", "lasto6@mail.com",
        "ROLE_PROFESSOR");
    this.userDataService.saveUser(professor3);
  }


  private void setCourses(){
    this.courseService.saveCourse(new Course("Math"));
    this.courseService.saveCourse(new Course("Operating system (OS)"));
    this.courseService.saveCourse(new Course("Comunication"));
  }



  private void setProfessorInCourse() {
    this.professorInCourseService.setProfessorInCourse((long)1, (long)1);
    this.professorInCourseService.setProfessorInCourse((long)2, (long)2);
    this.professorInCourseService.setProfessorInCourse((long)3, (long)3);
    this.professorInCourseService.setProfessorInCourse((long)2, (long)1);
  }

  private void setStudentInCourse() {
    this.studentInCourseService.setStudentInCourseByUsername("student1", (long)1);
    this.studentInCourseService.setStudentInCourseByUsername("student2", (long)1);
    this.studentInCourseService.setStudentInCourseByUsername("student3", (long)1);
    this.studentInCourseService.setStudentInCourseByUsername("student1", (long)2);
    this.studentInCourseService.setStudentInCourseByUsername("student2", (long)2);
    this.studentInCourseService.setStudentInCourseByUsername("student3", (long)2);
    this.studentInCourseService.setStudentInCourseByUsername("student2", (long)3);
    this.studentInCourseService.setStudentInCourseByUsername("student3", (long)3);
  }

  private void setContentInCourse() {
    CourseContentDto ccdtoAux = new CourseContentDto();
    
    //Course 1
    ccdtoAux.setContent("Welcome to Math");
    this.courseContentService.addCourseContentWithoutVerifier((long)1,ccdtoAux);

    //Course 2
    ccdtoAux.setContent("Welcome to Operating System");
    this.courseContentService.addCourseContentWithoutVerifier((long)2,ccdtoAux);

    //Course 3
    ccdtoAux.setContent("Welcome Students");
    this.courseContentService.addCourseContentWithoutVerifier((long)3,ccdtoAux);

    //Course 1
    ccdtoAux.setContent("the Math are amazing");
    this.courseContentService.addCourseContentWithoutVerifier((long)1,ccdtoAux);

    //Course 1
    ccdtoAux.setContent("Please do the homework in time");
    this.courseContentService.addCourseContentWithoutVerifier((long)1,ccdtoAux);

    //Course 2
    ccdtoAux.setContent("Execute commands to prove the terminal");
    this.courseContentService.addCourseContentWithoutVerifier((long)2,ccdtoAux);
  
  }
}
