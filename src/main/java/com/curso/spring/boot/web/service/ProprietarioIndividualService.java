package com.curso.spring.boot.web.service;

import com.curso.spring.boot.web.model.Proprietario_individualModel;
import com.curso.spring.boot.web.repository.ProprietarioIndividualRepo;
import com.curso.spring.boot.web.repository.proprietarioIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.web.repository.ProprietarioRepository;

@Service
public class ProprietarioIndividualService {
	
	@Autowired
	ProprietarioIndividualRepo pri;
	
	public void cadastrarproprietario(Proprietario_individualModel proprietarioIndividual) {
		pri.save(proprietarioIndividual);
	}
	public <List> Proprietario_individualModel listarproprietario() {
		return (Proprietario_individualModel) pri.findAll();
	}
	public Proprietario_individualModel listarporcodigo(Long cod_proprietario) {
		return pri.finfByCodproprietarioIndividual(cod_proprietario);
	}
	

}
