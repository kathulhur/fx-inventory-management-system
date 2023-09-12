package com.lmg.viewmodels;

import com.lmg.models.daos.DAO;
import com.lmg.models.pojos.User;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SignupViewModel {
    
    private DAO<User> userDAO;
    private StringProperty username;
    private StringProperty password;

    public SignupViewModel(DAO<User> userDAO) {
        this.userDAO = userDAO;
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    public void signup(String name, String password) {
        userDAO.save(new User(name, password));

        for (User user : userDAO.getAll()) {
            System.out.println(user.getName());
        }
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
