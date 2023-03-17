package com.campusVirtual.dto;


import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class ProfessorDto {
    private Long id;
    private String name;
    private String especiality;

    public ProfessorDto(){}

}
