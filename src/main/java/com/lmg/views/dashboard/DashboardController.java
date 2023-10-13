package com.lmg.views.dashboard;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.lmg.views.Controller;
import com.lmg.views.ViewHandler;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DashboardController {
    @FXML
    private Label currentDateLabel;

    @FXML
    private Label customersLabel;

    @FXML
    private Button newTransactionButton;

    @FXML
    private TableColumn<ITransactionItem, Float> salesColumn;

    @FXML
    private TableColumn<ITransactionItem, LocalTime> timeColumn;

    @FXML
    private Label totalSalesLabel;

    @FXML
    private TableView<ITransactionItem> transactionsTable;

    private ViewHandler viewHandler;
    private IDashboardViewModel dashboardViewModel;


    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
    
    public void init(ViewHandler viewHandler, IDashboardViewModel dashboardViewModel) {
        this.viewHandler = viewHandler;
        this.dashboardViewModel = dashboardViewModel;
        setupTable();

        customersLabel.textProperty().bind(dashboardViewModel.readOnlyCustomersCountTodayProperty().asString());
        totalSalesLabel.textProperty().bind(dashboardViewModel.readOnlyTotalSalesTodayProperty().asString());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        currentDateLabel.textProperty().bind(Bindings.createStringBinding(() -> {
            return formatter.format(dashboardViewModel.readOnlyDateTodayProperty().get());
        }, dashboardViewModel.readOnlyDateTodayProperty()));
    }


    private void setupTable() {
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyTimeProperty());
        timeColumn.setCellFactory(tableColumn -> {
            return new TableCell<>(){
                @Override
                public void updateItem(LocalTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        
                        setText(timeFormatter.format(item));
                    }
                }
            };
        });
        salesColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlySalesProperty().asObject());
        transactionsTable.setItems(dashboardViewModel.transactionItemsObservableList());
    }

    @FXML
    void newTransactionButtonClicked(ActionEvent event) {
        try {
            viewHandler.showTransactionModal();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.out.println("Error opening transaction modal");
        }
    }
}
