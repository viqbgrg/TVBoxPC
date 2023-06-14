package com.github.viqbgrg.tvbox;

import com.github.viqbgrg.tvbox.controller.ImageViewController;
import com.github.viqbgrg.tvbox.model.Class;
import com.github.viqbgrg.tvbox.model.Result;
import com.github.viqbgrg.tvbox.service.SiteVodService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

@Component
public class MainController implements Initializable {

    private final SiteVodService vodService;
    @FXML
    public TabPane tabPane;

    public MainController(SiteVodService vodService) {
        this.vodService = vodService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Result result = vodService.homeContent();
        List<Class> types = result.getTypes();
        List<Tab> list = IntStream.range(0, types.size() - 1).parallel().mapToObj(index -> {
            Class item = types.get(index);
            Tab tab;
            if (index == 0) {
                ScrollPane scrollPane = new ScrollPane();
                FlowPane flowPane = new FlowPane();
                List<Parent> list1 = result.getList().stream().parallel().map(item1 -> {
                    ClassPathResource fxml = new ClassPathResource("/fxml/imageView.fxml");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(fxml.getURL());
                        ImageViewController imageViewController = new ImageViewController(item1.getVodPic(), item1.getVodName(), item1.getVodRemarks(), item1.getVodId());
                        fxmlLoader.setController(imageViewController);
                        Parent root = fxmlLoader.load();
                        return root;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
                flowPane.getChildren().addAll(list1);
                scrollPane.setContent(flowPane);
                scrollPane.setFitToHeight(true);
                scrollPane.setFitToWidth(true);
                tab = new Tab(item.getTypeName(), scrollPane);
            } else {
                tab = new Tab(item.getTypeName());
            }
            tab.setId(item.getTypeId());
            return tab;
        }).toList();
        tabPane.getTabs().addAll(list);
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab.getContent() == null) {
                Result result1 = vodService.categoryContent(newTab.getId(), "10");
                ScrollPane scrollPane = new ScrollPane();
                FlowPane flowPane = new FlowPane();
                List<Parent> list1 = result1.getList().stream().parallel().map(item1 -> {
                    ClassPathResource fxml = new ClassPathResource("/fxml/imageView.fxml");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(fxml.getURL());
                        ImageViewController imageViewController = new ImageViewController(item1.getVodPic(), item1.getVodRemarks(), item1.getVodName(), item1.getVodId());
                        fxmlLoader.setController(imageViewController);
                        Parent root = fxmlLoader.load();
                        return root;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
                flowPane.getChildren().addAll(list1);
                scrollPane.setContent(flowPane);
                scrollPane.setFitToHeight(true);
                scrollPane.setFitToWidth(true);
                newTab.setContent(scrollPane);
            }
            System.out.print(newTab.getText());
        });
    }
}