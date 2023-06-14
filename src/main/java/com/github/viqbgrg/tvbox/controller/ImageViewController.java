package com.github.viqbgrg.tvbox.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ImageViewController  implements Initializable {
    @FXML
    public ImageView image;
    @FXML
    public Label describe;
    @FXML
    public Label name;

    private final String url;
    private final String describeText;
    private final String nameText;


    public ImageViewController(String url, String describeText, String nameText) {
        this.url = url;
        this.describeText = describeText;
        this.nameText = nameText;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.image.setImage(new Image(url, true));
        this.describe.setText(describeText);
        this.name.setText(nameText);
    }
}
