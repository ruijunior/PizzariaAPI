package br.com.rbsj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rbsj.model.Pedido;
import br.com.rbsj.repository.PedidoRepository;

@Service
public class PedidoServicoImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Pedido salvar(Pedido pedido) {

		pedido.concluir();
		return this.pedidoRepository.saveAndFlush(pedido);
	}

	@Override
	public Optional<Pedido> buscarPor(Long id) {
		return this.pedidoRepository.findById(id);
	}

	@Override
	public List<Pedido> todos() {
		return this.pedidoRepository.findAll();
	}

}
