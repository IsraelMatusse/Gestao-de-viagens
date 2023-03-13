package com.curso.spring.boot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.AssociacaoModel;

@Repository
public interface AssociacaoRepository extends CrudRepository<AssociacaoModel, Long> {

	
	AssociacaoModel findByCodassociacao(Long cod_associacao);
	AssociacaoModel findByNomeassociacao(String nomeassociacao);
	AssociacaoModel findByEmailassociacao(String emailassociacao);

	 @Query(value = "select * from associacao s where s.nomeassociacao like %:keyword% or s.emailassociacao like %:keyword%", nativeQuery = true)
	 List<AssociacaoModel> findByKeyword(@Param("keyword") String keyword);
}
