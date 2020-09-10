package br.com.abcode.clientes.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ItemPedidoPK implements Serializable {

    @NotNull
    @ManyToOne
    private Pedido pedido;

    @NotNull
    private Integer ordem;
}
