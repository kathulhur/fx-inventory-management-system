package com.lmg.views;

import java.io.IOException;

import javafx.scene.Parent;

public interface View {
    public Parent load() throws IOException;

}
