package com.curso.spring.boot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="proprietario_empresa")
public class Proprietario_EmpresaModel extends ProprietarioModel {
	
	@Column(nullable=false)
	private Double nuit;
	@Column(nullable=false)
	private String alvara;
	@Column(nullable=false)
	private Long anocriacao;
	public Double getNuit() {
		return nuit;
	}
	public void setNuit(Double nuit) {
		this.nuit = nuit;
	}
	public String getAlvara() {
		return alvara;
	}
	public void setAlvara(String alvara) {
		this.alvara = alvara;
	}
	public Long getAnocriacao() {
		return anocriacao;
	}
	public void setAnocriacao(Long anocriacao) {
		this.anocriacao = anocriacao;
	}
	
}
