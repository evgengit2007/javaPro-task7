package javaPro.exception;

public class ExceptionLowBalance extends RuntimeException {
    private final String message;

    public ExceptionLowBalance(String message) {
        super(message);
        this.message = message;
    }
}
