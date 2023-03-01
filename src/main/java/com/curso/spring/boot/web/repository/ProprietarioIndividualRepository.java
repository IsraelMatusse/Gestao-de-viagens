package com.curso.spring.boot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.Proprietario_individualModel;

@Repository
public interface ProprietarioIndividualRepository extends CrudRepository <Proprietario_individualModel, Long> {

}
