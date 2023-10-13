package com.lmg.views.login;

import javafx.beans.property.StringProperty;

public interface ILoginViewModel {
    
    public StringProperty usernameProperty();

    public StringProperty passwordProperty();
    
    public void login(String username, String password);


}
