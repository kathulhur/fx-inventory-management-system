package com.lmg.views.signup;

import java.io.IOException;

import com.lmg.services.Navigation;
import com.lmg.viewmodels.SignupViewModel;
import com.lmg.views.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class SignupView implements View{

    private SignupViewModel signupViewModel;
    private Navigation navigation;

    public SignupView(SignupViewModel signupViewModel, Navigation navigation) {
        this.signupViewModel = signupViewModel;
        this.navigation = navigation;
    }
    
    @Override
    public Node load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignupView.fxml"));
        Parent root = loader.load();
        SignupController controller = loader.getController();
        controller.init(signupViewModel, navigation);
        return root;
    }
    
}
