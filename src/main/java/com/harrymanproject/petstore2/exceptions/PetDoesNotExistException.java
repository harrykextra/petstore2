package com.harrymanproject.petstore2.exceptions;

public class PetDoesNotExistException extends Exception{

    public PetDoesNotExistException(){
    }

    public PetDoesNotExistException(String message){
        super(message);
    }
}
