package com.curso.spring.boot.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Entity(name="proprietario")
public abstract class ProprietarioModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codproprietario;
	private String nome;
	private String bairro;
	private String cidade;
	private String tipolicenca;
	private String provincia;
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Long getCodproprietario() {
		return codproprietario;
	}
	public void setCodproprietario(Long codproprietario) {
		this.codproprietario = codproprietario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@OneToMany(mappedBy="proprietario")
	private List<TransporteModel> transportes;
	public String getTipolicenca() {
		return tipolicenca;
	}
	public void setTipolicenca(String tipolicenca) {
		this.tipolicenca = tipolicenca;
	}
	public List<TransporteModel> getTransportes() {
		return transportes;
	}
	public void setTransportes(List<TransporteModel> transportes) {
		this.transportes = transportes;
	}

}
