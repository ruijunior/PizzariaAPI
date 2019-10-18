package br.com.rbsj.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbsj.model.PersonalizarPizza;
import br.com.rbsj.repository.PersonalizarPizzaRepository;

@RestController
@RequestMapping("/personalizacoes")
public class PersonalizarPizzaResource {
	
	@Autowired
	private PersonalizarPizzaRepository personalizarRepository;
	
	@GetMapping
    public List<PersonalizarPizza> findAll() {
		return this.personalizarRepository.findAll();
	}

}
