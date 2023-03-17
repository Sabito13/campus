package com.campusVirtual.mapper;

import java.util.List;
import java.util.ArrayList;

import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.model.Professor;

public class ProfessorMapper {
     public ProfessorDto professorToProfessorDto(Professor professor){
        ProfessorDto  pDto = new ProfessorDto();

        pDto.setId(professor.getId());
        pDto.setName(professor.getUser().getName());
        pDto.setEspeciality(professor.getEspeciality());

        return pDto;
    }

    public List<ProfessorDto> manyProfessorToProfessorDto(List<Professor> professors){
        
        List<ProfessorDto>  pDtos =  new ArrayList<>();

        for (Professor professor : professors) {
            pDtos.add(professorToProfessorDto(professor));
        }

            return pDtos;
        }
    }
