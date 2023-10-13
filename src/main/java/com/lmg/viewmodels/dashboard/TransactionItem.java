package com.lmg.viewmodels.dashboard;

import java.time.LocalTime;

import com.lmg.models.pojos.Transaction;
import com.lmg.views.dashboard.ITransactionItem;

import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public class TransactionItem implements ITransactionItem {


    private Transaction transaction;
    private ReadOnlyObjectWrapper<LocalTime> time;
    private ReadOnlyFloatWrapper sales;

    public TransactionItem(Transaction transaction) {
        this.transaction = transaction;
        this.time = new ReadOnlyObjectWrapper<LocalTime>(this, "time", transaction.getDate().toLocalTime());
        this.sales = new ReadOnlyFloatWrapper(this, "sales", transaction.getTotalSales());
    }

    @Override
    public ReadOnlyObjectProperty<LocalTime> readOnlyTimeProperty() {
        return this.time.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyFloatProperty readOnlySalesProperty() {
        return this.sales.getReadOnlyProperty();
    }
    
}
