package com.lmg.views.login;

import com.lmg.services.Navigation;
import com.lmg.viewmodels.LoginViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;


    private LoginViewModel viewModel;
    private Navigation navigation;
    
    public void init(LoginViewModel loginViewModel, Navigation navigation) {

        this.viewModel = loginViewModel;
        this.navigation = navigation;
        usernameField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
        passwordField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
    }
    
    @FXML
    private void loginButtonClicked(ActionEvent event) {
        System.out.println("log in button clicked");
        viewModel.login(usernameField.getText(), passwordField.getText());
        navigation.switchToView("signup");
    }

}
