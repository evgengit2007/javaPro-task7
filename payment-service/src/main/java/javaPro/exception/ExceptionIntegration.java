package javaPro.exception;

public class ExceptionIntegration extends RuntimeException{
    private ExceptionServer5xx exceptionServer5xx;

    public ExceptionIntegration(String message) {
        super(message);
    }

    public ExceptionIntegration(String message, ExceptionServer5xx exceptionServer5xx) {
        super(message);
        this.exceptionServer5xx = exceptionServer5xx;
    }

    public ExceptionServer5xx getException5xxDTO() {
        return exceptionServer5xx;
    }

}
