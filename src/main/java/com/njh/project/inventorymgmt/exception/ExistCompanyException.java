package com.njh.project.inventorymgmt.exception;

public class ExistCompanyException extends Exception {

    public ExistCompanyException(String msg) {
        super("Already Exist Company" + msg);
    }
    
}
