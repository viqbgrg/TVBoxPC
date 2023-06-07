package com.github.viqbgrg.tvbox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TilePane tilePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Pane> list = FXCollections.observableArrayList();
    }
}