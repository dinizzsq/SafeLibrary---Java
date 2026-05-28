package repository;

import model.Book;

import java.util.ArrayList;

public class BookRepository extends GenericRepository<Book>{
    ArrayList<Book> books = new ArrayList<>();
}
