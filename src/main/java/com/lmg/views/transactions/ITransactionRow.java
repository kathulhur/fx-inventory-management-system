package com.lmg.views.transactions;

import java.time.LocalDateTime;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyObjectProperty;

public interface ITransactionRow {
    public ReadOnlyLongProperty readOnlyIDProperty();

    public ReadOnlyObjectProperty<LocalDateTime> readonlyDatetimeProperty();

    public ReadOnlyFloatProperty readOnlyTotalSalesProperty();
}