package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagementController {
    public static User userToEdit = null;
    static List<User> userList = new ArrayList<>();

    static {
//        userList.add(new User("asif", "1234", "admin"));
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data/user.bin"))) {
            userList.clear();
            List< User > loadedList = (List<User>) inputStream.readObject();
            userList.addAll(loadedList);

//            userList = (List<User>) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    @javafx.fxml.FXML
    public void initialize() {
        userTypeCB.getItems().addAll("admin", "standard", "test");

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));

        tableView.getItems().addAll(userList);

//        readFromFile();
    }

    private void readFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.bin"))) {
            User u = (User) inputStream.readObject();
            messageLabel.setText(u.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            messageLabel.setText("Invalid file format!");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Could not read from file");
        }
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

        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                messageLabel.setText("This username is not available!");
                return;
            }
        }

        User user = new User(username, password, userType);
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

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("dashboard.fxml", actionEvent);
    }

    @FXML
    public void editUser(ActionEvent actionEvent) throws IOException {
        User user = tableView.getSelectionModel().getSelectedItem();
        if (user != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-user.fxml"));
            Parent root = loader.load();

            EditUserController controller = loader.getController();
            controller.setUser(user);

            Stage stage = (Stage) messageLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    @FXML
    public void saveUserList(ActionEvent actionEvent) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data/user.bin"))) {
            outputStream.writeObject(userList);
            messageLabel.setText("Successfully saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Could not write to file");
        }
    }

    @FXML
    public void loadUserList(ActionEvent actionEvent) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data/user.bin"))) {
            userList.clear();
            tableView.getItems().clear();

            List< User > loadedList = (List<User>) inputStream.readObject();
            userList.addAll(loadedList);
            tableView.getItems().addAll(loadedList);

            messageLabel.setText("Successfully loaded data");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            messageLabel.setText("Invalid file format");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Could not load data from file!");
        }
    }
}