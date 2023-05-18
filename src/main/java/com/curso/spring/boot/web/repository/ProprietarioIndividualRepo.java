package com.curso.spring.boot.web.repository;

import com.curso.spring.boot.web.model.Proprietario_individualModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioIndividualRepo extends CrudRepository<Proprietario_individualModel, Long> {
    Proprietario_individualModel finfByCodproprietarioIndividual(Long cod_proprietrio);
}
