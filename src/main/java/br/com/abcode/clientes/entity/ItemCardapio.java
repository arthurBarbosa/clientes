package br.com.abcode.clientes.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "item_cardapio")
@Data
public class ItemCardapio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{campo.nome}")
    @Size(max = 45)
    private String nome;

    @NotBlank(message = "{campo.descricao}")
    @Size(max = 80)
    private String descricao;

    @Size(max = 50)
    private String imagem;

    @NotNull(message = "{campo.preco}")
    @Min(0)
    private BigDecimal preco;

    @NotBlank(message = "A categoria nao pode ser vazia")
    private String categoria;

    @NotNull
    private Boolean destaque;
}
