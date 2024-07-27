package com.tripservice.common;

public class UserNotLoggedInException extends Throwable {
    // Constructor for UserNotLoggedInException class
    public UserNotLoggedInException(String userNotLoggedIn) {
        super(userNotLoggedIn);
    }
}
