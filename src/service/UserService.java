package service;

import exception.BookNotFoundException;
import exception.BookUnavailableException;
import model.Book;
import model.User;
import repository.BookRepository;
import repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();
    private BookRepository bookRepository = new BookRepository();
    private BookService bookService = new BookService();

    public void excluirUser(String nome){
        User user = verificarUser(nome);

        if (nome!=null){
            userRepository.remover(user);
            System.out.println("User "+" removido!");
        }
        else throw new RuntimeException("User não encontrado");
    }

    public void listarUser(){
        for(User user : userRepository.listar()){
            System.out.println(user);
        }
    }

    public User verificarUser(String name){

        for(User user : userRepository.listar()){

            if(user.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())){

                return user;
            }
        }

        return null;
    }

    public Book devolverLivro(String nome){
        Book book = bookService.verifyBorroweds(nome);

        if (book != null){

            System.out.println("Livro devolvido!");

            bookService.removeBorroweds(book);

            return book;

        }
        throw new BookNotFoundException("Livro não encontrado.");
    }


    public void cadastrarUser(String nameUser, int age, int idUser, int loans) {
        User user = new User(nameUser, age, idUser, loans);
        userRepository.adicionar(user);
    }
}