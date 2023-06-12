package com.github.viqbgrg.tvbox;

import com.github.viqbgrg.tvbox.layout.CoverPane;
import com.github.viqbgrg.tvbox.model.Class;
import com.github.viqbgrg.tvbox.model.Result;
import com.github.viqbgrg.tvbox.model.Vod;
import com.github.viqbgrg.tvbox.service.SiteVodService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.springframework.stereotype.Component;

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
        List<Tab> list = IntStream.range(0, types.size()-1).parallel().mapToObj(index->{
            Class item = types.get(index);
            Tab tab;
            if (index == 0) {
                tab = new Tab(item.getTypeName(), new CoverPane(result.getList()));
            }else{
                tab = new Tab(item.getTypeName());
            }
            return tab;
        }).toList();
        tabPane.getTabs().addAll(list);
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            System.out.print(newTab.getText());
        });
    }
}