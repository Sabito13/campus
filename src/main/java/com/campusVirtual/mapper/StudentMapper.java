package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.model.Student;

public class StudentMapper {

    public StudentDto studentToStudentDto(Student student){
        StudentDto  sDto = new StudentDto();

        sDto.setId(student.getId());
        sDto.setName(student.getUser().getName());

        return sDto;
    }

    public List<StudentDto> manyStudentToStudentDto(List<Student> students){
        
        List<StudentDto>  sDtos =  new ArrayList<>();

        for (Student student : students) {
            sDtos.add(studentToStudentDto(student));
        }

            return sDtos;
        }
    }

