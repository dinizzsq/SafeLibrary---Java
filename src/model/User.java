package model;

public class User extends People{
    private int idUser;
    private int loans;

    public User(String name, int age, int idUser, int loans) {
        super(name, age);
        this.idUser = idUser;
        this.loans = loans;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getLoans() {
        return loans;
    }

    public void setLoans(int loans) {
        this.loans = loans;
    }
}
