package br.com.abcode.clientes.enums;

import lombok.Getter;

@Getter
public enum StatusPedidoEnum {

    Producao(1, "Em produção", false),
    Entrega(2, "Saiu para entrega", false),
    Concluido(3, "Concluido", true);

    int ordem;
    String descricao;
    boolean ultimo;
    StatusPedidoEnum(int ordem, String descricao, boolean ultimo) {
        this.ordem = ordem;
        this.descricao = descricao;
        this.ultimo = ultimo;
    }

    public static StatusPedidoEnum fromOrdem(int ordem) {
        for (StatusPedidoEnum status : StatusPedidoEnum.values()) {
            if (status.getOrdem() == ordem) {
                return status;
            }
        }
        return null;
    }
}
