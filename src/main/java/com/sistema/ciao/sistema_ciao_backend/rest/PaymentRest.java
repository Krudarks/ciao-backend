package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Payment;
import com.sistema.ciao.sistema_ciao_backend.service.PaymentService;

@RestController
@RequestMapping("/payments/")
public class PaymentRest {
    @Autowired
    private PaymentService paymentService;
    
    @GetMapping
    private ResponseEntity<List<Payment>> getAllPayment (){
        return ResponseEntity.ok(paymentService.findAll());
    }
}
