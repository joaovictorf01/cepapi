package com.victor.cepapi.service;

import com.victor.cepapi.client.CepClient;
import com.victor.cepapi.model.Adress;
import com.victor.cepapi.model.AdressDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CepServiceTest {

    @Autowired
    private CepService cepService;

    @MockBean
    private CepClient cepClient;

    @Test
    public void getCepTest() {
        Adress adress = new Adress("12345", "logradouro", "bairro", "cidade", "uf");
        AdressDto expectedAdressDto = new AdressDto("12345", "logradouro", "bairro", "cidade", "uf");

        Mockito.when(cepClient.getCep("12345")).thenReturn(adress);

        AdressDto actualAdressDto = cepService.getCep("12345");

        assertEquals(expectedAdressDto, actualAdressDto);
    }
}
