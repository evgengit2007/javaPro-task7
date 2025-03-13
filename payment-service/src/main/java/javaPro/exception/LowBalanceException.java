package javaPro.exception;

public class LowBalanceException extends RuntimeException {
    private final String message;

    public LowBalanceException(String message) {
        super(message);
        this.message = message;
    }
}
