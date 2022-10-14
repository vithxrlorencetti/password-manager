package br.com.uniamerica.passwordmanager.exceptions;

import org.hibernate.PropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PasswordNotFound.class)
    public ResponseEntity<?> passwordNotFoundException(PasswordNotFound x, ServletWebRequest rec){
        return ResponseEntity.status(404).body(new ApiResponseError(x.getMessage(), rec.getRequest().getRequestURI()));
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<?> cannotSavePasswordException(PropertyValueException x, ServletWebRequest rec){
        return ResponseEntity.status(404).body(new ApiResponseError(x.getMessage(), rec.getRequest().getRequestURI()));
    }


}
