package br.com.abcode.clientes.controller;

import br.com.abcode.clientes.controller.dto.ServicoDTO;
import br.com.abcode.clientes.entity.Cliente;
import br.com.abcode.clientes.entity.Servico;
import br.com.abcode.clientes.repository.ClienteRepository;
import br.com.abcode.clientes.repository.ServicoRepository;
import br.com.abcode.clientes.util.BidDecimalConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@AllArgsConstructor
public class ServicoController {

    private final ServicoRepository repository;
    private final ClienteRepository clienteRepository;
    private final BidDecimalConverter decimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico salvar(@RequestBody @Valid ServicoDTO servicoDTO) {
        LocalDate data = LocalDate.parse(servicoDTO.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer clienteId = servicoDTO.getClienteId();

        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado com id: " + clienteId));

        Servico servico = new Servico();
        servico.setDescricao(servicoDTO.getDescricao());
        servico.setData(data);
        servico.setCliente(cliente);
        servico.setValor(decimalConverter.converter(servicoDTO.getPreco()));

        return repository.save(servico);
    }

    @GetMapping
    public List<Servico> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }


}
