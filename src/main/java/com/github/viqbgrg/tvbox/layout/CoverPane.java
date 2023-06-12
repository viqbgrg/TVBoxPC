package com.github.viqbgrg.tvbox.layout;

import com.github.viqbgrg.tvbox.model.Result;
import com.github.viqbgrg.tvbox.model.Vod;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

import java.util.List;

public class CoverPane extends ScrollPane {
    private final List<Vod> list;
    public CoverPane(List<Vod> list) {
        super();
        this.list = list;
        setPrefHeight(439);
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setPrefWidth(200);
        setPrefWidth(760);
        createView();
        this.vvalueProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));
    }

    private void createView() {
        FlowPane flowPane = new FlowPane();
        List<StackPane> children = list.stream().parallel().map(item -> {
            ImageView imageView = new ImageView(item.getVodPic());
            Image image = new Image(item.getVodPic(), true);
            image.progressProperty().addListener((observable, oldValue, newValue) -> System.out.println("Progress: " + Math.rint(newValue.doubleValue() * 100) + "%"));
            imageView.setImage(image);
            Label label = new Label(item.getVodName());
            StackPane stackPane = new StackPane(imageView, label);
            return stackPane;
        }).toList();
        flowPane.getChildren().addAll(children);
        setContent(flowPane);
    }
}
