package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.spring.boot.web.model.RotaModel;

public interface RotaRepository extends CrudRepository <RotaModel, Long> {
	
	RotaModel findBycodrota(Long cod_rota);

}
