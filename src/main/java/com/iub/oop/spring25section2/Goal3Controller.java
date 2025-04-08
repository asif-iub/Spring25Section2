package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class Goal3Controller
{
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextArea textArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("login.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void readFromFile(ActionEvent actionEvent) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            char[] buf = new char[10];
            while(true) {
                String line = reader.readLine();
                if (line == null) break;
                textArea.appendText(line + "\n");
            }
        }
        catch (IOException e) {
            label.setText("Could not read from file!");
        }
    }
}