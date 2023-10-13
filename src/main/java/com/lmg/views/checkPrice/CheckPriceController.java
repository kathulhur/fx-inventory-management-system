package com.lmg.views.checkPrice;
import com.lmg.viewmodels.CheckPriceModalViewModel;
import com.lmg.views.ViewHandler;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class CheckPriceController {

    @FXML
    private Pane rootContainer;

    @FXML
    private TextField barcodeField;

    @FXML
    private Button doneButton;

    @FXML
    private Label pricePerPieceLabel;

    @FXML
    private Label productLabel;

    private ViewHandler viewHandler;

    private CheckPriceModalViewModel viewModel;

    public CheckPriceController() {
    }


    public void init(ViewHandler viewHandler, CheckPriceModalViewModel checkPriceModalViewModel) {
        System.out.println("CheckPriceController init");
        this.viewModel = checkPriceModalViewModel;
        checkPriceModalViewModel.barcodeProperty().bindBidirectional(barcodeField.textProperty());
        productLabel.textProperty().bind(checkPriceModalViewModel.nameProperty());
        pricePerPieceLabel.textProperty().bind(checkPriceModalViewModel.pricePerPieceProperty().asString());
        
        this.viewHandler = viewHandler;
        doneButton.setOnAction(event -> {
            viewModel.clear();
            viewHandler.closeModal();
        });
        
        Platform.runLater(() -> {
            barcodeField.requestFocus();
            rootContainer.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case ENTER:
                    viewModel.checkPrice(barcodeField.getText());
                    break;
                    case ESCAPE:
                    viewHandler.closeModal();
                    break;
                    default:
                    break;
                }
            });
            
        });
        System.out.println("CheckPriceController init end");
    }
    
    public void handleSearch() {
        viewModel.checkPrice(barcodeField.getText());
    }
    

}
