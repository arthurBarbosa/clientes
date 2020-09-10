package br.com.abcode.clientes.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ItemPedidoPK id;

    @NotNull
    @ManyToOne
    private ItemCardapio itemCardapio;
}
