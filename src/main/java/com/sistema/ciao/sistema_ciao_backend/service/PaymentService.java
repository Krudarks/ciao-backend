package com.sistema.ciao.sistema_ciao_backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Payment;
import com.sistema.ciao.sistema_ciao_backend.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }
}
