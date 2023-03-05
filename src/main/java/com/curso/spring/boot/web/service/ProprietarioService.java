package com.curso.spring.boot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.web.model.ProprietarioModel;
import com.curso.spring.boot.web.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
	
	@Autowired
	ProprietarioRepository pr;
	
	public void cadastrarproprietario(ProprietarioModel proprietario) {
		pr.save(proprietario);
	}
	public <List> ProprietarioModel listarproprietario() {
		return (ProprietarioModel) pr.findAll();
	}
	public ProprietarioModel listarporcodigo(Long cod_proprietario) {
		return pr.findByCodproprietario(cod_proprietario);
	}
	

}
