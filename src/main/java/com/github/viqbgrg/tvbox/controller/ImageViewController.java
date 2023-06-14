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

    private final String vodId;


    public ImageViewController(String url, String describeText, String nameText, String vodId) {
        this.url = url;
        this.describeText = describeText;
        this.nameText = nameText;
        this.vodId = vodId;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (url != null) {
            this.image.setImage(new Image(url, true));
        }
        this.describe.setText(describeText);
        this.name.setText(nameText);
    }

    void initData(String name) {
    }

    @FXML
    public void play(){
        System.out.println(this.vodId);
    }


}
