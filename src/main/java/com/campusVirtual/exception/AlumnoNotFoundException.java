package com.campusVirtual.exception;

public class AlumnoNotFoundException  extends RuntimeException {

	public AlumnoNotFoundException(String message) {
		super(message);

	}
    
    public AlumnoNotFoundException(Long id) {
		super("Alumno no encontrado. ID: " + id);
	}
}
