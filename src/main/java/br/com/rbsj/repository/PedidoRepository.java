package br.com.rbsj.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rbsj.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido,Long>{

}
