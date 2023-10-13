package com.lmg.views.dashboard;

import java.time.LocalTime;

import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyObjectProperty;

public interface ITransactionItem {

    public ReadOnlyObjectProperty<LocalTime> readOnlyTimeProperty();

    public ReadOnlyFloatProperty readOnlySalesProperty();

    
}
