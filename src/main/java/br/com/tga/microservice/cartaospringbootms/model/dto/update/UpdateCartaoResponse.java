package br.com.tga.microservice.cartaospringbootms.model.dto.update;

import br.com.tga.microservice.cartaospringbootms.model.Cartao;
import lombok.Getter;
import lombok.Setter;

public class UpdateCartaoResponse {
    
    @Getter @Setter private Long id;
    @Getter @Setter private String numero;
    @Getter @Setter private Long clienteId;
    @Getter @Setter private Boolean ativo;

    public UpdateCartaoResponse(){}

    public UpdateCartaoResponse(Cartao cartao){
        this.id = cartao.getId();
        this.numero = cartao.getNumero();
        this.clienteId = cartao.getClienteId();
        this.ativo = cartao.getAtivo();
    }
}