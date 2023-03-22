package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.model.CourseContent;

public class CourseContentMapper {
    public CourseContentDto courseContentToDto(CourseContent cContent){
        CourseContentDto ccDto = new CourseContentDto();
        ccDto.setContent(cContent.getContent());
        ccDto.setId(cContent.getId());
        return ccDto; 
    }

    public List<CourseContentDto> manyCourseContentToDto(List<CourseContent> cContent){
        List<CourseContentDto> ccDtos = new ArrayList<>();

        for (CourseContent courseContent : cContent) {
            ccDtos.add(courseContentToDto(courseContent));
        }
        
        return ccDtos;
    }
}
