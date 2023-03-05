package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.spring.boot.web.model.ProprietarioModel;

public interface ProprietarioRepository extends CrudRepository<ProprietarioModel, Long> {

	ProprietarioModel findByCodproprietario(Long cod_proprietario);
}
