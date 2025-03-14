package javaPro.controller;

import javaPro.exception.*;
import javaPro.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ExceptionPaymentParam.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handlerPaymentParamException(ExceptionPaymentParam exception) {
        return new ResponseError(HttpStatus.BAD_REQUEST.name() , exception.getMessage());
    }

    @ExceptionHandler(ExceptionRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handlerRequestException(ExceptionRequest exception) {
        return new ResponseError(exception.getHttpStatus().name(), exception.getMessage());
    }

    @ExceptionHandler(ExceptionProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseError handlerProductNotFoundException(ExceptionProductNotFound exception) {
        return new ResponseError(HttpStatus.NOT_FOUND.name() , exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseError handlerIntegrationException(ExceptionIntegration exception) {
        ExceptionServer5xx server5xx = exception.getException5xxDTO();
        String message = server5xx.getError() +  " for path = " + server5xx.getPath();
        return new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.name() , message);
    }

}
