package service;

import exception.BookNotFoundException;
import exception.BookUnavailableException;
import exception.LoanLimitException;
import model.Book;
import model.Librarian;

import model.User;
import repository.BookRepository;
import repository.BorrowedBooksRepository;
import repository.LibrarianRepository;

public class LibrarianService {

    LibrarianRepository librarianRepository = new LibrarianRepository();
    BookService bookService = new BookService();
    BookRepository bookRepository = new BookRepository();
    BorrowedBooksRepository borrowedBooksRepository = new BorrowedBooksRepository();
    UserService userService = new UserService();

    public void cadastrarBibliotecaria(Librarian librarian) {
        librarianRepository.adicionar(librarian);
    }

    public Librarian verificarLibrarian(String name) {
        for (Librarian librarian : librarianRepository.listar()) {
            if (librarian.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) ;

            return librarian;
        }
        return null;
    }

    public void excluirBibliotecaria(String name) {
        Librarian librarian = verificarLibrarian(name);

        if (name != null) {
            librarianRepository.remover(librarian);

            System.out.println("Librarian " + " removida.");
        }
        else throw new RuntimeException("Librarian não encontrada.");
    }

    public void listarLibrarians() {
        for (Librarian librarian : librarianRepository.listar()) {
            System.out.println(librarian);
        }
    }



    public Book emprestarLivro(String nome, User user) {

        Book book = bookService.verificarBook(nome);

        if (book == null) {
            throw new BookNotFoundException("Livro não encontrado.");
        }

        if (user.getLoans() >= 5) {
            throw new LoanLimitException("Limite de empréstimos atingido.");
        }

        System.out.println("Livro emprestado!");


        bookRepository.remover(book);

        borrowedBooksRepository.adicionar(book);

        user.setLoans(user.getLoans() + 1);

        return book;
    }
}
