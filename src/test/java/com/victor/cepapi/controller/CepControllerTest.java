package com.victor.cepapi.controller;

import com.victor.cepapi.model.AdressDto;
import com.victor.cepapi.service.CepService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class CepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CepService cepService;

    @Test
    public void getCepTest() throws Exception {
        AdressDto adressDto = new AdressDto("12345", "logradouro", "bairro", "cidade", "uf");

        Mockito.when(cepService.getCep("12345")).thenReturn(adressDto);

        mockMvc.perform(get("/cep/12345")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cep", is(adressDto.getCep())))
                .andExpect(jsonPath("$.logradouro", is(adressDto.getLogradouro())))
                .andExpect(jsonPath("$.bairro", is(adressDto.getBairro())))
                .andExpect(jsonPath("$.cidade", is(adressDto.getCidade())))
                .andExpect(jsonPath("$.estado", is(adressDto.getUf())));
    }
}
