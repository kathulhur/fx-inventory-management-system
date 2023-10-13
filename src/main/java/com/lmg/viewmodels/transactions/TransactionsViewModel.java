package com.lmg.viewmodels.transactions;

import com.lmg.lib.events.EventListener;
import com.lmg.models.daos.TransactionDAO;
import com.lmg.models.pojos.Transaction;
import com.lmg.views.transactions.ITransactionRow;
import com.lmg.views.transactions.ITransactionsViewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransactionsViewModel implements ITransactionsViewModel, EventListener {

    private TransactionDAO transactionDAO;
    private ObservableList<ITransactionRow> _transactionsObservableList;
    public TransactionsViewModel(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
        _transactionsObservableList = FXCollections.observableArrayList();
        
    }

    @Override
    public ObservableList<ITransactionRow> transactionsObservableList() {
        _transactionsObservableList.clear();
        transactionDAO.getAll().forEach(transaction -> {
            _transactionsObservableList.add(new TransactionRow(transaction));
        });

        return _transactionsObservableList;
    }

    @Override
    public void update(Object obj) {
        if (obj instanceof Transaction) {
            _transactionsObservableList.add(new TransactionRow((Transaction) obj));
        }
    }
    
}
