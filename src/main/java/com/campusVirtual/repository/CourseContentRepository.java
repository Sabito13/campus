package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.CourseContent;

public interface CourseContentRepository extends JpaRepository<CourseContent,Long>{
    
}
