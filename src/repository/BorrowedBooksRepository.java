package repository;

import model.Book;

import java.util.ArrayList;

public class BorrowedBooksRepository extends GenericRepository<Book>{
    ArrayList<Book> borrowedBooks = new ArrayList<>();
}
