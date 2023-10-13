package com.lmg.viewmodels.transactionDetail;

import com.lmg.models.daos.TransactionDAO;
import com.lmg.models.pojos.Transaction;
import com.lmg.models.pojos.TransactionProduct;
import com.lmg.views.modals.TransactionDetail.ITransactionDetailViewModel;
import com.lmg.views.modals.TransactionDetail.ITransactionProductItem;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransactionDetailViewModel implements ITransactionDetailViewModel {

    private TransactionDAO transactionDAO;
    private ReadOnlyStringWrapper id;
    private ReadOnlyStringWrapper total;
    private ObservableList<ITransactionProductItem> transactionProductItems;
    private Transaction transaction;
    
    public TransactionDetailViewModel(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
        this.id = new ReadOnlyStringWrapper(this, "id");
        this.total = new ReadOnlyStringWrapper(this, "total");
        this.transactionProductItems = FXCollections.observableArrayList();
    }


    public void update(Long id) {
        this.transaction = transactionDAO.get(id).orElse(null);
        this.id.set(this.transaction.getId().toString());
        this.total.set(this.transaction.getTotalSales().toString());
        this.transactionProductItems.clear();
        for (TransactionProduct tp : this.transaction.getTransactionProducts()) {
            this.transactionProductItems.add(new TransactionProductItem(tp));
        }
    }

    @Override
    public ReadOnlyStringProperty idProperty() {
        return id.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyStringProperty totalProperty() {
        return total.getReadOnlyProperty();
    }

    @Override
    public ObservableList<ITransactionProductItem> transactionProductItems() {
        return transactionProductItems;
    }
    
}
