package com.niraj.purchase.config;

import com.niraj.purchase.exception.ProductErrorDecoder;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public ErrorDecoder errorDecoder(){

        return new ProductErrorDecoder();
    }
    @Bean
    public Retryer retryer(){
        return new Retryer.Default(1000,2000,3);

    }
}
