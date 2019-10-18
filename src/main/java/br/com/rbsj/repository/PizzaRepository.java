package br.com.rbsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rbsj.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
