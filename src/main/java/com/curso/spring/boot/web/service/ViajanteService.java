package com.curso.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.model.ViajanteModel;
import com.curso.spring.boot.web.repository.ViajanteRepository;
@Transactional
@Service
public class ViajanteService {

	@Autowired
	private ViajanteRepository  vvr;
	

	public void salvarViajante(ViajanteModel viajante) {
		vvr.save(viajante);
		
	}
	
	public List<ViajanteModel> listarViajantes() {
	return	 (List<ViajanteModel>) vvr.findAll();
		
	}
	
	public ViajanteModel ListarporCodigo(Long cod_viajante) {
		return vvr.findBycodigo(cod_viajante);
		
	}
	
	 public void apagarviajante(Long cod_viajante, ViajanteModel viajante) {
		 vvr.delete(viajante);
	 }
	 public List<ViajanteModel> getByKeyword(String keyword){
		  return vvr.findByKeyword(keyword);
		 }
	
	
}
