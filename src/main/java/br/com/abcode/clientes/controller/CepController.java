package br.com.abcode.clientes.controller;

import br.com.abcode.clientes.controller.dto.CepDTO;
import br.com.abcode.clientes.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public CepDTO getAddressByCep(@PathVariable String cep){
        return cepService.getAddressByCep(cep);
    }
}
