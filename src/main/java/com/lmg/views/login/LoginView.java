package com.lmg.views.login;

import java.io.IOException;

import com.lmg.services.Navigation;
import com.lmg.viewmodels.LoginViewModel;
import com.lmg.views.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView implements View{

    private LoginViewModel viewModel;
    private Navigation navigation;

    public LoginView(LoginViewModel loginViewModel, Navigation navigation) {
        this.viewModel = loginViewModel;
        this.navigation = navigation;
    }
    

    @Override
    public Node load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
        Parent root = loader.load();

        LoginController controller = loader.getController();
        controller.init(viewModel, navigation);

        return root;
    }
    
}
