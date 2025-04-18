package com.iub.oop.spring25section2;

import java.io.Serializable;

public class User implements Serializable {
    private String username, password, userType;

    public User() {
    }

    public User(String password, String userType) {
        this.password = password;
        this.userType = userType;
    }

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRandomData(){
        return "Hi";
    }

    @Override
    public String toString() {
        return username + " (" + userType + " user)";
    }
}
