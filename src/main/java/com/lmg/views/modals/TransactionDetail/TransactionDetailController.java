package com.lmg.views.modals.TransactionDetail;


import com.lmg.views.ViewHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransactionDetailController {
    
    @FXML
    private Button closeButton;

    @FXML
    private Label idLabel;

    @FXML
    private TableColumn<ITransactionProductItem, Number> priceColumn;

    @FXML
    private TableColumn<ITransactionProductItem, String> productNameColumn;

    @FXML
    private TableColumn<ITransactionProductItem, Number> quantityColumn;

    @FXML
    private TableColumn<ITransactionProductItem, Number> subtotalColumn;

    @FXML
    private TableView<ITransactionProductItem> table;

    @FXML
    private Label totalLabel;

    @FXML
    private Parent rootContainer;

    private ViewHandler viewHandler;
    
    private ITransactionDetailViewModel viewModel;


    public void init(ViewHandler viewHandler, ITransactionDetailViewModel viewModel) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        viewModel.update(1L);

        setupTable();

        idLabel.textProperty().bind(viewModel.idProperty());
        totalLabel.textProperty().bind(viewModel.totalProperty());
        
    }

    public void setupTable() {
        productNameColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyProductName());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyQuantityProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyPriceProperty());
        subtotalColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlySubtotalProperty());

        table.setItems(viewModel.transactionProductItems());
    }
    
    @FXML
    void onCloseButtonClicked(ActionEvent event) {
        viewHandler.closeModal();
    }
}
