package br.com.tga.microservice.cartaospringbootms.model.dto.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tga.microservice.cartaospringbootms.model.Cartao;
import lombok.Getter;
import lombok.Setter;

public class CreateCartaoRequest {

    @NotBlank @NotNull
    @Getter @Setter private String numero;

    @NotNull
    @Getter @Setter private Long clienteId;

    public Cartao converter() {
        return new Cartao(numero, clienteId);
      }
}