package com.curso.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.boot.web.model.ViagemModel;
import com.curso.spring.boot.web.repository.ViagemRepository;


@Service
public class ViagemService {
	
	@Autowired
	ViagemRepository vr;
	
	public void salvarViagem( ViagemModel viagem) {
		vr.save(viagem);
	}
	
	public List<ViagemModel> listarViagens(){
		return (List<ViagemModel>) vr.findAll();
	}
	
	public ViagemModel listarporCodigo(Long cod_viagem) {
		return vr.findBycodviagem(cod_viagem);
	}

}
