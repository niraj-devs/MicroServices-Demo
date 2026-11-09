package com.niraj.purchase.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name="product-service",
        url="http://localhost:8081"
)
public interface ProductClient {

    @GetMapping("/products/{id}")
    String getProduct(@PathVariable("id") Long id);

    @PostMapping("/products")
    String addProduct(@RequestBody String productName);


}
