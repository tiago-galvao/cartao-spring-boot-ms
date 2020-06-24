package br.com.tga.microservice.cartaospringbootms.model.dto.get;

import br.com.tga.microservice.cartaospringbootms.model.Cartao;
import lombok.Getter;
import lombok.Setter;

public class GetCartaoResponse {
    
    @Getter @Setter private Long id;
    @Getter @Setter private String numero;
    @Getter @Setter private Long clienteId;

    public GetCartaoResponse(){}

    public GetCartaoResponse(Cartao cartao){
        this.id = cartao.getId();
        this.numero = cartao.getNumero();
        this.clienteId = cartao.getClienteId();
    }

}