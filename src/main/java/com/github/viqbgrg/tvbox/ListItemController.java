package com.github.viqbgrg.tvbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ListItemController {
    @FXML
    Label label;

    @FXML
    public void ButtonClick(ActionEvent actionEvent) {

    }

    public void setText(String string) {
        label.setText(string);
    }
}
