package br.com.abcode.clientes.controller;

import br.com.abcode.clientes.entity.Usuario;
import br.com.abcode.clientes.service.UsuarioService;
import br.com.abcode.clientes.service.exception.UsuarioCadastradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
        try {
            usuarioService.salvar(usuario);
        } catch (UsuarioCadastradoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}
