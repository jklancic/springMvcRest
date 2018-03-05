package guru.springfamework.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<Object> handleEntityNotFound(Exception e, WebRequest request) {
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
