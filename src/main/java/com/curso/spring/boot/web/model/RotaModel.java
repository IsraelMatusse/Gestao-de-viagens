package com.curso.spring.boot.web.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="rota")
public class RotaModel {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codrota;
	private String nomerota;
	private Long distancia;
	public Long getCodrota() {
		return codrota;
	}
	public void setCodrota(Long codrota) {
		this.codrota = codrota;
	}
	public String getNomerota() {
		return nomerota;
	}
	public void setNomerota(String nomerota) {
		this.nomerota = nomerota;
	}
	public Long getDistancia() {
		return distancia;
	}
	public void setDistancia(Long distancia) {
		this.distancia = distancia;
	}
	
	@ManyToMany(mappedBy="rotas")
	private List<AssociacaoModel> associacoes;
	public List<AssociacaoModel> getAssociacoes() {
		return associacoes;
	}
	public void setAssociacoes(List<AssociacaoModel> associacoes) {
		this.associacoes = associacoes;
	}
	
}
