package com.curso.spring.boot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.MotoristaModel;


@Repository
public interface MotoristaRepository extends CrudRepository <MotoristaModel , Long> {

	MotoristaModel findByCodigo(Long cod_motorista);
	
	@Query(value = "select * from motorista m where m.nome like %:keyword% or m.apelido like %:keyword%  or m.email like %:keyword%" , nativeQuery = true)
	 List<MotoristaModel> findByKeyword(@Param("keyword") String keyword);
}
