package br.com.rbsj.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbsj.model.TamanhoPizza;
import br.com.rbsj.repository.TamanhoPizzaRepository;

@RestController
@RequestMapping("/tamanhos")
public class TamanhoPizzaResource {

	@Autowired
	private TamanhoPizzaRepository tamanhoRepository;
	
	@GetMapping
    public List<TamanhoPizza> findAll() {
		return this.tamanhoRepository.findAll();
	}
}
