package com.curso.spring.boot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="proprietario_individual")
public class Proprietario_individualModel extends ProprietarioModel{
	
	@Column(nullable=false)
	private Double anonascimento;
	@Column(nullable=false)
	private String bi;
	public Double getAnonascimento() {
		return anonascimento;
	}
	public void setAnonascimento(Double anonascimento) {
		this.anonascimento = anonascimento;
	}
	public String getBi() {
		return bi;
	}
	public void setBi(String bi) {
		this.bi = bi;
	}
	
}
