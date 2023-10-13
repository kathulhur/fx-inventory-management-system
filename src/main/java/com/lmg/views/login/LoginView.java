package com.lmg.views.login;

import java.io.IOException;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginView implements View {

    private ILoginViewModel viewModel;
    private ViewHandler viewHandler;

    public LoginView(ViewHandler viewHandler, ILoginViewModel loginViewModel) {
        this.viewModel = loginViewModel;
        this.viewHandler = viewHandler;
    }
    

    @Override
    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
        Parent root = loader.load();
        
        LoginController controller = loader.getController();
        controller.init(viewHandler, viewModel);

        return root;
    }


    
}
