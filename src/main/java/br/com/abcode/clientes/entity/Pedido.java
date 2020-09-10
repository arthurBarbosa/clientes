package br.com.abcode.clientes.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime data;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotNull
    private BigDecimal subtotal;

    @NotNull
    @Column(name = "taxa_entrega")
    private BigDecimal taxaEntrega;

    @NotNull
    private BigDecimal total;

    @OneToOne(mappedBy = "pedido")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER)
    private Set<ItemPedido> itens = new HashSet<>();
}
