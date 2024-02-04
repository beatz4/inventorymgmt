package com.njh.project.inventorymgmt.exception;

public class NotExistException extends Exception {

    public NotExistException(String msg) {
        super("Not Exist Exception!" + msg);
    }
}
