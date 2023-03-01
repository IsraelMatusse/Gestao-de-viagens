package com.curso.spring.boot.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="motorista")

public class MotoristaModel extends PessoaModel {
	
	

	
	public String getNrcarta() {
		return nrcarta;
	}
	public void setNrcarta(String nrcarta) {
		this.nrcarta = nrcarta;
	}
	public String getNivelcarta() {
		return nivelcarta;
	}
	public void setNivelcarta(String nivelcarta) {
		this.nivelcarta = nivelcarta;
	}
	private String nrcarta;
	private String nivelcarta;


	
	@OneToOne
	private TransporteModel transporte;
}
