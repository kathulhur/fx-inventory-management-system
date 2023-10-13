package com.lmg.models.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lmg.models.pojos.Transaction;

public class TransactionDAO implements DAO<Transaction>{
    
 
    private List<Transaction> transactions;

    public TransactionDAO() {
        transactions = new ArrayList<>();
        
    }

    @Override
    public Optional<Transaction> get(long id) {
        return transactions.stream().filter(t -> t.getId() == id).findFirst();
    }

    @Override
    public List<Transaction> getAll() {
        return transactions;
    }

    @Override
    public void save(Transaction t) {
        transactions.add(t);
    }

    @Override
    public void update(Transaction t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Transaction t) {
        transactions.remove(t);
    }
    
    
}
