package com.campusVirtual.exception;

public class ProfessorNotFoundException extends RuntimeException {

	public ProfessorNotFoundException(String message) {
		super(message);

	}
    
    public ProfessorNotFoundException(Long id) {
		super("Profesor no encontrado. ID: " + id);
	}
    
}
