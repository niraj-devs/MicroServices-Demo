package com.niraj.purchase.service;


import com.niraj.purchase.client.ProductClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class PurchaseService {
//
//private final RestClient restClient;
//
//public PurchaseService(RestClient restClient){
//
//    this.restClient=restClient;
//    }
//
//    public String purchaseProduct(int productId){
//
//    String url="http://localhost:8081/products/"+productId;
//
//    //String response=restTemplate.getForObject(url,String.class);
//
//        String response=restClient.get()
//            .uri("http://localhost:8081/products/{productId}",productId)
//            .retrieve()
//            .body(String.class);
//
//    if(response.contains("Available")){
//        return "Purchase succcessful:"+response;
//    }
//    return "purchase failed:"+response;
//    }
//
//    public String addProduct(String productName){
//        String response=restClient.post()
//                .uri("http://localhost:8081/products")
//                .body(productName)
//                .retrieve()
//                .body(String.class);
//
//        return response;
//    }

    public String purchaseProduct(int productId){

//String url="http://localhost:8081/products/"+productId;

//String response=restTemplate.getForObject(url,String.class);

//        String response=restClient.get()
//            .uri("http://localhost:8081/products/{productId}",productId)
//            .retrieve()
//            .body(String.class);

        String response=productClient.getProduct((long)productId);

    if(response.contains("Available")){
        return "Purchase succcessful:"+response;
    }
    return "purchase failed:"+response;
    }

    private final ProductClient productClient;

    public PurchaseService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public String addProduct(String productName){
        return productClient.addProduct(productName);
    }
}
