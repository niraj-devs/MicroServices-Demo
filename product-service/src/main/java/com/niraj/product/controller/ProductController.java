package com.niraj.product.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {

        if (id == 1) {
            return "Laptop is Available";
        }

        return "Product out of Stock";
    }

    @PostMapping
    public String addProduct(@RequestBody String productName){
        return "Product received:"+productName;
    }
}