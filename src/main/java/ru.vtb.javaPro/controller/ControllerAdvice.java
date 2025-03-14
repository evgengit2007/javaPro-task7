package ru.vtb.javaPro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vtb.javaPro.dto.ErrorResponseLocal;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseLocal handlerRuntimeException(RuntimeException exception) {
        return new ErrorResponseLocal(HttpStatus.INTERNAL_SERVER_ERROR.name(), exception.getMessage());
    }
}
