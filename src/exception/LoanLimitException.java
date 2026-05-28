package exception;

public class LoanLimitException extends RuntimeException{
    public LoanLimitException(String mensagem){
        super(mensagem);
    }
}
