package com.example.demovkapi.exceptions;

public class EmptyTextException extends NullPointerException {
    public EmptyTextException(){
        super("your input field is empty!");
    }
}
