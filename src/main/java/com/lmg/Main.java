package com.lmg;


import com.lmg.models.ModelFactory;
import com.lmg.viewmodels.ViewModelFactory;
import com.lmg.views.ViewHandler;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ModelFactory mf = new ModelFactory();   
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(primaryStage, vmf);
        vh.start();
    }
}