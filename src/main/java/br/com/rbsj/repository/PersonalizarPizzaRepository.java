package br.com.rbsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rbsj.model.PersonalizarPizza;

public interface PersonalizarPizzaRepository extends JpaRepository<PersonalizarPizza, Long> {

}
