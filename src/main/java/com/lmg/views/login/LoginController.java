package com.lmg.views.login;

import java.net.URL;
import java.util.ResourceBundle;

import com.lmg.services.Navigation;
import com.lmg.viewmodels.LoginViewModel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Parent rootContainer;
    
    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button loginButton;

    private LoginViewModel viewModel;
    
    private Navigation navigation;
    
    public void init(LoginViewModel loginViewModel, Navigation navigation) {

        this.viewModel = loginViewModel;
        this.navigation = navigation;
        usernameField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
        passwordField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
        Platform.runLater(() -> {
            rootContainer.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case ENTER:
                        System.out.println("hihihii");
                        viewModel.login(usernameField.getText(), passwordField.getText());
                        navigation.switchToView("signup");
                        break;
                    default:
                        break;
                }
            });
        });
    }
    
    @FXML
    private void loginButtonClicked(ActionEvent event) {
        System.out.println("log in button clicked");
        viewModel.login(usernameField.getText(), passwordField.getText());
        navigation.switchToView("inventory");
    }


}
