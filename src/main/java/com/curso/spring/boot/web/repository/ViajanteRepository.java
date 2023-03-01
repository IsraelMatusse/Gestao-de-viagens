package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.ViajanteModel;

@Repository
public interface ViajanteRepository extends CrudRepository <ViajanteModel, Long> {

	 ViajanteModel findBycodigo(Long cod_viajante);
}
