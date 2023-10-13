package com.lmg.views.modals.TransactionDetail;

import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyStringProperty;

public interface ITransactionProductItem {
    
    public ReadOnlyStringProperty readOnlyProductName();

    public ReadOnlyIntegerProperty readOnlyQuantityProperty();

    public ReadOnlyFloatProperty readOnlyPriceProperty();

    public ReadOnlyFloatProperty readOnlySubtotalProperty();


}