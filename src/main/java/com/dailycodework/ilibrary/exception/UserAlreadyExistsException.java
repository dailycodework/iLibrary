package com.dailycodework.ilibrary.exception;

/**
 * @author Samson Effes
 */

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
