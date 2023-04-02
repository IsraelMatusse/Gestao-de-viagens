package com.curso.spring.boot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.model.ViajanteModel;

@Repository
public interface ViajanteRepository extends CrudRepository <ViajanteModel, Long> {

	 ViajanteModel findBycodigo(Long cod_viajante);
	 
	 @Query(value = "select * from viajante s where s.nome like %:keyword% or s.apelido like %:keyword%", nativeQuery = true)
	 List<ViajanteModel> findByKeyword(@Param("keyword") String keyword);
}
