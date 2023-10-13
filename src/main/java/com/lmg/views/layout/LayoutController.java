package com.lmg.views.layout;

import com.lmg.views.ViewHandler;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class LayoutController implements ILayoutController {
    
    @FXML
    private AnchorPane rootContainer;

    @FXML
    private Node Sidebar;

    @FXML
    private AnchorPane viewContainer;

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }
    
    @Override
    public void setView(Node view) {
        viewContainer.getChildren().clear();
        viewContainer.getChildren().add(view);
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);
        AnchorPane.setRightAnchor(view, 0.0);

        Platform.runLater(() -> {
            Button dashboardButton = (Button) rootContainer.lookup("#dashboardButton");
            dashboardButton.setOnAction(e -> {
                viewHandler.switchToView("dashboard");
            });

            Button inventoryButton = (Button) rootContainer.lookup("#inventoryButton");
            inventoryButton.setOnAction(e -> {
                viewHandler.switchToView("inventory");
            });

            Button transactionsButton = (Button) rootContainer.lookup("#transactionsButton");
            transactionsButton.setOnAction(e -> {
                viewHandler.switchToView("transactions");
            });
            
            
        });

    }
    
}
