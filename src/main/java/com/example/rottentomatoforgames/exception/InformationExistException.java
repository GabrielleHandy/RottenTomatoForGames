package com.example.rottentomatoforgames.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException {
    /**
     * Returns a message with Http Conflict status for when Information has already been added.
     * @param message
     * Message sent with Http Conflict status number
     */
    public InformationExistException(String message){
        super(message);
    }
}
