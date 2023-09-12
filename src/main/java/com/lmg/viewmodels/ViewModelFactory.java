package com.lmg.viewmodels;

import com.lmg.models.ModelFactory;

public class ViewModelFactory {
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    public ViewModelFactory(ModelFactory modelFactory) {
        signupViewModel = new SignupViewModel(modelFactory.getUserDAO());
        loginViewModel = new LoginViewModel(modelFactory.getUserDAO());
    }

    public SignupViewModel getSignupViewModel() {
        return signupViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
}
