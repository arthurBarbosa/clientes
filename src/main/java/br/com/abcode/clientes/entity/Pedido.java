package br.com.abcode.clientes.entity;

import br.com.abcode.clientes.enums.StatusPedidoEnum;
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

    private StatusPedidoEnum status;

    @OneToOne(mappedBy = "pedido")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER)
    private Set<ItemPedido> itens = new HashSet<>();

    /**
     * Responsável por definir o proximo status do pedido
     */
    public void definirProximoStatus() {
        int ordem = status.getOrdem();
        StatusPedidoEnum newStatus = StatusPedidoEnum.fromOrdem(ordem + 1);
        if (newStatus != null) {
            this.status = newStatus;
        }
    }
}
