package com.github.viqbgrg.tvbox.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageViewController {

    @FXML
    public Image image;
    @FXML
    public Label describe;
    @FXML
    public Label name;
}
