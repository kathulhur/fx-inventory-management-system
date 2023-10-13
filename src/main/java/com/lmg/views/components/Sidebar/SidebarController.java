package com.lmg.views.components.Sidebar;

import com.lmg.views.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SidebarController {
    @FXML
    private Button dashboardButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button transactionsButton;

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;

        dashboardButton.setOnAction(event -> {
            viewHandler.switchToView("dashboard");
        });

        inventoryButton.setOnAction(event -> {
            viewHandler.switchToView("inventory");
        });

        transactionsButton.setOnAction(event -> {
            viewHandler.switchToView("transactions");
        });

    }
}
