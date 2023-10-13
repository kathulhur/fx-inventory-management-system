package com.lmg.views.inventory;

import java.io.IOException;

import com.lmg.viewmodels.inventory.IInventoryViewModel;
import com.lmg.views.Controller;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;
import com.lmg.views.layout.Layout;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class InventoryView implements View {

    private IInventoryViewModel viewModel;
    private ViewHandler viewHandler;

    public InventoryView(ViewHandler viewHandler, IInventoryViewModel inventoryViewModel) {
        this.viewModel = inventoryViewModel;
        this.viewHandler = viewHandler;
    }
    
    @Override
    public Parent load() throws IOException {
        try {
    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InventoryView.fxml"));
            Parent root = loader.load();
            InventoryController controller = loader.getController();
            controller.init(viewHandler, viewModel);

            return Layout.wrap(root, viewHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    
}
