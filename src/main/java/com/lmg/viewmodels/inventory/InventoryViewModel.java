package com.lmg.viewmodels.inventory;

import java.util.List;

import com.lmg.models.daos.DAO;
import com.lmg.models.pojos.Product;

public class InventoryViewModel implements IInventoryViewModel{
    private DAO<Product> productDAO;

    private int productsPerPage = 10;


    public InventoryViewModel(DAO<Product> productDAO) {
        this.productDAO = productDAO;
    }

    public int getPageCount() {
        return (int) Math.ceil((double) productDAO.getAll().size() / productsPerPage);
    }

    public List<Product> getProductPage(int pageNumber) {
        int fromIndex = pageNumber * productsPerPage;
        int toIndex = Math.min(fromIndex + productsPerPage, productDAO.getAll().size());
        return productDAO.getAll().subList(fromIndex, toIndex);
    }

    
}
