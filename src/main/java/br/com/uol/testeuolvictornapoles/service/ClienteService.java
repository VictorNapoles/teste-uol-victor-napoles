package br.com.uol.testeuolvictornapoles.service;

import java.util.List;
import java.util.Optional;

import br.com.uol.testeuolvictornapoles.entity.Cliente;

public interface ClienteService {
	
	Optional<List<Cliente>> obterTodos();
	Cliente inserir(Cliente cliente);
	Cliente alterar(Cliente cliente);
	Optional<Cliente> obterPorId(Long id);
	void remover(Long id);
	
	
	

}
