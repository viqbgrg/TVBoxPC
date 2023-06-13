package com.github.viqbgrg.tvbox.layout;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Tab;

public class VideoTab extends Tab {
    public VideoTab(String text) {
        this(text, null);

    }

    public VideoTab(String text, Node content) {
        super(text, content);
        selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("我被选中");
                System.out.println(this.getContent());
            }
        });
    }
}
