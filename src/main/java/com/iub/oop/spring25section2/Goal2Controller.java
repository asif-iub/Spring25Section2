package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class Goal2Controller
{
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private CheckBox appendCheckBox;

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
    public void writeToFile(ActionEvent actionEvent) throws IOException {
        try (FileWriter writer = new FileWriter(
                "data.txt",
                appendCheckBox.isSelected()
        )) {
            writer.write(textArea.getText());
            label.setText("File saved successfully!");
        } catch (IOException e) {
            label.setText("Could not save!");
        }
    }
}