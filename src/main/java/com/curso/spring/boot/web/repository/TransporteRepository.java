package com.curso.spring.boot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.curso.spring.boot.web.model.TransporteModel;

@Repository
public interface TransporteRepository extends CrudRepository <TransporteModel, Long>{

	TransporteModel findByCodtransporte(Long cod_trnapsorte);
	
	 @Query(value = "select * from transporte t where t.modelo like %:keyword% or t.marca like %:keyword%  or t.nrmotor like %:keyword% or t.matricula like %:keyword%" , nativeQuery = true)
	 List<TransporteModel> findByKeyword(@Param("keyword") String keyword);

	 //viagens realizadas por matricula de carro
	 
	 @Query(value="select count(transporte_codtransporte) as NumeroViagens, matricula as Matricula from transporte join viagem on transporte_codtransporte= transporte.codtransporte group  by matricula", nativeQuery=true)
	 List <Viagensrealizadas> viagensrealizadas();
}
