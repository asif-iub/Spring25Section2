package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goToUserManagement(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("userManagement.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void goToGoal2(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("goal2.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void goToGoal3(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("goal3.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("login.fxml", actionEvent);
    }
}