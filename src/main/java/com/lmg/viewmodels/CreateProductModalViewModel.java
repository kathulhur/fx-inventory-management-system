package com.lmg.viewmodels;

import com.lmg.models.daos.DAO;
import com.lmg.models.pojos.Product;
import com.lmg.views.createProduct.ICreateProductViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateProductModalViewModel implements ICreateProductViewModel {

    private StringProperty barcode;
    private StringProperty name;
    private StringProperty pricePerPiece;
    
    private DAO<Product> productDAO;

    public CreateProductModalViewModel(DAO<Product> productDAO) {
        this.productDAO = productDAO;
        this.barcode = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.pricePerPiece = new SimpleStringProperty();
    }

    public void createProduct() {
        try {
            Float price = Float.parseFloat(pricePerPiece.get());
            productDAO.save(new Product((long)productDAO.getAll().size(), barcode.get(), name.get(), price));
        } catch (Exception e) {
            System.out.println("Error creating product");
        }
    }

    public StringProperty barcodeProperty() {
        return barcode;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty pricePerPieceProperty() {
        return pricePerPiece;
    }

    public void clearInputs() {
        barcode.set("");
        name.set("");
        pricePerPiece.set("");
    }


    
    
}
