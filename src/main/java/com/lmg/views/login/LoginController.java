package com.lmg.views.login;

import com.lmg.views.Controller;
import com.lmg.views.ViewHandler;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
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

    private ILoginViewModel viewModel;
    
    private ViewHandler viewHandler;
    
    public void init(ViewHandler viewHandler, ILoginViewModel loginViewModel) {

        this.viewModel = loginViewModel;
        this.viewHandler = viewHandler;
        usernameField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
        passwordField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
        Platform.runLater(() -> {
            rootContainer.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case ENTER:
                        loginButtonClicked(null);
                        break;
                    default:
                        break;
                }
            });
        });
    }
    
    @FXML
    private void loginButtonClicked(ActionEvent event) {
        viewModel.login(usernameField.getText(), passwordField.getText());
        viewHandler.switchToView("dashboard");
    }


}
