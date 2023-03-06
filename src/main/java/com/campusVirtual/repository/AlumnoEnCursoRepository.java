package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.campusVirtual.model.AlumnoEnCurso;

public interface AlumnoEnCursoRepository extends JpaRepository<AlumnoEnCurso,Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM AlumnoEnCurso aec where aec.alumno_id = ?1 and aec.curso_id = ?2",
    nativeQuery = true)
    void deleteAlumnoEnCursoByBothId(Long idAlumno, Long idCurso);
     
}
