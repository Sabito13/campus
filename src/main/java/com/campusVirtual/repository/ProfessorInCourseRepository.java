package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.campusVirtual.model.ProfessorInCourse;

public interface ProfessorInCourseRepository extends JpaRepository<ProfessorInCourse,Long>{

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM professor_in_course pic where pic.professor_id = ?1 and pic.course_id = ?2",
    nativeQuery = true)
    void deleteProfessorInCourseByBothId(Long idProfessor, Long idCourse);
    
}
