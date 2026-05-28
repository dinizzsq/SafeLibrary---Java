package service;

import exception.BookNotFoundException;
import model.Book;
import repository.BookRepository;
import repository.BorrowedBooksRepository;

public class BookService {

    BookRepository bookRepository = new BookRepository();
    BorrowedBooksRepository borrowedBooksRepository = new BorrowedBooksRepository();

    public Book verificarBook(String nameBook){
        for(Book book: bookRepository.listar()){
            if (book.getNameBook()
                    .toLowerCase()
                    .contains(nameBook.toLowerCase())){
            }
            return book;
        }
        return null;
    }

    public void createBook(Book book){
        bookRepository.adicionar(book);
    }

    public void removeBook(String nome){
        Book book = verificarBook(nome);

        if (nome != null){
            bookRepository.remover(book);
            System.out.println("Livro removido!");
        }
        else throw new BookNotFoundException("Livro não encontrado.");


    }

    public void listBooks(){
        for (Book book: bookRepository.listar()){
            System.out.println(book);
        }
    }

//===================================================================

    public Book verifyBorroweds(String nameBook){
        for(Book book: borrowedBooksRepository.listar()){
            if (book.getNameBook()
                    .toLowerCase()
                    .contains(nameBook.toLowerCase())){
            }
            return book;
        }
        return null;
    }


    public void listBorrowed(){
        for (Book book: borrowedBooksRepository.listar()){
            System.out.println(book);
        }
    }

    public void removeBorroweds(Book book){
        borrowedBooksRepository.remover(book);
    }
}
