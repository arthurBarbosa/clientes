package br.com.abcode.clientes.service;

import br.com.abcode.clientes.controller.dto.CepDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private final RestTemplate restTemplate;
    @Value("${cep.url}")
    private String cepUrl;

    public CepService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CepDTO getAddressByCep(String cep) {
        String url = cepUrl + cep + "/json/";
        ResponseEntity<CepDTO> response = this.restTemplate.getForEntity(url, CepDTO.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }

        return null;
    }
}
