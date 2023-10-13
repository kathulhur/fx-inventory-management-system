package com.lmg.views.transaction;

import java.io.IOException;

import com.lmg.viewmodels.transaction.TransactionViewModel;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TransactionView implements View {

    private ViewHandler viewHandler;
    private TransactionViewModel viewModel;
    
    public TransactionView(ViewHandler viewHandler, TransactionViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
    }

    @Override
    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaction.fxml"));
        Parent root = loader.load();
        TransactionController controller = loader.getController();
        controller.init(viewHandler, viewModel);

        return root;
    }

    
}
