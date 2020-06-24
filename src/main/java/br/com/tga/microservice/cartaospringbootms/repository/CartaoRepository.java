package br.com.tga.microservice.cartaospringbootms.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import br.com.tga.microservice.cartaospringbootms.model.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {
    Optional<Cartao> findByNumero(String numero);
}