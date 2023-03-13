package com.curso.spring.boot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.web.model.CargaModel;
import com.curso.spring.boot.web.repository.CargaRepository;

@Service
public class CargaService {
	
	@Autowired
	CargaRepository cr;
	
	public void salvarcarga(CargaModel carga) {
		cr.save(carga);
	}
	
	public <List>CargaModel listarcarga(){
		return (CargaModel) cr.findAll();
	}
	
	public CargaModel listarporcodigo(Long codcarga) {
		return cr.findBycodcarga(codcarga);
	}

}
