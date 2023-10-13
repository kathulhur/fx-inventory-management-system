package com.lmg.models.daos;

import java.util.List;
import java.util.Optional;

import com.lmg.models.pojos.TransactionProduct;

public class TransactionProductDAO implements DAO<TransactionProduct> {
    
    private List<TransactionProduct> transactionProducts;

    public TransactionProductDAO() {
        


    }

    @Override
    public Optional<TransactionProduct> get(long id) {
        return Optional.ofNullable(transactionProducts.get((int) id));
    }

    @Override
    public List<TransactionProduct> getAll() {
        return transactionProducts;
    }

    @Override
    public void save(TransactionProduct t) {
        transactionProducts.add(t);
    }

    @Override
    public void update(TransactionProduct t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(TransactionProduct t) {
        transactionProducts.remove(t);
    }
    

}
