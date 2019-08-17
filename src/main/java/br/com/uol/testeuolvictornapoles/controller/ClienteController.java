package br.com.uol.testeuolvictornapoles.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uol.testeuolvictornapoles.entity.Cliente;
import br.com.uol.testeuolvictornapoles.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity obterTodos() {

		ResponseEntity<List<Cliente>> noContent = ResponseEntity.noContent().build();
		return service.obterTodos().map((l) -> {

			if (l.isEmpty())
				return noContent;

			return ResponseEntity.ok().body(l);
		}).orElse(noContent);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("{id}")
	public ResponseEntity obterPorId(@PathVariable("id") Long id) {

		return service.obterPorId(id).map((c) -> {
			return ResponseEntity.ok().body(c);
		}).orElse(ResponseEntity.noContent().build());
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity inserir(@RequestBody @Valid Cliente cliente) {

		cliente = service.inserir(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@PutMapping
	public ResponseEntity alterar(@RequestBody @Valid Cliente cliente) {

		try {
			cliente = service.alterar(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity remover(@PathVariable("id") Long id) {

		try {
			service.remover(id);
			return new ResponseEntity<Cliente>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
