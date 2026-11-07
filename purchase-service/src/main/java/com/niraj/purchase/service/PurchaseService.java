package com.niraj.purchase.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseService {
private final RestTemplate restTemplate;

public PurchaseService(RestTemplate restTemplate){
    this.restTemplate=restTemplate;
    }

    public String purchaseProduct(int productId){

    String url="http://localhost:8081/products/"+productId;

    String response=restTemplate.getForObject(url,String.class);

    if(response.contains("Available")){
        return "Purchase succcessful:"+response;
    }
    return "purchase failed:"+response;
    }
}
