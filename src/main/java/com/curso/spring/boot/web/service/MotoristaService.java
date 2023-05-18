package com.curso.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.web.model.MotoristaModel;
import com.curso.spring.boot.web.repository.MotoristaRepository;

@Service
public class MotoristaService {

	@Autowired
	MotoristaRepository mr;
	public void cadastrarmotorista(MotoristaModel motorista) {
		mr.save(motorista);
		
	}
	
	public List <MotoristaModel> listarmostoristas() {
		return (List<MotoristaModel>) mr.findAll();
		
	}
	
	public MotoristaModel listarporcodigo(Long cod_motorista) {
		return mr.findByCodmotorista(cod_motorista);
	}
	
	public List<MotoristaModel> searchmotorista(String keyword){
		return mr.findByKeyword(keyword);
	}
	
	public void deletemotorista(MotoristaModel motorista, Long cod_motorista) {
		mr.delete(motorista);
	}
}
