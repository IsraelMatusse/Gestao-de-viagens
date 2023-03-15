package com.curso.spring.boot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.curso.spring.boot.web.model.ViagemModel;

@Repository
public interface ViagemRepository extends CrudRepository<ViagemModel, String>{

	ViagemModel findBycodviagem(Long cod_viagem);
	
	 @Query(value = "select * from viagem s where s.destinoviagem like %:keyword% like %:keyword%", nativeQuery = true)
	 List<ViagemModel> findByKeyword(@Param("keyword") String keyword);
}
