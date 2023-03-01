package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.ViagemModel;

@Repository
public interface ViagemRepository extends CrudRepository<ViagemModel, String>{

	ViagemModel findBycodviagem(Long cod_viagem);
}
