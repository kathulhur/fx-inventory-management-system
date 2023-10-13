package com.lmg.views;

import java.io.IOException;

public interface IViewFactory {
    
    public View getLoginView() throws IOException;

    public View getSignupView() throws IOException;
    public View getDashboardView() throws IOException;

    public View getInventoryView() throws IOException;

    public View getTransactionsView() throws IOException;

    public View getTransactionsDetailView() throws IOException;

    public View getCreateProductView() throws IOException;
}
