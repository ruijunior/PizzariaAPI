package br.com.rbsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rbsj.model.TamanhoPizza;

public interface TamanhoPizzaRepository extends JpaRepository<TamanhoPizza, Integer> {

}
