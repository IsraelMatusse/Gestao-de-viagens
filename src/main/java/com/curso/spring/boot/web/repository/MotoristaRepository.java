package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.MotoristaModel;

@Repository
public interface MotoristaRepository extends CrudRepository <MotoristaModel , Long> {

	MotoristaModel findByCodigo(Long cod_motorista);
}
