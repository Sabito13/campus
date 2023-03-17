package com.campusVirtual.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.CursoNotFoundException;
import com.campusVirtual.mapper.CourseMapper;
import com.campusVirtual.model.Student;
import com.campusVirtual.model.Userdata;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.Professor;
import com.campusVirtual.repository.CourseRepository;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IUserDataService;

@Service
public class CourseService implements ICourseService {

    
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private IUserDataService userDataService;

    private CourseMapper cMapper = new CourseMapper();

   

    @Override
    public Course saveCourse(Course course){
        return this.courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id){
        return this.courseRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
    }
    
    @Override
    public CourseDto getCourseDtoById(Long id){
       return  this.cMapper.courseToCourseDto(this.getCourseById(id));
    }

    


    @Override
    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }

    @Override
    public List<CourseDto> getAllCoursesDtos(){
       return this.cMapper.manyCourseToCourseDto(getAllCourses());
    }

    @Override
    public void deleteCourseById(Long idCourse){
        if(this.courseRepository.existsById(idCourse)){
            this.courseRepository.deleteById(idCourse);
        }else{
            throw new CursoNotFoundException(idCourse);
        }
    }

    @Override
    public boolean existsCourseById(Long idCourse) {
        return this.courseRepository.existsById(idCourse);
    }

   

    @Override
    public List<CourseDto> getAllCoursesOfProfessor(Long idProfessor) {
        Userdata userData = this.userDataService.getUserById(idProfessor);

        Professor professor = userData.getProfessor();

        List<CourseDto> coursesProfessor= this.cMapper.manyProfessorInCourseToCourseDto(professor.getProfessorInCourse());
        
        return coursesProfessor;
    }

    @Override
    public List<CourseDto> getAllCoursesOfStudent(Long idStudent){
        Userdata userData = this.userDataService.getUserById(idStudent);

        Student student = userData.getStudent();

        List<CourseDto> coursesStudent= this.cMapper.manyStudentInCourseToCourseDto(student.getStudentInCourse());
        
        return coursesStudent;
    }
  

    @Override
    public CourseDto saveCourseDto(CourseDto courseDto) {
      Course course = new Course(courseDto.getName());
      
      course = this.courseRepository.save(course);

      return this.cMapper.courseToCourseDto(course);

    }



   
    
}
