package br.com.rbsj.service;

import java.util.List;
import java.util.Optional;

import br.com.rbsj.model.Pedido;

public interface PedidoService {
	
	public Pedido salvar(Pedido pedido);
	public Optional<Pedido> buscarPor(Long id);
	public List<Pedido> todos();

}
