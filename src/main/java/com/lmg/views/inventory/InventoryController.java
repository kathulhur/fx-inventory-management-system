package com.lmg.views.inventory;


import com.lmg.models.pojos.Product;
import com.lmg.viewmodels.inventory.IInventoryViewModel;
import com.lmg.viewmodels.inventory.InventoryViewModel;
import com.lmg.views.Controller;
import com.lmg.views.ViewHandler;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryController {

    @FXML
    private Button newProductButton;


    @FXML
    private Pagination pagination;

    private TableView<Product> table;
    
    private IInventoryViewModel viewModel;

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, IInventoryViewModel inventoryViewModel) {
        this.viewModel = inventoryViewModel;
        this.viewHandler = viewHandler;

        table = new TableView<>();
        table.getColumns().add(createBarcodeColumn());
        table.getColumns().add(createNameColumn());
        table.getColumns().add(createPricePerPieceColumn());

        pagination.setPageCount(inventoryViewModel.getPageCount());
        pagination.setPageFactory(this::createPage);


    }

    private TableView<Product> createPage(int pageNumber) {
        table.setItems(FXCollections.observableArrayList(viewModel.getProductPage(pageNumber)));
        return table;
    }
    

    @FXML
    private void newProductButtonClicked(ActionEvent event) {
        try {
            
            viewHandler.showCreateProductModal();

        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.out.println("Error opening create product modal");
        }
    }

    private TableColumn<Product, ?> createPricePerPieceColumn() {
        TableColumn<Product, Float> pricePerPieceColumn = new TableColumn<>("Price per piece");
        pricePerPieceColumn.setMinWidth(200);
        pricePerPieceColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerPiece"));
        return pricePerPieceColumn;
    }

    private TableColumn<Product, ?> createNameColumn() {
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(400);
        nameColumn.setCellValueFactory(cellData -> {
            StringProperty name = new SimpleStringProperty(cellData.getValue().getName());
            return name;
        });
        return nameColumn;
    }

    private TableColumn<Product, ?> createBarcodeColumn() {
        TableColumn<Product, String> barcodeColumn = new TableColumn<>("Barcode");
        barcodeColumn.setMinWidth(200);
        barcodeColumn.setCellValueFactory(cellData -> {
            StringProperty barcode = new SimpleStringProperty(cellData.getValue().getBarcode());
            return barcode;
        });
        return barcodeColumn;
    }

}