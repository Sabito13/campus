package com.campusVirtual.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.campusVirtual.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor,Long>{
    
}
