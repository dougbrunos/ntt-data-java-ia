package java_bank.exception;

public class InvestmentNotFoundException extends RuntimeException {

    public InvestmentNotFoundException(String message) {
        super(message);
    }

    public InvestmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
