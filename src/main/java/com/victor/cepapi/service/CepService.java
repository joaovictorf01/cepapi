package com.victor.cepapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.cepapi.client.CepClient;
import com.victor.cepapi.model.Adress;

@Service
public class CepService {
    @Autowired
    private CepClient cepClient;

    public Adress getCep(String cep) {
        return cepClient.getCep(cep);

    }
}
