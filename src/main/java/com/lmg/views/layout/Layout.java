package com.lmg.views.layout;

import java.io.IOException;

import com.lmg.views.ViewHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class Layout {


    public static Parent wrap(Node view, ViewHandler viewHandler) throws IOException {
        FXMLLoader layoutLoader = new FXMLLoader(Layout.class.getResource("/com/lmg/views/layout/Layout.fxml"));
        Parent layoutRoot = layoutLoader.load();
        LayoutController layoutController = layoutLoader.getController();
        layoutController.init(viewHandler);
        layoutController.setView(view);
        
        return layoutRoot;
    }
    


}
