package exception;

public class InvalidEnterException extends RuntimeException{
    public InvalidEnterException(String mensagem){
        super(mensagem);
    }
}
