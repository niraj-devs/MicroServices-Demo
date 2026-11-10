package com.niraj.purchase.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class ProductErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response){

        int status=response.status();
        if(status==404){
            return new ProductServiceException("Product not Found",status);
        }

        if(status==500){
            return new ProductServiceException("Product service internal error",status);
        }

        return new ProductServiceException("Product service error:",status);
    }
}
