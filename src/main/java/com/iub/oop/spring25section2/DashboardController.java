package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;

public class DashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goToUserManagement(ActionEvent actionEvent) {
        System.out.println("Going to User Management scene");
    }
}