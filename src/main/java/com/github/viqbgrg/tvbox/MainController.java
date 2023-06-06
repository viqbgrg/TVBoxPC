package com.github.viqbgrg.tvbox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ListView<Pane> listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Pane> list = FXCollections.observableArrayList();
        for (int i = 1; i <= 10; i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("list-view.fxml"));
            Pane listItem = null;
            try {
                listItem = fxmlLoader.load();
                ListItemController controller = fxmlLoader.getController();
                controller.setText("List Item " + i);
                list.add(listItem);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        listView.getItems().addAll(list);
    }
}