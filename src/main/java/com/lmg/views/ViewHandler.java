package com.lmg.views;

import java.io.IOException;

import com.lmg.viewmodels.ViewModelFactory;
import com.lmg.views.checkPrice.CheckPriceView;
import com.lmg.views.createProduct.CreateProductView;
import com.lmg.views.dashboard.DashboardView;
import com.lmg.views.inventory.InventoryView;
import com.lmg.views.login.LoginView;
import com.lmg.views.modals.TransactionDetail.TransactionDetailView;
import com.lmg.views.signup.SignupView;
import com.lmg.views.transaction.TransactionView;
import com.lmg.views.transactions.TransactionsView;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewHandler {
    

    private Stage stage;
    private AnchorPane root;
    private Stage modalStage;
    private ViewModelFactory viewModelFactory;
    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
        setupStage(stage);
    }
    
    private void setupStage(Stage stage) {
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.setTitle("Login");
        
        try {
            root = FXMLLoader.load(getClass().getResource("Root.fxml"));
        } catch (Exception e) {
            System.out.println("Error opening root view");
        }
        
        modalStage = new Stage();
        modalStage.initOwner(stage);
        modalStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        modalStage.initStyle(javafx.stage.StageStyle.UNDECORATED);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        switchToView("login");
    }
    
    public void start() {
        
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

            case "transactions":
                try {
                    openTransactionsView();
                    System.out.println("Opened transactions view");

                } catch (Exception e) {
                    e.printStackTrace(System.err);
                    System.out.println("Error opening transactions view");
                }

                break;

            case "dashboard":
                try {
                    openDashboardView();
                    System.out.println("Opened dashboard view");

                } catch (Exception e) {
                    System.out.println("Error opening dashboard view");
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

    private void mountView(Node node) {
        root.getChildren().setAll(setNodeAnchor(node));
    }

    private void openSignupView() throws IOException {
        View signupView = new SignupView(this, viewModelFactory.getSignupViewModel());
        mountView(signupView.load());
            
    }

    private void openLoginView() throws IOException {
        View loginView = new LoginView(this, viewModelFactory.getLoginViewModel());
        mountView(loginView.load());
    }

    private void openInventoryView() throws IOException {
        View view = new InventoryView(this, viewModelFactory.getInventoryViewModel());
        mountView(view.load());
    }

    private void openTransactionsView() throws IOException {
        View view = new TransactionsView(this, viewModelFactory.getTransactionsViewModel());
        mountView(view.load());
    }

    private void openDashboardView() throws IOException {
        View dashboardView = new DashboardView(this, viewModelFactory.getDashboardViewModel());
        mountView(dashboardView.load());
    }


    
    public void showTransactionModal() throws IOException {
        View transactionModal = new TransactionView(this, viewModelFactory.getTransactionViewModel());
        modalStage.setScene(new Scene(transactionModal.load()));
        modalStage.show();
    }

    public void showCheckPriceModal() throws IOException {
        View checkPriceModal = new CheckPriceView(this, viewModelFactory.getCheckPriceModalViewModel());
        modalStage.setScene(new Scene(checkPriceModal.load()));
        modalStage.show();
    }

    public void showCreateProductModal() throws IOException {
        View createProductModal = new CreateProductView(this,
                viewModelFactory.getCreateProductModalViewModel());
        modalStage.setScene(new Scene(createProductModal.load()));
        modalStage.show();
    }

    public void showTransactionDetailModal() throws IOException {
        View transactionDetailView = new TransactionDetailView(this, viewModelFactory.getTransactionDetailViewModel());
        modalStage.setScene(new Scene(transactionDetailView.load()));
        modalStage.show();
    }
    

    public void closeModal() {
        modalStage.close();
    }
        
}
