package com.lmg.viewmodels.transactionDetail;
import com.lmg.models.pojos.TransactionProduct;
import com.lmg.views.modals.TransactionDetail.ITransactionProductItem;

import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class TransactionProductItem implements ITransactionProductItem {

    private TransactionProduct transactionProduct;
    private ReadOnlyStringWrapper productName;
    private ReadOnlyIntegerWrapper quantity;
    private ReadOnlyFloatWrapper price;
    private ReadOnlyFloatWrapper subtotal;


    public TransactionProductItem(TransactionProduct transactionProduct) {
        this.transactionProduct = transactionProduct;
        this.productName = new ReadOnlyStringWrapper(transactionProduct.getProduct().getName());
        this.quantity = new ReadOnlyIntegerWrapper(transactionProduct.getQuantity());
        this.price = new ReadOnlyFloatWrapper(transactionProduct.getPriceSold());
        this.subtotal = new ReadOnlyFloatWrapper(transactionProduct.getQuantity() * transactionProduct.getProduct().getPricePerPiece());

    }


    @Override
    public ReadOnlyStringProperty readOnlyProductName() {
        return productName.getReadOnlyProperty();
    }


    @Override
    public ReadOnlyIntegerProperty readOnlyQuantityProperty() {
        return quantity.getReadOnlyProperty();
    }


    @Override
    public ReadOnlyFloatProperty readOnlyPriceProperty() {
        return price.getReadOnlyProperty();
    }


    @Override
    public ReadOnlyFloatProperty readOnlySubtotalProperty() {
        return subtotal.getReadOnlyProperty();
    }

    
}
