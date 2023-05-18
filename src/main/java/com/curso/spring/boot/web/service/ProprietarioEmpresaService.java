package com.curso.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.boot.web.model.Proprietario_EmpresaModel;
import com.curso.spring.boot.web.repository.ProprietarioempresaRepository;

@Service
public class ProprietarioEmpresaService {

	@Autowired
	ProprietarioempresaRepository per;
	
	public void salvarempresa(Proprietario_EmpresaModel empresa) {
		per.save(empresa);
	}
	
	public List<Proprietario_EmpresaModel> listarempresa(){
		return (List<Proprietario_EmpresaModel>) per.findAll();
		
	}
	
	public Proprietario_EmpresaModel listarempresaporcodigo(Long cod_empresa) {
		return per.findBycodproprietarioemepresa(cod_empresa);
	}
}
