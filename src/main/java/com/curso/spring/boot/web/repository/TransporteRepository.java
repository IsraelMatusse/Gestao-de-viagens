package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.MotoristaModel;
import com.curso.spring.boot.web.model.TransporteModel;

@Repository
public interface TransporteRepository extends CrudRepository <TransporteModel, Long>{

	TransporteModel findByCodtransporte(Long cod_trnapsorte);


}
