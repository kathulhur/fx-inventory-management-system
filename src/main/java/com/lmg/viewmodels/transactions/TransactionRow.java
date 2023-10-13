package com.lmg.viewmodels.transactions;

import java.time.LocalDateTime;

import com.lmg.models.pojos.Transaction;
import com.lmg.views.transactions.ITransactionRow;

import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public class TransactionRow implements ITransactionRow {

    private ReadOnlyLongProperty readOnlyID;
    private ReadOnlyObjectProperty<LocalDateTime> readonlyDatetime;
    private ReadOnlyFloatProperty readOnlyTotalSalesProperty;

    public TransactionRow(Transaction transaction) {
        readOnlyID = new ReadOnlyLongWrapper(this, "id", transaction.getId());
        readonlyDatetime = new ReadOnlyObjectWrapper<>(this, "datetime", transaction.getDate());
        readOnlyTotalSalesProperty = new ReadOnlyFloatWrapper(this, "totalSales", transaction.getTotalSales());
    }
    
    public ReadOnlyLongProperty readOnlyIDProperty() {
        return readOnlyID;
    }

    @Override
    public ReadOnlyObjectProperty<LocalDateTime> readonlyDatetimeProperty() {
        return readonlyDatetime;
    }

    @Override
    public ReadOnlyFloatProperty readOnlyTotalSalesProperty() {
        return readOnlyTotalSalesProperty;
    }
    
}
