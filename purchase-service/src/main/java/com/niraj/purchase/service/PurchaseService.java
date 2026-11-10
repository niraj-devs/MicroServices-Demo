package com.niraj.purchase.service;


import com.niraj.purchase.client.ProductClient;
import com.niraj.purchase.exception.ProductServiceException;
import feign.RetryableException;
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
        } catch (ProductServiceException e) {

            return ResponseEntity
                    .status(e.getStatusCode())
                    .body("Purchase failed: " + e.getMessage());
        }catch(RetryableException e) {

            return ResponseEntity
                    .status(503)
                    .body("Product Service is currently unavailable.Please try again later.");
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
