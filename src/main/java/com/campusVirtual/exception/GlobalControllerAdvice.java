package com.campusVirtual.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice{

    
    @ExceptionHandler(AlumnoNotFoundException.class)
	public ResponseEntity<Error> handleAlumnoNotFoundException(AlumnoNotFoundException ex){
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}


	@ExceptionHandler(ProfesorNotFoundException.class)
	public ResponseEntity<Error> handleProfesorNotFoundException(ProfesorNotFoundException ex){
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(CursoNotFoundException.class)
	public ResponseEntity<Error> handleCursoNotFoundException(CursoNotFoundException ex){
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
