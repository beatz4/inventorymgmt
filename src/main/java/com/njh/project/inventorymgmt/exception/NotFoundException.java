package com.njh.project.inventorymgmt.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String msg) {
        super("Not Found Exception!" + msg);
    }
}
