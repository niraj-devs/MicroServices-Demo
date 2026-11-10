package com.niraj.purchase.exception;

public class ProductServiceException extends RuntimeException {

    private final int statusCode;

    public ProductServiceException(String message,int statusCode){
        super(message);
        this.statusCode=statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }

}
