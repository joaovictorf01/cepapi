package com.victor.cepapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.victor.cepapi.model.Adress;

@FeignClient(name = "cepClient", url = "https://viacep.com.br/ws")
public interface CepClient {
    @GetMapping("/{cep}/json")
    Adress getCep(@PathVariable String cep);
}