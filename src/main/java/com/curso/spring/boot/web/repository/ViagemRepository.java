package com.curso.spring.boot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.curso.spring.boot.web.model.ViagemModel;

import DTO.ViagemDTO;

@Repository
public interface ViagemRepository extends CrudRepository<ViagemModel, String>{

	ViagemModel findBycodviagem(Long cod_viagem);
	
	 @Query(value = "select * from viagem s where s.destino_viagem like %:keyword%", nativeQuery = true)
	 List<ViagemModel> findByKeyword(@Param("keyword") String keyword);
	 
	 @Query(value="select viajante.nome as Nome, viagem.destino_viagem as DestinoViagem from viajante join viagem_viajante on viajante.codigo= viajante_fk join viagem on viagem_fk=viagem.codviagem  where destino_viagem Like %:destino_viagem%", nativeQuery=true)
	 List<ViajantesDestino> findByDestino(@Param("destino_viagem") String destino_viagem);

	 @Query(value="select viagem.chaveviagem as ChaveViagem, viajante.nome as Nome, viagem.destino_viagem as Destino_Viagem  from viagem join viagem_viajante on viagem.codviagem=viagem_fk join viajante on viajante_fk=viajante.codigo where chaveviagem like %:chaveviagem%", nativeQuery=true)
	 List<ViajantesDestino>findByChave(@Param("chaveviagem") String chaveviagem);
	 
	 
	 @Query(value="select destino_viagem, count(destino_viagem) as 'mumero de viagens' from viagem group by destino_viagem asc")
	 List<ViajantesDestino>findDetino();
}
