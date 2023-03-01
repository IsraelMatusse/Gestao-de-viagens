package com.curso.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.boot.web.model.MotoristaModel;
import com.curso.spring.boot.web.model.TransporteModel;
import com.curso.spring.boot.web.repository.TransporteRepository;

@Transactional
@Service
public class TransporteService {
	
	@Autowired 
	TransporteRepository tr;
	
	public void cadastrartransporte(TransporteModel transporte) {
		 tr.save(transporte);
	}
	
	public List<TransporteModel> listarmotorista(){
		return (List<TransporteModel>) tr.findAll();
	}
	
	public TransporteModel listarporcodigo(Long cod_transporte) {
		return tr.findByCodtransporte(cod_transporte);
	}

}
