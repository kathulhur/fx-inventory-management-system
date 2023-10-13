package com.lmg.views.transaction;

import com.lmg.models.pojos.Product;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyObjectProperty;

public interface ITransactionProductRow {
    
    public ReadOnlyObjectProperty<Product> readOnlyProductProperty();

    public IntegerProperty quantityProperty();

    public ReadOnlyFloatProperty subtotalProperty();

    

}
