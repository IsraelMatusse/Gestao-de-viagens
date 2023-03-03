package com.curso.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.web.model.AssociacaoModel;
import com.curso.spring.boot.web.repository.AssociacaoRepository;

@Service
public class AssociacaoService {
	
	@Autowired
	AssociacaoRepository ar;
	
	public void cadastrarassociacao(AssociacaoModel associacao) {
		ar.save(associacao);
	}
	
	public List<AssociacaoModel> listarassociacao() {
		return (List<AssociacaoModel>) ar.findAll();
	}
	
	public AssociacaoModel listarporcodigo(Long cod_associacao) {
		return ar.findByCodassociacao(cod_associacao);
	}

}
