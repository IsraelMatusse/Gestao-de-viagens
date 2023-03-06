package com.curso.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.web.model.RotaModel;
import com.curso.spring.boot.web.repository.RotaRepository;

@Service
public class RotaService {
	
	@Autowired
	RotaRepository rr;
	
	public void salvarrota(RotaModel rota) {
		rr.save(rota);
	}
	
	public List<RotaModel> listarotas(){
		return (List<RotaModel>) rr.findAll();
		
	}
	
	public RotaModel listarporcodigo(Long cod_rota){
		return rr.findBycodrota(cod_rota);
	}
	

}
