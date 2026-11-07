package com.niraj.purchase.controller;

import com.niraj.purchase.service.PurchaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping ("/{productId}")
    public String purchaseProduct(@PathVariable int productId) {
    return purchaseService.purchaseProduct(productId);
    }



}
