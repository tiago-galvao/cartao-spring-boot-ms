package br.com.tga.microservice.cartaospringbootms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tga.microservice.cartaospringbootms.model.dto.create.CreateCartaoRequest;
import br.com.tga.microservice.cartaospringbootms.model.dto.create.CreateCartaoResponse;
import br.com.tga.microservice.cartaospringbootms.model.dto.get.GetCartaoResponse;
import br.com.tga.microservice.cartaospringbootms.model.dto.update.UpdateCartaoRequest;
import br.com.tga.microservice.cartaospringbootms.model.dto.update.UpdateCartaoResponse;
import br.com.tga.microservice.cartaospringbootms.service.CartaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateCartaoResponse create(@RequestBody @Valid CreateCartaoRequest createCartaoRequest) {
        return cartaoService.create(createCartaoRequest);
    }

    @GetMapping("/{numero}")
    public GetCartaoResponse getByNumero(@PathVariable String numero) {
        return cartaoService.findByNumero(numero).getBody();
    }
    
    @PatchMapping("/{numero}")
    public UpdateCartaoResponse update(@PathVariable String numero, @Valid @RequestBody UpdateCartaoRequest updateCartaoRequest) {
        return cartaoService.update(numero, updateCartaoRequest);
    }

    @GetMapping("/idCartao/{id}")
    public GetCartaoResponse findById(@PathVariable Long id) {
        return cartaoService.findById(id).getBody();
    }

}