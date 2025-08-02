package java_bank.exception;

public class NoFundsEnoughException extends RuntimeException {

    public NoFundsEnoughException(String message) {
        super(message);
    }

    public NoFundsEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

}
