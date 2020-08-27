package br.com.abcode.clientes.entity;


import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Serializable {

    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataCadastro;
}
