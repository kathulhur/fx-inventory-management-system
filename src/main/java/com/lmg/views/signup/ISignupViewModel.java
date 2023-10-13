package com.lmg.views.signup;

import javafx.beans.property.StringProperty;

public interface ISignupViewModel {

    public StringProperty usernameProperty();

    public StringProperty passwordProperty();

    public void signup(String username, String password);


}
