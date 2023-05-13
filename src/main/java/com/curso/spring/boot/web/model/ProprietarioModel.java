package com.curso.spring.boot.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Data
@Entity(name="proprietario")
public abstract class ProprietarioModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codproprietario;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String bairro;
	@Column(nullable=false)
	private String cidade;
	@Column(nullable=false)
	private String tipolicenca;
	@Column(nullable=false)
	private String provincia;

	@OneToMany(mappedBy="proprietario", cascade = CascadeType.ALL)
	private List<TransporteModel> transporte;
	public List<TransporteModel> getTransporte() {
		return transporte;
	}
	public void setTransporte(List<TransporteModel> transporte) {
		this.transporte = transporte;
	}
	

}
