package com.example.fullstack.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Khong tim thay id cua user " + id);
    }

}
