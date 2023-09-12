package com.lmg.views;

import java.io.IOException;

import com.lmg.services.Navigation;
import com.lmg.services.NavigationService;
import com.lmg.viewmodels.ViewModelFactory;
import com.lmg.views.login.LoginView;
import com.lmg.views.signup.SignupView;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewHandler {
    

    private Stage stage;
    private ViewModelFactory viewModelFactory;
    private Navigation navigation;
    private AnchorPane root;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
        this.navigation = new NavigationService(this);
        try {
            root = FXMLLoader.load(getClass().getResource("Root.fxml"));
        } catch (Exception e) {
            System.out.println("Error opening root view");
        }

    }
    
    public void start() {
        stage.setTitle("Login");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        switchToView("login");
        stage.show();
    }

    public void switchToView(String viewToOpen) {
        switch (viewToOpen) {
            case "signup":
                try {
                    openSignupView();
                    System.out.println("Opened signup view");

                } catch (Exception e) {
                    System.out.println("Error opening signup view");
                }
                break;

            case "login":
                try {
                    openLoginView();
                    System.out.println("Opened login view");

                } catch (Exception e) {
                    System.out.println("Error opening login view");
                }

                break;
            default:
                System.err.println("View not found");
        }
        
    }

    private Node setNodeAnchor(Node node) {
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setRightAnchor(node, 0.0);

        return node;
    }

    private void openSignupView() throws IOException {
        SignupView signupView = new SignupView(viewModelFactory.getSignupViewModel(), navigation);
        
        root.getChildren().setAll(setNodeAnchor(signupView.load()));
            
    }

    private void openLoginView() throws IOException {
        LoginView loginView = new LoginView(viewModelFactory.getLoginViewModel(), navigation);

        root.getChildren().setAll(setNodeAnchor(loginView.load()));

    }
        
}
