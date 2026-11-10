package com.niraj.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable int id) {

        if (id == 1) {
            return ResponseEntity.ok("Laptop is Available");
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Product not found");
    }

    @PostMapping
    public String addProduct(@RequestBody String productName){
        return "Product received:"+productName;
    }
}