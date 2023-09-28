package com.lmg.viewmodels;

import com.lmg.models.ModelFactory;

public class ViewModelFactory {
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private InventoryViewModel inventoryViewModel;
    private CheckPriceModalViewModel checkPriceModalViewModel;
    private CreateProductModalViewModel createProductModalViewModel;
    
    public ViewModelFactory(ModelFactory modelFactory) {
        signupViewModel = new SignupViewModel(modelFactory.getUserDAO());
        loginViewModel = new LoginViewModel(modelFactory.getUserDAO());
        inventoryViewModel = new InventoryViewModel(modelFactory.getProductDAO());
        checkPriceModalViewModel = new CheckPriceModalViewModel(modelFactory.getProductDAO());
        createProductModalViewModel = new CreateProductModalViewModel(modelFactory.getProductDAO());

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


}
