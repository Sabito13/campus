package com.campusVirtual.exception;

public class CursoNotFoundException extends RuntimeException {

	public CursoNotFoundException(String message) {
		super(message);

	}
    
    public CursoNotFoundException(Long id) {
		super("Curso no encontrado. ID: " + id);
	}
    
}
