package com.campusVirtual.exception;

public class StudentNotFoundException  extends RuntimeException {

	public StudentNotFoundException(String message) {
		super(message);

	}
    
    public StudentNotFoundException(Long id) {
		super("Alumno no encontrado. ID: " + id);
	}
}
