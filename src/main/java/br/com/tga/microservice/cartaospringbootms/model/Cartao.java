package br.com.tga.microservice.cartaospringbootms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column(unique = true)
    @Getter @Setter private String numero;

    @Column
    @Getter @Setter private Long clienteId;

    @Column
    @Getter @Setter private Boolean ativo;

    public Cartao(){}

    public Cartao(Long id, String numero, Long clienteId, Boolean ativo){
        this.id = id;
        this.numero = numero;
        this.clienteId = clienteId;
        this.ativo = ativo;
    }

    public Cartao(String numero, Long clienteId){
        this.numero = numero;
        this.clienteId = clienteId;
    }

}