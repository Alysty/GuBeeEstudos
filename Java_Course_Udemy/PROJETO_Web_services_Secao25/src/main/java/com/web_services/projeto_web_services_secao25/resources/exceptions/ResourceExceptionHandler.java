package com.web_services.projeto_web_services_secao25.resources.exceptions;

import com.web_services.projeto_web_services_secao25.services.exceptions.DatabaseException;
import com.web_services.projeto_web_services_secao25.services.exceptions.ResouceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<StandardError> resouceNotFoundException(ResouceNotFoundException exception, HttpServletRequest request){
        String errorMessage = "Resource not Found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), httpStatus.value(), errorMessage, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(error);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException exception, HttpServletRequest request){
        String errorMessage = "Database error";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), httpStatus.value(), errorMessage, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(error);
    }
}
