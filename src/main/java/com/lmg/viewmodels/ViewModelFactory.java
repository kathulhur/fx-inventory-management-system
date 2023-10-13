package com.lmg.viewmodels;

import com.lmg.models.ModelFactory;
import com.lmg.viewmodels.dashboard.DashboardViewModel;
import com.lmg.viewmodels.inventory.InventoryViewModel;
import com.lmg.viewmodels.login.LoginViewModel;
import com.lmg.viewmodels.signup.SignupViewModel;
import com.lmg.viewmodels.transaction.TransactionViewModel;
import com.lmg.viewmodels.transactionDetail.TransactionDetailViewModel;
import com.lmg.viewmodels.transactions.TransactionsViewModel;

public class ViewModelFactory {
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private InventoryViewModel inventoryViewModel;
    private CheckPriceModalViewModel checkPriceModalViewModel;
    private CreateProductModalViewModel createProductModalViewModel;
    private TransactionViewModel transactionViewModel;
    private TransactionsViewModel transactionsViewModel;
    private DashboardViewModel dashboardViewModel;
    private TransactionDetailViewModel transactionDetailViewModel;
    
    public ViewModelFactory(ModelFactory modelFactory) {
        signupViewModel = new SignupViewModel(modelFactory.getUserDAO());
        loginViewModel = new LoginViewModel(modelFactory.getUserDAO());
        inventoryViewModel = new InventoryViewModel(modelFactory.getProductDAO());
        checkPriceModalViewModel = new CheckPriceModalViewModel(modelFactory.getProductDAO());
        createProductModalViewModel = new CreateProductModalViewModel(modelFactory.getProductDAO());
        transactionViewModel = new TransactionViewModel(modelFactory.getTransactionDAO(), modelFactory.getProductDAO());
        transactionsViewModel = new TransactionsViewModel(modelFactory.getTransactionDAO());
        dashboardViewModel = new DashboardViewModel(modelFactory.getTransactionDAO());
        transactionDetailViewModel = new TransactionDetailViewModel(modelFactory.getTransactionDAO());

    }

    public SignupViewModel getSignupViewModel() {
        return signupViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    public InventoryViewModel getInventoryViewModel() {
        return inventoryViewModel;
    }

    public CheckPriceModalViewModel getCheckPriceModalViewModel() {
        return checkPriceModalViewModel;
    }

    public CreateProductModalViewModel getCreateProductModalViewModel() {
        return createProductModalViewModel;
    }

    public TransactionViewModel getTransactionViewModel() {
        return transactionViewModel;
    }

    public TransactionsViewModel getTransactionsViewModel() {
        return transactionsViewModel;
    }

    public DashboardViewModel getDashboardViewModel() {
        return dashboardViewModel;
    }

    public TransactionDetailViewModel getTransactionDetailViewModel() {
        return transactionDetailViewModel;
    }

}
