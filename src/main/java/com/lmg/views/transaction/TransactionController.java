package com.lmg.views.transaction;

import com.lmg.models.pojos.Product;
import com.lmg.views.ViewHandler;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TransactionController {

    @FXML
    private Parent rootContainer;

    @FXML
    private Button doneButton;

    @FXML
    private TextField barcodeField;


    @FXML
    private TableColumn<ITransactionProductRow, Product> priceColumn;

    @FXML
    private TableColumn<ITransactionProductRow, Product> productColumn;

    @FXML
    private TableColumn<ITransactionProductRow, Number> quantityColumn;

    @FXML
    private TableColumn<ITransactionProductRow, Number> subtotalColumn;

    @FXML
    private TableView<ITransactionProductRow> table;

    @FXML
    private Label totalLabel;

    private ViewHandler viewHandler;
    private ITransactionViewModel viewModel;


    public void init(ViewHandler viewHandler, ITransactionViewModel viewModel) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;

        setupTable(viewModel.transactionProductsObservableList());

        totalLabel.textProperty().bind(viewModel.readOnlyTotalProperty().asString());
        barcodeField.textProperty().bindBidirectional(viewModel.barcodeProperty());


        Platform.runLater(() -> {
            barcodeField.requestFocus();
            rootContainer.getScene().setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case ENTER:
                        viewModel.addProduct();
                        break;
                    // case DELETE:
                    //     viewModel.removeProduct();
                    //     break;
                    default:
                        break;
                }
            });
        });

        
    }
    
    public void setupTable(ObservableList<ITransactionProductRow> transactionProducts) {
        productColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyProductProperty());
        productColumn.setCellFactory(tableColumn -> {
            return new TableCell<>(){
                @Override
                protected void updateItem(Product product, boolean empty) {
                    super.updateItem(product, empty);
                    if (product == null || empty) {
                        setText(null);
                    } else {
                        setText(product.getName());
                    }
                }
            };
        });
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyProductProperty());
        priceColumn.setCellFactory(tableColumn -> {
            return new TableCell<>(){
                @Override
                protected void updateItem(Product product, boolean empty) {
                    super.updateItem(product, empty);
                    if (product == null || empty) {
                        setText(null);
                    } else {
                        setText(String.valueOf(product.getPricePerPiece()));
                    }
                }
            };
        });

        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
        subtotalColumn.setCellValueFactory(cellData -> cellData.getValue().subtotalProperty());

        table.setItems(transactionProducts);
    }

    @FXML
    void onDoneButtonClicked(ActionEvent event) {
        viewModel.done();
        viewHandler.closeModal();
    }

    @FXML
    void onCancelButtonClicked(ActionEvent event) {
        viewHandler.closeModal();
    }

}
