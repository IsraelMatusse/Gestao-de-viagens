package com.curso.spring.boot.web.repository;

import com.curso.spring.boot.web.model.Proprietario_individualModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioIndividualRepository extends JpaRepository<Proprietario_individualModel, Long> {
    Proprietario_individualModel findByCodproprietarioindividual(Long cod_proprietrioindividual);
}
