package br.com.rbsj.resource;

import java.util.List;

import br.com.rbsj.event.ResourceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.rbsj.model.Pedido;
import br.com.rbsj.service.PedidoService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Pedido> buscarPor(@PathVariable("id") Long id){
		return pedidoService.buscarPor(id).map(pedido -> {
			 		return ResponseEntity.ok(pedido);
		}).orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping
    public List<Pedido> findAll() {
		return pedidoService.todos();
	}

	@PostMapping
	public ResponseEntity<Pedido> salvar(@RequestBody @Valid Pedido pedido, HttpServletResponse response){

		Pedido pedidoSalvo = pedidoService.salvar(pedido);

		publisher.publishEvent(new ResourceEvent(this, response, pedidoSalvo.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
	}

	@PutMapping
	public void atualizar(@RequestBody @Valid Pedido pedido){
		pedidoService.salvar(pedido);
	}

}
