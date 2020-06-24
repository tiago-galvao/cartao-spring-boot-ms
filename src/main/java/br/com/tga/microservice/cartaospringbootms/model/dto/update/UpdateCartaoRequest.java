package br.com.tga.microservice.cartaospringbootms.model.dto.update;

import javax.validation.constraints.NotNull;

import br.com.tga.microservice.cartaospringbootms.model.Cartao;
import lombok.Getter;
import lombok.Setter;

public class UpdateCartaoRequest {

    @NotNull 
    @Getter @Setter private Boolean ativo;

    public UpdateCartaoRequest(){}

    public UpdateCartaoRequest(Cartao cartao){
        this.ativo = cartao.getAtivo();
    }
    
}