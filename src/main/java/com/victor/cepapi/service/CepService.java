package com.victor.cepapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.cepapi.client.CepClient;
import com.victor.cepapi.model.Adress;
import com.victor.cepapi.model.AdressDto;

@Service
public class CepService {
    @Autowired
    private CepClient cepClient;

    public AdressDto getCep(String cep) {
        Adress adress = cepClient.getCep(cep);
        AdressDto adressDto = new AdressDto(
                adress.getCep(),
                adress.getLogradouro(),
                adress.getBairro(),
                adress.getCidade(),
                adress.getUf());
        return adressDto;

    }
}
