package com.curso.spring.boot.web.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.boot.web.model.AssociacaoModel;
import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.repository.ViagemRepository;
import com.curso.spring.boot.web.repository.ViajantesDestino;


@Service
public class ViagemService {
	
	@Autowired
	ViagemRepository vr;
	
	public void salvarViagem( ViagemModel viagem) {
		viagem.setChaveviagem(UUID.randomUUID().toString().substring(0, 5));
		vr.save(viagem);
	}
	
	public List<ViagemModel> listarViagens(){
		return (List<ViagemModel>) vr.findAll();
	}
	
	public ViagemModel listarporCodigo(Long cod_viagem) {
		return vr.findBycodviagem(cod_viagem);
	}
	
	 public List<ViagemModel> getByKeyword(String keyword){
		  return vr.findByKeyword(keyword);
		 }
	 public void apagarviagem(Long cod_viagem, ViagemModel viagem) {
		 vr.delete(viagem);
	 }
	 
	 public List <ViajantesDestino> viajantesdestino(String destino_viagem){
		 return vr.findByDestino(destino_viagem);
	 }
	 public List <ViajantesDestino> viajantesporchave(String chaveviagem){
		 return vr.findByChave(chaveviagem);	 }

}
