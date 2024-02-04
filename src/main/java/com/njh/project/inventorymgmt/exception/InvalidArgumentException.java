package com.njh.project.inventorymgmt.exception;

public class InvalidArgumentException extends Exception {

    public InvalidArgumentException(String msg) {
        super("Occur Invalid Argument Exception!" + msg);
    }
    
}
