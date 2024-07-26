package com.tripservice.web;

import com.tripservice.user.User;

public class UserSession {
    User user;
    private static UserSession instance;
    private String userId;
    public UserSession(String userId) {
        this.userId = userId;
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession("");
        }
        return instance;
    }

    public User getLoggedUser() {
        return user;
    }
    public String getUserId() {
        return userId;
    }


}
