package com.curso.spring.boot.web.service;

import com.curso.spring.boot.web.model.Proprietario_individualModel;
import com.curso.spring.boot.web.repository.ProprietarioIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProprietarioIndividualService {
	
	@Autowired
	ProprietarioIndividualRepository pri;
	
	public void cadastrarproprietario(Proprietario_individualModel proprietarioIndividual) {
		pri.save(proprietarioIndividual);
	}
	public List<Proprietario_individualModel> listarproprietario() {
		return  pri.findAll();
	}
	public Proprietario_individualModel listarporcodigo(Long cod_proprietario) {
		return pri.findByCodproprietarioindividual(cod_proprietario);
	}
	

}
