package com.iub.oop.spring25section2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitcher.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("charts.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CSE213 - Object Oriented Programming");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}