package br.com.tga.microservice.cartaospringbootms.model.dto.create;

import br.com.tga.microservice.cartaospringbootms.model.Cartao;
import lombok.Getter;
import lombok.Setter;

public class CreateCartaoResponse {
    @Getter @Setter private Long id;
    @Getter @Setter private String numero;
    @Getter @Setter private Long clienteId;
    @Getter @Setter private Boolean ativo;

    public CreateCartaoResponse(){}

    public CreateCartaoResponse(Cartao cartao){
        this.id = cartao.getId();
        this.numero = cartao.getNumero();
        this.clienteId = cartao.getClienteId();
        this.ativo = cartao.getAtivo();
    }
}