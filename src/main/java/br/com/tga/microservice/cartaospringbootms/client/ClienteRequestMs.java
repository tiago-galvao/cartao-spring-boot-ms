package br.com.tga.microservice.cartaospringbootms.client;

import lombok.Getter;
import lombok.Setter;

public class ClienteRequestMs {
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
}