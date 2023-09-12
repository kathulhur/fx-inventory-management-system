package com.lmg.views;

import java.io.IOException;

import javafx.scene.Node;

public interface View {
    Node load() throws IOException;
}
