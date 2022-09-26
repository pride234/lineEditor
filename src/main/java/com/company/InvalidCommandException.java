package com.company;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String exceptionText){
        super(exceptionText);
    }
}
