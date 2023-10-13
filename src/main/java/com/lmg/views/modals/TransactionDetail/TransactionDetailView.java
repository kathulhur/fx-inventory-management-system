package com.lmg.views.modals.TransactionDetail;

import java.io.IOException;

import com.lmg.views.View;
import com.lmg.views.ViewHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TransactionDetailView implements View {

    private ViewHandler viewHandler;

    private ITransactionDetailViewModel viewModel;

    private TransactionDetailController controller;

    private Parent rootNode;

    public TransactionDetailView(ViewHandler viewHandler, ITransactionDetailViewModel viewModel) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
    }


    @Override
    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransactionDetail.fxml"));
        rootNode = loader.load();
        controller = loader.getController();
        controller.init(viewHandler, viewModel);
        return rootNode;
    }

}
