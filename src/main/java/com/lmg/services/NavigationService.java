package com.lmg.services;

import com.lmg.views.ViewHandler;

public class NavigationService implements Navigation {


    private ViewHandler viewHandler;

    public NavigationService(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }
        
    @Override
    public void switchToView(String viewToOpen) {
        viewHandler.switchToView(viewToOpen);
    }

}
