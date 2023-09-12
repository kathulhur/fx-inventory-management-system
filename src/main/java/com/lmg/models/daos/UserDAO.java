package com.lmg.models.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lmg.models.pojos.User;

public class UserDAO implements DAO<User>{
    private List<User> users = new ArrayList<>();

    public UserDAO() {
        users.add(new User("admin", "admin"));
        users.add(new User("user", "user"));
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User t) {
        users.add(t);
    }

    @Override
    public void update(User t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(User t) {
        users.remove(t);
    }
    
    
}
