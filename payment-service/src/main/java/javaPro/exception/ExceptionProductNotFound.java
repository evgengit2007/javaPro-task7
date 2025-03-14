package javaPro.exception;

import lombok.Getter;

@Getter
public class ExceptionProductNotFound extends RuntimeException {
    private final String message;

    public ExceptionProductNotFound(String message) {
        super(message);
        this.message = message;
    }
}
