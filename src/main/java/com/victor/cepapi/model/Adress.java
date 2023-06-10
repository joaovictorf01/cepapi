package com.victor.cepapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

}
