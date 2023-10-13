package com.lmg.viewmodels;

import com.lmg.models.daos.DAO;
import com.lmg.models.pojos.Product;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CheckPriceModalViewModel {

    private StringProperty barcode;
    private StringProperty name;
    private FloatProperty pricePerPiece;
    
    private DAO<Product> productDAO;

    public CheckPriceModalViewModel(DAO<Product> productDAO) {
        this.productDAO = productDAO;
        this.barcode = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.pricePerPiece = new SimpleFloatProperty();

    }

    public void checkPrice(String barcode) {
        Product product = productDAO.getAll().stream().filter(p -> p.getBarcode().equals(barcode)).findFirst().orElse(null);
        if (product != null) {
            this.name.set(product.getName());
            this.pricePerPiece.set(product.getPricePerPiece());
            barcodeProperty().set("");
        } else {
            this.name.set("Product not found");
            this.pricePerPiece.set(0);
            barcodeProperty().set("");
        }
    }

    public StringProperty barcodeProperty() {
        return barcode;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public FloatProperty pricePerPieceProperty() {
        return pricePerPiece;
    }

    public void clear() {
        barcode.set("");
        name.set("");
        pricePerPiece.set(0);
    }


    
    
}
