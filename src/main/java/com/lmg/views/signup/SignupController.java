package com.lmg.views.signup;

import com.lmg.viewmodels.signup.SignupViewModel;
import com.lmg.views.Controller;
import com.lmg.views.ViewHandler;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class SignupController{

    @FXML
    private Parent rootContainer;
    
    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;


    private ISignupViewModel viewModel;

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ISignupViewModel signupViewModel) {
        this.viewModel = signupViewModel;
        this.viewHandler = viewHandler;
        usernameField.textProperty().bindBidirectional(signupViewModel.usernameProperty());
        passwordField.textProperty().bindBidirectional(signupViewModel.passwordProperty());

        Platform.runLater(() -> {
            rootContainer.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case ENTER:
                        signupButtonClicked(null);
                        break;
                    default:
                        break;
                }
            });
        });
    }
    
    @FXML
    void signupButtonClicked(ActionEvent event) {
        System.out.println("Sign up button clicked");
        viewModel.signup(usernameField.getText(), passwordField.getText());
    }

}
