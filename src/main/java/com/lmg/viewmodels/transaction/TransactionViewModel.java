package com.lmg.viewmodels.transaction;

import java.util.HashSet;
import java.util.Set;

import com.lmg.lib.events.EventBase;
import com.lmg.models.daos.DAO;
import com.lmg.models.daos.ProductDAO;
import com.lmg.models.pojos.Product;
import com.lmg.models.pojos.Transaction;
import com.lmg.models.pojos.TransactionProduct;
import com.lmg.views.transaction.ITransactionProductRow;
import com.lmg.views.transaction.ITransactionViewModel;

import jakarta.persistence.EntityNotFoundException;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransactionViewModel extends EventBase implements ITransactionViewModel {

    private DAO<Transaction> transactionDAO;
    private ProductDAO productDAO;
    private ObservableList<ITransactionProductRow> transactionProducts;
    private ReadOnlyFloatWrapper readOnlyTotal;
    private SimpleFloatProperty total;
    private SimpleStringProperty barcode;

    public TransactionViewModel(DAO<Transaction> transactionDAO, ProductDAO productDAO) {
        this.transactionDAO = transactionDAO;
        this.productDAO = productDAO;
        transactionProducts = FXCollections.observableArrayList();
        barcode = new SimpleStringProperty(this, "barcode", "");
        total = new SimpleFloatProperty(this, "total", 0.0f);
        readOnlyTotal = new ReadOnlyFloatWrapper(this, "total", 0.0f);
        readOnlyTotal.bind(total);
    }

    @Override
    public ObservableList<ITransactionProductRow> transactionProductsObservableList() {
        return transactionProducts;
    }

    @Override
    public ReadOnlyFloatProperty readOnlyTotalProperty() {
        return readOnlyTotal.getReadOnlyProperty();
    }

    @Override
    public StringProperty barcodeProperty() {
        return barcode;
    }

    @Override
    public void addProduct() {
        
        for (Product product : productDAO.getAll()) {
            System.out.println(product);
        }

        //TODO: Implement barcode search
        Product product = productDAO.getByBarcode(barcodeProperty().get()).orElse(null);
        
        if (product == null) {
            throw new EntityNotFoundException("Product not found");
        }

        if (transactionProducts.stream().anyMatch(tp -> tp.readOnlyProductProperty().get().equals(product))) {
            TransactionProductRow transactionProduct = (TransactionProductRow) transactionProducts.stream()
                    .filter(tp -> tp.readOnlyProductProperty().get().equals(product)).findFirst().get();
            transactionProduct.setQuantity(transactionProduct.quantityProperty().get() + 1);

            total.set(total.get() + product.getPricePerPiece());
        } else {
            transactionProducts.add(new TransactionProductRow(product));
            total.set(total.get() + product.getPricePerPiece());
        }
        barcodeProperty().set("");
    }

    @Override
    public void removeProduct(ITransactionProductRow item) {
        transactionProducts.remove(item);
    }

    @Override
    public void done() {
        Transaction newTransaction = new Transaction();
        Set<TransactionProduct> items = new HashSet<>();
        for (ITransactionProductRow transactionProduct : transactionProducts) {
            items.add(new TransactionProduct(newTransaction, transactionProduct.readOnlyProductProperty().get(),
                    transactionProduct.quantityProperty().get()));
        }
        newTransaction.setId((long) transactionDAO.getAll().size() + 1);
        newTransaction.setTransactionProducts(items);
        transactionDAO.save(newTransaction);
        fireEvent(newTransaction);
        clearInputs();
        
    }

    private void clearInputs() {
        barcode.set("");
        transactionProducts.clear();
        total.set(0.0f);
    }
    
}
