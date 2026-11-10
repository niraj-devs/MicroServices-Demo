package com.niraj.purchase.service;


import com.niraj.purchase.client.ProductClient;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


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

    public ResponseEntity<String> purchaseProduct(int productId) {

//String url="http://localhost:8081/products/"+productId;

//String response=restTemplate.getForObject(url,String.class);

//        String response=restClient.get()
//            .uri("http://localhost:8081/products/{productId}",productId)
//            .retrieve()
//            .body(String.class);

        try {
            String response = productClient.getProduct((long) productId);

            if (response.contains("Available")) {
                return ResponseEntity.ok("Purchase successful:" + response);
            }
            return ResponseEntity.ok("purchase failed:" + response);
        } catch (FeignException.NotFound e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Purchase failed:Product not found");
        }
    }

    private final ProductClient productClient;

    public PurchaseService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public String addProduct(String productName){
        return productClient.addProduct(productName);
    }
}
