package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManagementController
{
    @javafx.fxml.FXML
    private TextField usernameTF;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeCB;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private Label messageLabel;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> passwordColumn;
    @FXML
    private TableColumn<User, Integer> userTypeColumn;

    static List<User> userList = new ArrayList<>();
    static{
        userList.add(
                new User("asif","1234", "admin")
        );
    }

    @javafx.fxml.FXML
    public void initialize() {
        userTypeCB.getItems().addAll(
                "admin",
                "standard",
                "test"
        );

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));

        tableView.getItems().addAll(userList);
    }

    @javafx.fxml.FXML
    public void addUser(ActionEvent actionEvent) {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String userType = userTypeCB.getValue();

        if (username.isBlank() || password.isBlank() || userType == null) {
            messageLabel.setText("Please provide all inputs");
            return;
        }
//        if (password.length() < 8) {
//            messageLabel.setText("Password must be at least 8 characters long!");
//            return;
//        }

        for(User u : userList) {
            if (u.getUsername().equals(username)) {
                messageLabel.setText("This username is not available!");
                return;
            }
        }

        User user  = new User(username, password, userType);
        userList.add(user);
        tableView.getItems().add(user);
        messageLabel.setText("User added successfully");
//        System.out.println("Currently " + userList.size() + " users in the list");

        usernameTF.setText("");
        passwordTF.setText("");
        userTypeCB.setValue(null);
    }

    @FXML
    public void logOut(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("login.fxml", actionEvent);
    }
}