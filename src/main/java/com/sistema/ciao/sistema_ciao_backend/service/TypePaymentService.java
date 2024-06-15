package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.TypePayment;
import com.sistema.ciao.sistema_ciao_backend.repository.TypePaymentRepository;

@Service
public class TypePaymentService {
    @Autowired
    private TypePaymentRepository typePaymentRepository;

    public List<TypePayment> findAll() {
        return typePaymentRepository.findAll();
    }

}

