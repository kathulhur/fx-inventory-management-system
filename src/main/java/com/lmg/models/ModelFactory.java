package com.lmg.models;

import com.lmg.models.daos.DAO;
import com.lmg.models.daos.ProductDAO;
import com.lmg.models.daos.UserDAO;
import com.lmg.models.pojos.Product;
import com.lmg.models.pojos.User;

public class ModelFactory {
    private DAO<User> userDAO;
    private DAO<Product> productDAO;

    public DAO<User> getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public DAO<Product> getProductDAO() {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    
}
