package com.lmg.models;

import com.lmg.models.daos.ProductDAO;
import com.lmg.models.daos.TransactionDAO;
import com.lmg.models.daos.UserDAO;

public class ModelFactory {
    private UserDAO userDAO;
    private ProductDAO productDAO;
    private TransactionDAO transactionDAO;

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public ProductDAO getProductDAO() {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    public TransactionDAO getTransactionDAO() {
        if (transactionDAO == null) {
            transactionDAO = new TransactionDAO();
        }
        return transactionDAO;
    }

    
}
