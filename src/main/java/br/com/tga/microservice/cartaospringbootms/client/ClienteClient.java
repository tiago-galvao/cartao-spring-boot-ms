package br.com.tga.microservice.cartaospringbootms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cliente-spring-boot-ms")
public interface ClienteClient {

    @GetMapping("/cliente/{id}")
    ClienteRequestMs getById(@PathVariable Long id);
    
}