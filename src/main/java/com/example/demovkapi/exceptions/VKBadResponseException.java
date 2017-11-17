package com.example.demovkapi.exceptions;

public class VKBadResponseException extends RuntimeException {
    public VKBadResponseException(int code){
        super("status code: " + code);
    }

}
