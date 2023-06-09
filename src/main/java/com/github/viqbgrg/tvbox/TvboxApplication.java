package com.github.viqbgrg.tvbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TvboxApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }
}