package com.lmg.views.transactions;

import java.io.IOException;

import com.lmg.views.Controller;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;
import com.lmg.views.layout.Layout;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TransactionsView implements View {
    
    private ViewHandler viewHandler;
    private ITransactionsViewModel transactionsViewModel;

    public TransactionsView(ViewHandler viewHandler, ITransactionsViewModel transactionsViewModel) {
        this.viewHandler = viewHandler;
        this.transactionsViewModel = transactionsViewModel;

    }

    @Override
    public Parent load() throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Transactions.fxml"));
            Parent root = loader.load();
            TransactionsController transactionsController = loader.getController();
            transactionsController.init(viewHandler, transactionsViewModel);
            
            return Layout.wrap(root, viewHandler);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
        
    }


    
}
