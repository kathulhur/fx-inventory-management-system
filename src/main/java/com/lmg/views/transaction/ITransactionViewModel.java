package com.lmg.views.transaction;


import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public interface ITransactionViewModel {

    public ObservableList<ITransactionProductRow> transactionProductsObservableList();

    public ReadOnlyFloatProperty readOnlyTotalProperty();
    
    public StringProperty barcodeProperty();

    public void addProduct();

    public void removeProduct(ITransactionProductRow item);

    public void done();

}
