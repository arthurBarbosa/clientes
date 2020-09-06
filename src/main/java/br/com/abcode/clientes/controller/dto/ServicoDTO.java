package br.com.abcode.clientes.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServicoDTO {

    @NotBlank(message = "{campo.descricao.obrigatorio}")
    private  String descricao;

    @NotBlank(message = "{campo.preco.obrigatorio}")
    private String preco;

    @NotBlank(message = "{campo.data.obrigatorio}")
    private String data;

    @NotNull(message = "{campo.cliente.obrigatorio}")
    private Integer clienteId;
}
