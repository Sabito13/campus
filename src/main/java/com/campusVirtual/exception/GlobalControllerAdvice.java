package com.campusVirtual.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice{

    
    @ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Error> handleAlumnoNotFoundException(StudentNotFoundException ex){
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}


	@ExceptionHandler(ProfessorNotFoundException.class)
	public ResponseEntity<Error> handleProfesorNotFoundException(ProfessorNotFoundException ex){
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Error> handleCursoNotFoundException(CourseNotFoundException ex){
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
