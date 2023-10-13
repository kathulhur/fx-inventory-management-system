package com.lmg.views.createProduct;
import com.lmg.views.Controller;
import com.lmg.views.ViewHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateProductController {

    @FXML
    private TextField barcodeField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField pricePerPieceField;

    private ICreateProductViewModel viewModel;

    private ViewHandler viewHandler;

    public CreateProductController() {

    }

    public void init(ViewHandler viewHandler, ICreateProductViewModel viewModel) {

        this.viewHandler = viewHandler;
        this.viewModel = viewModel;

        barcodeField.textProperty().bindBidirectional(viewModel.barcodeProperty());
        nameField.textProperty().bindBidirectional(viewModel.nameProperty());
        pricePerPieceField.textProperty().bindBidirectional(viewModel.pricePerPieceProperty());

        cancelButton.setOnAction(event -> {
            viewHandler.closeModal();
        });
        createButton.setOnAction(event -> {
            viewModel.createProduct();
            viewModel.clearInputs();
            viewHandler.closeModal();
        });
    }





}
