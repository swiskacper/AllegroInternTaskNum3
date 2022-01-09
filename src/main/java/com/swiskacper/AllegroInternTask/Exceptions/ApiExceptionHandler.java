package com.swiskacper.AllegroInternTask.Exceptions;

import com.swiskacper.AllegroInternTask.Exceptions.Models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IncorrectNameException.class})
    public ResponseBodyException badRequestHandler(RuntimeException e) {
        return new ResponseBodyException("404", new IncorrectNameException().getMessage(), LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {SthNotFoundException.class})
    public ResponseBodyException notFoundHandler(RuntimeException e) {
        return new ResponseBodyException("404", new SthNotFoundException().getMessage(), LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseBodyException notReadableHandler(RuntimeException e) {
        return new ResponseBodyException("404", e.getMessage(), LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {InternalServerExcept.class})
    public ResponseBodyException internalErrorHandler(RuntimeException e) {
        return new ResponseBodyException("500", e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = {ServerErrorExcept.class})
    public ResponseBodyException serverErrorExcept(RuntimeException e) {
        return new ResponseBodyException("500", new ServerErrorExcept().getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = {ClientErrorExcept.class})
    public ResponseBodyException clientErrorExcept(RuntimeException e) {
        return new ResponseBodyException("4xx", new ClientErrorExcept().getMessage(), LocalDateTime.now());
    }
}
