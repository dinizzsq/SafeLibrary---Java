package repository;

import model.Book;

import java.util.ArrayList;

public class GenericRepository<T> {
    ArrayList<T> genericRepository = new ArrayList<>();

    public void adicionar(T object){
        genericRepository.add(object);
    }
    public Book remover(T object){
        genericRepository.remove(object);
        return null;
    }
    public ArrayList<T> listar(){
        return genericRepository;
    }
}
