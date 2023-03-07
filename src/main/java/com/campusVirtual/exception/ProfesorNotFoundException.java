package com.campusVirtual.exception;

public class ProfesorNotFoundException extends RuntimeException {

	public ProfesorNotFoundException(String message) {
		super(message);

	}
    
    public ProfesorNotFoundException(Long id) {
		super("Profesor no encontrado. ID: " + id);
	}
    
}
