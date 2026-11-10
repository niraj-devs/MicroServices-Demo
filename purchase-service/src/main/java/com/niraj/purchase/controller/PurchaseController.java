package com.niraj.purchase.controller;

import com.niraj.purchase.service.PurchaseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {

        this.purchaseService = purchaseService;
    }


    @GetMapping("/purchase/{id}")
    public ResponseEntity<String> purchase(@PathVariable Long id) {
        return purchaseService.purchaseProduct(id.intValue());
    }

    @PostMapping("/{productId}")
    public ResponseEntity<String> purchaseProduct(@PathVariable int productId) {
        return purchaseService.purchaseProduct(productId);
    }

    @PostMapping("/add/{productName}")
    public String addProduct(@PathVariable String productName){
        return purchaseService.addProduct(productName);
    }



}
