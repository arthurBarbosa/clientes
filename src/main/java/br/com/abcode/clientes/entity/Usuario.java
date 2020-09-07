package br.com.abcode.clientes.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotBlank(message = "{campo.login.obrigatorio}")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "{campo.senha.obrigatorio}")
    private String password;

}
