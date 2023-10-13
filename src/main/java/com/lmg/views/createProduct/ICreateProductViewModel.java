package com.lmg.views.createProduct;

import javafx.beans.property.StringProperty;

public interface ICreateProductViewModel {
    public StringProperty barcodeProperty();

    public StringProperty nameProperty();

    public StringProperty pricePerPieceProperty();

    public void createProduct();

    public void clearInputs();
    

}
