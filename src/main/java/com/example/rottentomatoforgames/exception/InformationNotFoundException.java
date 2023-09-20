package com.example.rottentomatoforgames.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{
    /**
     * Returns a message with Http Not Found status for when Information cant be found in the database.
     * @param message
     * Message sent with Http Not Found status number
     */
    public InformationNotFoundException(String message) {
        super(message);
    }
}
