package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.AssociacaoModel;

@Repository
public interface AssociacaoRepository extends CrudRepository<AssociacaoModel, Long> {

	
	AssociacaoModel findByCodassociacao(Long cod_associacao);
}
