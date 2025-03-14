package javaPro.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionRequest extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;

    public ExceptionRequest(HttpStatus type, String message) {
        super(message);
        this.httpStatus = type;
        this.message = message;
    }
}
