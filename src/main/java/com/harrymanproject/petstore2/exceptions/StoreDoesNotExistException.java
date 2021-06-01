package com.harrymanproject.petstore2.exceptions;

public class StoreDoesNotExistException extends Exception{

    public StoreDoesNotExistException(){
    }

    public StoreDoesNotExistException(String message){
        super(message);
    }
}
