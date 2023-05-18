package com.curso.spring.boot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.curso.spring.boot.web.model.Proprietario_EmpresaModel;

public interface ProprietarioempresaRepository extends JpaRepository<Proprietario_EmpresaModel, Long> {

	Proprietario_EmpresaModel findBycodproprietarioemepresa(Long cod_empresa);
	
}
