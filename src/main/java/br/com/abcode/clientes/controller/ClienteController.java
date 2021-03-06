package br.com.abcode.clientes.controller;

import br.com.abcode.clientes.entity.Cliente;
import br.com.abcode.clientes.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente encontrado com id: " + id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente encontrado com id: " + id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@Valid @PathVariable Integer id, @RequestBody Cliente clienteNovo) {
        repository
                .findById(id)
                .map(cliente -> {
                    cliente.setId(id);
                    cliente.setNome(clienteNovo.getNome());
                    cliente.setCpf(clienteNovo.getCpf());
                    return repository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
