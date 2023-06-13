package com.victor.cepapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.cepapi.model.Adress;
import com.victor.cepapi.model.AdressDto;
import com.victor.cepapi.service.CepService;

@RestController
@RequestMapping("/cep")

public class CepController {
    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<AdressDto> getCep(@PathVariable String cep) {
        return ResponseEntity.ok(cepService.getCep(cep));

    }
}