package br.com.tga.microservice.cartaospringbootms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import br.com.tga.microservice.cartaospringbootms.client.ClienteClient;
import br.com.tga.microservice.cartaospringbootms.exception.CartaoAlreadyExistsException;
import br.com.tga.microservice.cartaospringbootms.exception.CartaoNotFoundException;
import br.com.tga.microservice.cartaospringbootms.exception.ClienteNotFoundException;
import br.com.tga.microservice.cartaospringbootms.model.Cartao;
import br.com.tga.microservice.cartaospringbootms.model.dto.create.CreateCartaoRequest;
import br.com.tga.microservice.cartaospringbootms.model.dto.create.CreateCartaoResponse;
import br.com.tga.microservice.cartaospringbootms.model.dto.get.GetCartaoResponse;
import br.com.tga.microservice.cartaospringbootms.model.dto.update.UpdateCartaoRequest;
import br.com.tga.microservice.cartaospringbootms.model.dto.update.UpdateCartaoResponse;
import br.com.tga.microservice.cartaospringbootms.repository.CartaoRepository;
import feign.FeignException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {
    
    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private CartaoRepository cartaoRepository;


    @Transactional
    public CreateCartaoResponse create(final CreateCartaoRequest cartaoRequest) {

        try {
            clienteClient.getById(cartaoRequest.getClienteId());
            final Optional<Cartao> byNumero = cartaoRepository.findByNumero(cartaoRequest.getNumero());
            final Cartao cartao = new Cartao();

            if (byNumero.isPresent()) {
                throw new CartaoAlreadyExistsException();
            }
            cartao.setNumero(cartaoRequest.getNumero());
            cartao.setClienteId(cartaoRequest.getClienteId());
            cartao.setAtivo(Boolean.FALSE);
            return new CreateCartaoResponse(cartaoRepository.save(cartao));
        } catch (final FeignException.NotFound e) {
            throw new ClienteNotFoundException();
        }
    }

    public ResponseEntity<GetCartaoResponse> findByNumero(String numero){
        Optional<Cartao> optional = cartaoRepository.findByNumero(numero);
        if(!optional.isPresent()){
          throw new CartaoNotFoundException();
        }
        return ResponseEntity.ok(new GetCartaoResponse(optional.get()));
    }

    public ResponseEntity<GetCartaoResponse> findById(Long id){
        Optional<Cartao> optional = cartaoRepository.findById(id);
        if(!optional.isPresent()){
          throw new CartaoNotFoundException();
        }
        return ResponseEntity.ok(new GetCartaoResponse(optional.get()));
    }

    public UpdateCartaoResponse update(String numero ,UpdateCartaoRequest updateCartaoRequest) {
        final Optional<Cartao> byNumero = cartaoRepository.findByNumero(numero);
        if (!byNumero.isPresent()) {
            throw new CartaoNotFoundException();
        }
        byNumero.get().setAtivo(updateCartaoRequest.getAtivo());
        return new UpdateCartaoResponse(cartaoRepository.save(byNumero.get()));
    }

}