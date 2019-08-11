package br.com.uol.testeuolvictornapoles.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uol.testeuolvictornapoles.entity.Cliente;
import br.com.uol.testeuolvictornapoles.repository.ClienteRepository;
import br.com.uol.testeuolvictornapoles.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Optional<List<Cliente>>  obterTodos() {
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public Cliente inserir(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente alterar(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Optional<Cliente> obterPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public void remover(Long id) {
		repository.deleteById(id);

	}

}
