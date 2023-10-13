package com.lmg.views.dashboard;

import java.io.IOException;

import com.lmg.views.Controller;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;
import com.lmg.views.layout.Layout;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class DashboardView implements View {

    private ViewHandler viewHandler;
    private IDashboardViewModel dashboardViewModel;
    public DashboardView(ViewHandler viewHandler, IDashboardViewModel dashboardViewModel) {
        this.viewHandler = viewHandler;
        this.dashboardViewModel = dashboardViewModel;
    }


    @Override
    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Parent node = loader.load();
        DashboardController dashboardController = loader.getController();
        dashboardController.init(viewHandler, dashboardViewModel);
        return Layout.wrap(node, viewHandler);
    }


}
