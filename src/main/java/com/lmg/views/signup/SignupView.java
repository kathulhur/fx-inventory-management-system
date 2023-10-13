package com.lmg.views.signup;

import java.io.IOException;

import com.lmg.viewmodels.signup.SignupViewModel;
import com.lmg.views.Controller;
import com.lmg.views.View;
import com.lmg.views.ViewHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class SignupView implements View {

    private ISignupViewModel viewModel;
    private ViewHandler viewHandler;

    public SignupView(ViewHandler viewHandler, ISignupViewModel viewModel) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;

    }
    
    @Override
    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignupView.fxml"));
        Parent root = loader.load();
        SignupController controller = loader.getController();
        controller.init(viewHandler, viewModel);
        return root;
    }

    
}
