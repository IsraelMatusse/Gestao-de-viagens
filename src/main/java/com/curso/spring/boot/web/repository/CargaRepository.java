package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.CargaModel;

@Repository
public interface CargaRepository extends CrudRepository <CargaModel, Long> {
	
	CargaModel findBycodcarga(Long codcarga);

}
