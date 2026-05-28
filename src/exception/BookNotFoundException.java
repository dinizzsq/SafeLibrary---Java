package exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String mensagem){
        super(mensagem);

    }
}
