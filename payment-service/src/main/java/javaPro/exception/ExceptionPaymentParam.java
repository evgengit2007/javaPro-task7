package javaPro.exception;

import lombok.Getter;

@Getter
public class ExceptionPaymentParam extends RuntimeException {
    private final String message;
    public ExceptionPaymentParam(String message) {
        super(message);
       this.message = message;
    }
}
