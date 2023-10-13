package com.lmg.views.transactions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

import com.lmg.views.Controller;
import com.lmg.views.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransactionsController {
    @FXML
    private TableColumn<ITransactionRow, LocalDateTime> dateColumn;

    @FXML
    private TableColumn<ITransactionRow, LocalDateTime> timeColumn;

    @FXML
    private TableColumn<ITransactionRow, Number> idColumn;

    @FXML
    private Button newTransactionButton;

    @FXML
    private TableColumn<ITransactionRow, Void> recordDetailsColumn;

    @FXML
    private TableColumn<ITransactionRow, Number> totalSalesColumn;

    @FXML
    private TableView<ITransactionRow> transactionsTable;

    private ViewHandler viewHandler;
    private ITransactionsViewModel viewModel;
    
    GlyphFont fontAwesome = GlyphFontRegistry.font("FontAwesome");

    public void init(ViewHandler viewHandler, ITransactionsViewModel viewModel) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;

        // TODO: enclose inside runLater
        newTransactionButton.setOnAction(event -> {
            try {
                viewHandler.showTransactionModal();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        });
        System.out.println("TransactionsController init");
        setupTable();

    }
    
    private void setupTable() {
        recordDetailsColumn.setCellFactory(tableColumn -> {
            return new TableCell<>(){
                private final Button button = new Button();
                {
                    button.setGraphic(fontAwesome.create(FontAwesome.Glyph.EXTERNAL_LINK_SQUARE));
                    button.setOnAction(event -> {
                        ITransactionRow row = getTableView().getItems().get(getIndex());
                        try {
                            viewHandler.showTransactionDetailModal();



                        } catch (IOException e) {
                            System.out.println("Error opening transaction detail modal");
                            e.printStackTrace();
                        }
                        
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                    }
                }
            };
        });
        idColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyIDProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().readonlyDatetimeProperty());
        dateColumn.setCellFactory(tableColumn -> {
            return new TableCell<>(){

                @Override
                protected void updateItem(LocalDateTime item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE - MMMM dd, yyyy");
                        String formattedDatetime = item.format(formatter);
                        setText(formattedDatetime);
                    }

                }
            };
        });

        timeColumn.setCellValueFactory(cellData -> cellData.getValue().readonlyDatetimeProperty());
        timeColumn.setCellFactory(tableColumn -> {
            return new TableCell<>(){

                @Override
                protected void updateItem(LocalDateTime item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
                        String formattedDatetime = item.format(formatter);
                        setText(formattedDatetime);
                    }

                }
            };
        });




        totalSalesColumn.setCellValueFactory(cellData -> cellData.getValue().readOnlyTotalSalesProperty());
        transactionsTable.setItems(viewModel.transactionsObservableList());
    }
}
