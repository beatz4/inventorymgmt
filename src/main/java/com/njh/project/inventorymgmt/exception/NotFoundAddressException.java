package com.njh.project.inventorymgmt.exception;

public class NotFoundAddressException extends Exception {
    public NotFoundAddressException(String msg) {
        super("Not Found Address!" + msg);
    }
}
