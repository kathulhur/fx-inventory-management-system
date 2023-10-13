package com.lmg.viewmodels.transaction;

import com.lmg.models.pojos.Product;
import com.lmg.views.transaction.ITransactionProductRow;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TransactionProductRow implements ITransactionProductRow {
    private Product product;
    private ReadOnlyObjectProperty<Product> readOnlyProduct;
    private IntegerProperty quantity;
    private ReadOnlyFloatWrapper readOnlySubtotal;
    private FloatProperty subtotal;
    
    
    public TransactionProductRow(Product product) {
        this.product = product;

        this.readOnlyProduct = new ReadOnlyObjectWrapper<Product>(product);
        this.quantity = new SimpleIntegerProperty(this, "quantity", 1);
        this.subtotal = new SimpleFloatProperty(this, "subtotal", product.getPricePerPiece());
        this.readOnlySubtotal = new ReadOnlyFloatWrapper(this, "readOnlySubtotal", product.getPricePerPiece());
        this.readOnlySubtotal.bind(subtotal);
    }


    public ReadOnlyObjectProperty<Product> readOnlyProductProperty() {
        return readOnlyProduct;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
        subtotal.set(product.getPricePerPiece() * quantity);
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }


    public ReadOnlyFloatProperty subtotalProperty() {
        return readOnlySubtotal.getReadOnlyProperty();
    }
}
