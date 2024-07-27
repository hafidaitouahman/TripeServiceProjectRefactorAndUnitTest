package com.tripservice.common;

public class DependedClassCallDuringUnitTestException extends Throwable {
    public DependedClassCallDuringUnitTestException(String message) {
        super(message);
    }

    public DependedClassCallDuringUnitTestException(String message, Throwable cause) {
        super(message, cause);
    }

}
