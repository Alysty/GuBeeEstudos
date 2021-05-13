package com.web_nosql.projeto_web_nosql_secao26.resources.exception;

import com.web_nosql.projeto_web_nosql_secao26.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e , HttpServletRequest request){
       String errorMessage = "Not found";
       HttpStatus status = HttpStatus.NOT_FOUND;

       StandardError error = new StandardError(System.currentTimeMillis(),
                                       status.value(),errorMessage,e.getMessage(),
                                       request.getRequestURI());
       return ResponseEntity.status(status).body(error);
    }
}
