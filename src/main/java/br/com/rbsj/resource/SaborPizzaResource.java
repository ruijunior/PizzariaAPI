package br.com.rbsj.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbsj.model.SaborPizza;
import br.com.rbsj.repository.SaborPizzaRepository;

@RestController
@RequestMapping("/sabores")
public class SaborPizzaResource {
	
	@Autowired
	private SaborPizzaRepository saborRepository;
	
	@GetMapping
    public List<SaborPizza> findAll() {
		return this.saborRepository.findAll();
	}

}
