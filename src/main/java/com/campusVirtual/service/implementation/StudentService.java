package com.campusVirtual.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.exception.ObjectNotFoundException;
import com.campusVirtual.mapper.StudentMapper;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.Student;
import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.model.Userdata;
import com.campusVirtual.repository.StudentRepository;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IStudentService;
import com.campusVirtual.service.IUserDataService;




@Service
public class StudentService implements IStudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IUserDataService userDataService;  
    
    @Autowired
    private ICourseService courseService; 

    private StudentMapper sMapper = new StudentMapper();

    @Override
    public StudentDto saveStudent(String username) {
        Student studentSet;
        
        studentSet = this.studentRepository.save(new Student());
        studentSet.setUser(this.userDataService.getUserById(username));
        
        studentSet = this.studentRepository.save(studentSet);
        

        return this.sMapper.studentToStudentDto(studentSet);
    }
   


    @Override
    public Student getStudentById(Long idStudent) {
        return this.studentRepository.findById(idStudent).orElseThrow(()->new ObjectNotFoundException("Student",idStudent));
    }


    @Override
    public StudentDto getStudentDtoById(Long idStudent) {
        Student student = this.getStudentById(idStudent);

        return this.sMapper.studentToStudentDto(student);
       
    }


    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public List<StudentDto> getAllStudentsDto() {
        return this.sMapper.manyStudentToStudentDto(getAllStudents());
        }


  


    @Override
    public List<StudentDto> getAllStudentsOfCourse(Long idCourse) {
        Course course = this.courseService.getCourseById(idCourse);
        
        List<StudentInCourse> studentsRelation=course.getStudentInCourse();
        
        List<Student> students=new ArrayList<>();
        for (StudentInCourse studentR : studentsRelation) {
            students.add(studentR.getStudent());
        }

        return this.sMapper.manyStudentToStudentDto(students);
    }

    @Override
    public boolean existStudentById(Long idStudent) {
        return this.studentRepository.existsById(idStudent);
    }

    @Override
    public void deleteStudentById(Long idStudent){
        if(this.studentRepository.existsById(idStudent)){
            this.studentRepository.deleteById(idStudent);
        }else{
            throw new ObjectNotFoundException("Student",idStudent);
        }
    }



    @Override
    public StudentDto getStudentDtoByUsername(String username) {
        Userdata ud =this.userDataService.getUserById(username);
       return this.getStudentDtoById(ud.getStudent().getId());
    }

  
}
