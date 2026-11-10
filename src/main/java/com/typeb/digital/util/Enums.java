package com.typeb.digital.util;

public enum Enums {
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    private String status;

    Enums(String status){
        this.status=status;
    }
    public String value(){
        return status;
    }
}
