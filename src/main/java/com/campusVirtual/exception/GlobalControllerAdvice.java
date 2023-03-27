package com.campusVirtual.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice{

    
    @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleObjectNotFoundException(ObjectNotFoundException objectException){
		ErrorDetails error = new ErrorDetails(HttpStatus.NOT_FOUND, objectException.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(UserAlreadyExistsException userException){
		ErrorDetails error = new ErrorDetails(HttpStatus.BAD_REQUEST, userException.getMessage());
        
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(InvalidInputFieldException.class)
	public ResponseEntity<ErrorDetails> handleInvalidInputDataException(InvalidInputFieldException dataException){
		ErrorDetails error = new ErrorDetails(HttpStatus.BAD_REQUEST, dataException.getMessage());
        
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
