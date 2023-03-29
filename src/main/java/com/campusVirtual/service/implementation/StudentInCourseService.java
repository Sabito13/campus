package com.campusVirtual.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.campusVirtual.model.Student;
import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.model.Course;
import com.campusVirtual.repository.StudentInCourseRepository;
import com.campusVirtual.service.IStudentInCourseService;
import com.campusVirtual.service.IStudentService;
import com.campusVirtual.service.ICourseService;

@Service
public class StudentInCourseService  implements IStudentInCourseService{
    
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private StudentInCourseRepository sicRepository;

    @Autowired
    private UserDataService userDataService;

   

    @Override
    public CourseDto setStudentInCourse(Long idStudent, Long idCourse) {
        Student student= this.studentService.getStudentById(idStudent);
        Course course=this.courseService.getCourseById(idCourse);
        this.sicRepository.save(new StudentInCourse(student,course));

        return this.courseService.getCourseDtoById(idCourse);
    }

    
    @Override
    public void deleteStudentInCourse(Long idStudent, Long idCourse) {
        this.sicRepository.deleteStudentInCourseByBothId(idStudent,idCourse);
    }


    @Override
    public void deleteStudentInCourseByUsername(String username, Long idCourse) {
        Long idStudent =this.userDataService.getUserById(username).getStudent().getId();
       
        this.deleteStudentInCourse(idStudent,idCourse);
    }


    @Override
    public CourseDto setStudentInCourseByUsername(String username, Long idCourse) {
        Long idStudent =this.userDataService.getUserById(username).getStudent().getId();
    
        return this.setStudentInCourse(idStudent,idCourse);
    }
}

    

   


