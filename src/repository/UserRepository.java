package repository;

import model.User;

import java.util.ArrayList;

public class UserRepository extends GenericRepository<User>{
    ArrayList<User> users = new ArrayList<>();
}
