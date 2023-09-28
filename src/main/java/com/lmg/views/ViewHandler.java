package com.lmg.views;

import java.io.IOException;

import com.lmg.services.Navigation;
import com.lmg.services.NavigationService;
import com.lmg.viewmodels.ViewModelFactory;
import com.lmg.views.inventory.InventoryView;
import com.lmg.views.login.LoginView;
import com.lmg.views.modals.OnSubmit;
import com.lmg.views.modals.checkPrice.CheckPriceModal;
import com.lmg.views.modals.product.create.CreateProductModal;
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
    private Stage modalStage;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
        this.navigation = new NavigationService(this);
        try {
            root = FXMLLoader.load(getClass().getResource("Root.fxml"));
        } catch (Exception e) {
            System.out.println("Error opening root view");
        }

        modalStage = new Stage();
        modalStage.initOwner(stage);
        modalStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        modalStage.initStyle(javafx.stage.StageStyle.UNDECORATED);

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

            case "inventory":
                try {
                    openInventoryView();
                    System.out.println("Opened inventory view");

                } catch (Exception e) {
                    System.out.println("Error opening inventory view");
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

    private void openInventoryView() throws IOException {
        InventoryView inventoryView = new InventoryView(this, viewModelFactory.getInventoryViewModel());
        Node node = inventoryView.load();
        root.getChildren().setAll(node);
    }

    
    public void showCreateProductModal(OnSubmit onSubmit) throws IOException{
        openCreateProductModal(onSubmit);
    }

    public void showCheckPriceModal() throws IOException{
        openCheckPriceModal();
    }

    private void openCheckPriceModal() throws IOException {
        CheckPriceModal checkPriceModal = new CheckPriceModal(this, viewModelFactory.getCheckPriceModalViewModel());
        modalStage.setScene(new Scene(checkPriceModal.load()));
        modalStage.show();
    }

    private void openCreateProductModal(OnSubmit onSubmit) throws IOException {
            CreateProductModal createProductModal = new CreateProductModal(this, viewModelFactory.getCreateProductModalViewModel(), onSubmit);
            modalStage.setScene(new Scene(createProductModal.load()));
            modalStage.show();
    }

    public void closeModal() {
        modalStage.close();
    }
        
}
