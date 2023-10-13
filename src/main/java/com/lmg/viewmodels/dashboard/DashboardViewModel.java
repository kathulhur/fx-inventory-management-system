package com.lmg.viewmodels.dashboard;

import java.time.LocalDate;
import java.util.List;

import com.lmg.models.daos.TransactionDAO;
import com.lmg.models.pojos.Transaction;
import com.lmg.views.dashboard.IDashboardViewModel;
import com.lmg.views.dashboard.ITransactionItem;

import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DashboardViewModel implements IDashboardViewModel {

    private TransactionDAO transactionDAO;
    private List<Transaction> transactions;
    private SimpleIntegerProperty customersCountToday;
    private SimpleFloatProperty totalSalesToday;
    private ObservableList<ITransactionItem> transactionItemsObservableList;
    private ReadOnlyObjectWrapper<LocalDate> dateToday;
    
    public DashboardViewModel(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
        transactions = transactionDAO.getAll();

        transactionItemsObservableList = FXCollections.observableArrayList();
        for (Transaction transaction : transactions) {
            transactionItemsObservableList.add(new TransactionItem(transaction));
        }

        customersCountToday = new SimpleIntegerProperty(this, "customersTodayCount", 0);
        totalSalesToday = new SimpleFloatProperty(this, "customersTodayTotalSales", 0.0f);
        dateToday = new ReadOnlyObjectWrapper<>(this, "dateToday", LocalDate.now());
        
    }

    @Override
    public ReadOnlyIntegerProperty readOnlyCustomersCountTodayProperty() {
        customersCountToday.set(transactionItemsObservableList.size());
        return customersCountToday;
    }

    @Override
    public ReadOnlyFloatProperty readOnlyTotalSalesTodayProperty() {
        float totalSales = 0f;

        for (Transaction t : transactions) {
            totalSales += t.getTotalSales();
        }
        totalSalesToday.set(totalSales);
        return totalSalesToday;
    }

    @Override
    public ObservableList<ITransactionItem> transactionItemsObservableList() {
        transactions = transactionDAO.getAll();
        transactionItemsObservableList.clear();
        for (Transaction transaction : transactions) {
            transactionItemsObservableList.add(new TransactionItem(transaction));
        }
        return this.transactionItemsObservableList;
    }

    @Override
    public ReadOnlyObjectProperty<LocalDate> readOnlyDateTodayProperty() {
        return this.dateToday.getReadOnlyProperty();
    }
    
}
