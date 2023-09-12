package com.lmg.views.signup;

import com.lmg.services.Navigation;
import com.lmg.viewmodels.SignupViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    private Navigation navigation;

    private SignupViewModel viewModel;
    public void init(SignupViewModel signupViewModel, Navigation navigation) {
        this.viewModel = signupViewModel;
        this.navigation = navigation;
        usernameField.textProperty().bindBidirectional(signupViewModel.usernameProperty());
        passwordField.textProperty().bindBidirectional(signupViewModel.passwordProperty());
    }
    
    @FXML
    void signupButtonClicked(ActionEvent event) {
        System.out.println("Sign up button clicked");
        viewModel.signup(usernameField.getText(), passwordField.getText());
    }

}
