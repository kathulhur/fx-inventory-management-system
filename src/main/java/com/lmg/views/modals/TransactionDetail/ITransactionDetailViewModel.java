package com.lmg.views.modals.TransactionDetail;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.collections.ObservableList;

public interface ITransactionDetailViewModel {
    
    public void update(Long id);

    public ReadOnlyStringProperty idProperty();

    public ReadOnlyStringProperty totalProperty();

    public ObservableList<ITransactionProductItem> transactionProductItems();
}
