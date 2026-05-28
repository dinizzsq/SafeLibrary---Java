package model;

public class Librarian extends People {
    private int idlibrarian;

    public Librarian(String name, int age, int idlibrarian) {
        super(name, age);
        this.idlibrarian = idlibrarian;
    }

    public int getIdlibrarian() {
        return idlibrarian;
    }

    public void setIdlibrarian(int idlibrarian) {
        this.idlibrarian = idlibrarian;
    }
}
