package com.lmg.views.createProduct;

import java.io.IOException;

import com.lmg.views.Controller;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CreateProductView implements View  {
    private ViewHandler viewHandler;
    private ICreateProductViewModel viewModel;
    private CreateProductController controller;
    public CreateProductView(ViewHandler viewHandler, ICreateProductViewModel viewModel) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
    }
    
    @Override
    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateProduct.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        controller.init(viewHandler, viewModel);
        return root;

    }


}
