package br.com.uol.testeuolvictornapoles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uol.testeuolvictornapoles.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {}
