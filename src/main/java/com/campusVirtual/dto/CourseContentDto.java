package com.campusVirtual.dto;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class CourseContentDto {
    private Long id;
    private String content;
    
    public CourseContentDto(){}


    @Override
    public String toString() {
        return this.content;
    }
}
