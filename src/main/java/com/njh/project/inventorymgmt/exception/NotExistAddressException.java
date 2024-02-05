package com.njh.project.inventorymgmt.exception;

public class NotExistAddressException extends Exception {
    public NotExistAddressException(String msg) {
        super("Not Exist Address!" + msg);
    }
}
