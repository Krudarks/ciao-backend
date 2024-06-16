package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.TypePayment;
import com.sistema.ciao.sistema_ciao_backend.service.TypePaymentService;

@RestController
@RequestMapping("/typepayments/")
public class TypePaymentRest {
    @Autowired
    private TypePaymentService typePaymentService;
    
    @GetMapping
    private ResponseEntity<List<TypePayment>> getAllTypePayments (){
        return ResponseEntity.ok(typePaymentService.findAll());
    }
}
