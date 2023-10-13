package com.lmg.viewmodels.inventory;

import java.util.List;

import com.lmg.models.pojos.Product;

public interface IInventoryViewModel {
    public int getPageCount();

    public List<Product> getProductPage(int pageNumber);
}
