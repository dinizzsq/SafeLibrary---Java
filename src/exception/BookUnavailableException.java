package exception;

public class BookUnavailableException extends RuntimeException {

    public BookUnavailableException(String mensagem){
        super(mensagem);
    }
}