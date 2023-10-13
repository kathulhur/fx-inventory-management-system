package com.lmg.models.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lmg.models.pojos.Product;

public class ProductDAO implements DAO<Product> {

    private List<Product> products = new ArrayList<>();

    public ProductDAO() {
        products.add(new Product("1234567890123", "Product 1", 1.0f));
        products.add(new Product("1234567890124", "Product 2", 2.0f));
        products.add(new Product("1234567890125", "Product 3", 3.0f));
    }

    @Override
    public Optional<Product> get(long id) {
        return Optional.ofNullable(products.get((int) id));
    }

    public Optional<Product> getByBarcode(String barcode) {
        return products.stream().filter(p -> p.getBarcode().equals(barcode)).findFirst();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product t) {
        products.add(t);
    }

    @Override
    public void update(Product t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Product t) {
        products.remove(t);
    }

    
}
