package com.lmg.views.dashboard;

import java.time.LocalDate;

import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;

public interface IDashboardViewModel {


    public ReadOnlyIntegerProperty readOnlyCustomersCountTodayProperty();

    public ReadOnlyFloatProperty readOnlyTotalSalesTodayProperty();

    public ReadOnlyObjectProperty<LocalDate> readOnlyDateTodayProperty();

    public ObservableList<ITransactionItem> transactionItemsObservableList();



}
