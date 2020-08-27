package br.com.abcode.clientes.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable =  false, length = 150)
    private String nome;
    
    @Column(nullable = false, length = 11)
    private String cpf;
    
    private LocalDate dataCadastro;

}
