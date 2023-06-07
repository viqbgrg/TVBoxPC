package com.github.viqbgrg.tvbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListItemController {
    @FXML
    Label label;
    @FXML
    ImageView image;

    @FXML
    public void ButtonClick(ActionEvent actionEvent) {

    }

    public void setDate(String text, String url) {
        label.setText(text);
        //image.setImage(new Image(url));
    }
}
