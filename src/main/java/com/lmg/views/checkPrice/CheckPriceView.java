package com.lmg.views.checkPrice;

import java.io.IOException;

import com.lmg.viewmodels.CheckPriceModalViewModel;
import com.lmg.views.Controller;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CheckPriceView implements View{
    
    private CheckPriceModalViewModel viewModel;
    private ViewHandler viewHandler;
    public CheckPriceView(ViewHandler viewHandler, CheckPriceModalViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
    }
    
    @Override
    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckPrice.fxml"));
        Parent root = loader.load();
        System.out.println("CheckPriceModal load");
        CheckPriceController controller = loader.getController();
        controller.init(viewHandler, viewModel);
        System.out.println("CheckPriceModal loa1");
        return root;
    }

    
}
