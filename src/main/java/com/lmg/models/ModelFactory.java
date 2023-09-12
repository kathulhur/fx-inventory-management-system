package com.lmg.models;

import com.lmg.models.daos.DAO;
import com.lmg.models.daos.UserDAO;
import com.lmg.models.pojos.User;

public class ModelFactory {
    private DAO<User> userDAO;

    public DAO<User> getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    
}
