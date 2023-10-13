package com.lmg.viewmodels.login;

import com.lmg.models.daos.DAO;
import com.lmg.models.pojos.User;
import com.lmg.views.login.ILoginViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel implements ILoginViewModel{
    
    private DAO<User> userDAO;
    private StringProperty username;
    private StringProperty password;

    public LoginViewModel(DAO<User> userDAO) {
        this.userDAO = userDAO;
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    public void login(String name, String password) {

    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
