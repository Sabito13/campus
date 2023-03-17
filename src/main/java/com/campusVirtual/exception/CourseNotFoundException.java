package com.campusVirtual.exception;

public class CourseNotFoundException extends RuntimeException {

	public CourseNotFoundException(String message) {
		super(message);

	}
    
    public CourseNotFoundException(Long id) {
		super("Curso no encontrado. ID: " + id);
	}
    
}
